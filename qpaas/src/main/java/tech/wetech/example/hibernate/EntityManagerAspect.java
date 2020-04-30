package tech.wetech.example.hibernate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.wetech.example.SystemContextHolder;
import tech.wetech.example.entity.DatacenterField;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author cjbi
 */
@Aspect
@Component
public class EntityManagerAspect {

    @Autowired
    private EntityManager entityManager;

    @Pointcut("execution(public * javax.persistence.EntityManager.createQuery(..))")
    public void pointcut() {
    }


    @Around("pointcut()")
    public Object aroundMethod(ProceedingJoinPoint point) throws Throwable {
        if (SystemContextHolder.getTableId() == null) {
            return point.proceed();
        }
        if (!SystemContextHolder.isDynamicModel()) {
            return point.proceed();
        }
        String entId = SystemContextHolder.getEntId();
        String tableId = SystemContextHolder.getTableId();
        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
        SystemContextHolder.setDynamicModel(false);
        Query query = entityManager.createQuery("select new DatacenterField(id,type) from DatacenterField  where belongs=:belong");
        query.setParameter("belong", tableId);
        List<DatacenterField> list = query.getResultList();
        MetaDataContext metaDataContexts = MetaDataContextBuilder.buildMetaDataContexts(entId, tableId, list);
        String xmlString = MetadataSourcesGenerator.toXMLString(metaDataContexts);
        StandardServiceRegistry serviceRegistry = sessionFactory.getSessionFactoryOptions().getServiceRegistry();
        sessionFactory.getSessionFactoryOptions();
        //合并配置
        Configuration cfg = new Configuration();
        cfg.addInputStream(new ByteArrayInputStream(xmlString.getBytes()));

        SessionFactory newSessionFactory = cfg.buildSessionFactory(serviceRegistry);
        EntityManager entityManager = newSessionFactory.createEntityManager();
        return entityManager.createQuery(point.getArgs()[0].toString());
    }

}
