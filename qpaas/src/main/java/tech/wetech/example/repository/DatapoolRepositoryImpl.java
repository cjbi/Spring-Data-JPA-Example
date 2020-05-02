package tech.wetech.example.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.wetech.example.SystemContextHolder;
import tech.wetech.example.entity.DatacenterField;
import tech.wetech.example.hibernate.MetaDataContext;
import tech.wetech.example.hibernate.MetaDataContextBuilder;
import tech.wetech.example.hibernate.MetadataSourcesGenerator;

import javax.persistence.EntityManagerFactory;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DatapoolRepositoryImpl implements DatapoolRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private DatacenterFieldRepository datacenterFieldRepository;

    private Session openSession(String entId, String tableId) {
        SystemContextHolder.setEntId(entId);
        List<DatacenterField> list = datacenterFieldRepository.findByBelongs(tableId);
        MetaDataContext metaDataContexts = MetaDataContextBuilder.buildMetaDataContexts(entId, tableId, list);
        String xmlString = MetadataSourcesGenerator.toXMLString(metaDataContexts);
        //合并配置
        Configuration cfg = new Configuration();
        cfg.addInputStream(new ByteArrayInputStream(xmlString.getBytes()));
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        StandardServiceRegistry serviceRegistry = sessionFactory.getSessionFactoryOptions().getServiceRegistry();
        SessionFactory newSessionFactory = cfg.buildSessionFactory(serviceRegistry);
        return newSessionFactory.openSession();
    }

    @Override
    public List<Map<String, Object>> findAll(String entId, String tableId) {
        Session session = openSession(entId, tableId);
        String entityName = MetaDataContextBuilder.getEntityName(entId, tableId);
        Query query = session.createQuery("from " + entityName);
        List list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Map<String, Object>> findBy(String entId, String tableId, Map<String, Object> param) {
        Session session = openSession(entId, tableId);
        String entityName = MetaDataContextBuilder.getEntityName(entId, tableId);
        StringBuilder qlBuilder = new StringBuilder("from ").append(entityName);
        String whereClause = param.entrySet().stream()
                .collect(Collectors.mapping(e -> String.format("%s=:%s", e.getKey(), e.getKey()), Collectors.joining(" and", " where", "")));
        qlBuilder.append(whereClause);
        Query query = session.createQuery(qlBuilder.toString());
        param.forEach((key, value) -> query.setParameter(key, value));
        List list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public Long save(String entId, String tableId, Map<String, Object> data) {
        Session session = openSession(entId, tableId);
        String entityName = MetaDataContextBuilder.getEntityName(entId, tableId);
        Long id = (Long) session.save(entityName, data);
        session.close();
        return id;
    }

    @Override
    public void update(String entId, String tableId, Map<String, Object> data) {
        Session session = openSession(entId, tableId);
        String entityName = MetaDataContextBuilder.getEntityName(entId, tableId);
        session.update(entityName, data);
        session.close();
    }

    @Override
    public void saveOrUpdate(String entId, String tableId, Map<String, Object> data) {
        Session session = openSession(entId, tableId);
        String entityName = MetaDataContextBuilder.getEntityName(entId, tableId);
        session.saveOrUpdate(entityName, data);
        session.close();
    }

    @Override
    public void delete(String entId, String tableId, Map<String, Object> data) {
        Session session = openSession(entId, tableId);
        String entityName = MetaDataContextBuilder.getEntityName(entId, tableId);
        session.delete(entityName, data);
        session.close();
    }

    @Override
    public void deleteById(String entId, String tableId, Long id) {
        Session session = openSession(entId, tableId);
        String entityName = MetaDataContextBuilder.getEntityName(entId, tableId);
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        session.delete(entityName, data);
        session.close();
    }
}
