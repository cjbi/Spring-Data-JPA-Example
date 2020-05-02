package tech.wetech.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import tech.wetech.example.SpringUtils;
import tech.wetech.example.SystemContextHolder;
import tech.wetech.example.entity.DatacenterField;
import tech.wetech.example.repository.DatacenterFieldRepository;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * 遗留问题：由于是自定义获取session，所以事务不受Spring控制
 *
 * @author cjbi
 */
public class HibernateUtils {

    private static MetadataSources metadataSources;
    private static SessionFactory sessionFactory;

    public HibernateUtils(SessionFactory sessionFactory) {
        HibernateUtils.sessionFactory = sessionFactory;
        StandardServiceRegistry serviceRegistry = sessionFactory.getSessionFactoryOptions().getServiceRegistry();
        HibernateUtils.metadataSources = new MetadataSources(serviceRegistry);
    }

    public static boolean hasEntityMapping(String entityName) {
        return HibernateUtils.metadataSources.buildMetadata().getEntityBinding(entityName) != null;
    }

    public static Session openSession(String entId, String tableId) {
        String entityName = MetadataContextBuilder.getEntityName(entId, tableId);
        if (hasEntityMapping(entityName)) {
            return HibernateUtils.sessionFactory.openSession();
        }
        List<DatacenterField> list = getDatacenterField(entId, tableId);
        MetadataContext metadataContexts = MetadataContextBuilder.buildMetaDataContexts(entId, tableId, list);
        String xmlString = MetadataSourcesGenerator.toXMLString(metadataContexts);
        HibernateUtils.metadataSources.addInputStream(new ByteArrayInputStream(xmlString.getBytes()));
        Metadata metadata = metadataSources.buildMetadata();
        HibernateUtils.sessionFactory = metadata.buildSessionFactory();
        return HibernateUtils.sessionFactory.openSession();
    }

    public static String getEntityName(String entId, String tableId) {
        return MetadataContextBuilder.getEntityName(entId, tableId);
    }

    private static List<DatacenterField> getDatacenterField(String entId, String tableId) {
        SystemContextHolder.setEntId(entId);
        SystemContextHolder.setTableId(tableId);
        DatacenterFieldRepository datacenterFieldRepository = SpringUtils.getBean(DatacenterFieldRepository.class);
        return datacenterFieldRepository.findByBelongs(tableId);
    }

}
