package tech.wetech.example.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import tech.wetech.example.hibernate.HibernateUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DatapoolRepositoryImpl implements DatapoolRepository {

    @Override
    public List<Map<String, Object>> findAll(String entId, String tableId) {
        Session session = HibernateUtils.openSession(entId, tableId);
        String entityName = HibernateUtils.getEntityName(entId, tableId);
        Query query = session.createQuery("from " + entityName);
        List list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Map<String, Object>> findBy(String entId, String tableId, Map<String, Object> param) {
        long time = System.currentTimeMillis();
        Session session = HibernateUtils.openSession(entId, tableId);
        System.out.println("打开会话耗时:" + (System.currentTimeMillis() - time));
        String entityName = HibernateUtils.getEntityName(entId, tableId);
        StringBuilder qlBuilder = new StringBuilder("from ").append(entityName);
        if (!param.isEmpty()) {
            String whereClause = param.entrySet().stream()
                    .collect(Collectors.mapping(e -> String.format(" %s=:%s", e.getKey(), e.getKey()), Collectors.joining(" and", " where", "")));
            qlBuilder.append(whereClause);
        }
        Query query = session.createQuery(qlBuilder.toString());
        param.forEach((key, value) -> query.setParameter(key, value));
        List list = query.getResultList();
        System.out.println("查询耗时:" + (System.currentTimeMillis() - time));
        session.close();
        return list;
    }

    @Override
    public Long save(String entId, String tableId, Map<String, Object> data) {
        Session session = HibernateUtils.openSession(entId, tableId);
        String entityName = HibernateUtils.getEntityName(entId, tableId);
        Long id = (Long) session.save(entityName, data);
        session.close();
        return id;
    }

    @Override
    public void update(String entId, String tableId, Map<String, Object> data) {
        Session session = HibernateUtils.openSession(entId, tableId);
        String entityName = HibernateUtils.getEntityName(entId, tableId);
        session.update(entityName, data);
        session.close();
    }

    @Override
    public void saveOrUpdate(String entId, String tableId, Map<String, Object> data) {
        Session session = HibernateUtils.openSession(entId, tableId);
        String entityName = HibernateUtils.getEntityName(entId, tableId);
        session.saveOrUpdate(entityName, data);
        session.close();
    }

    @Override
    public void delete(String entId, String tableId, Map<String, Object> data) {
        Session session = HibernateUtils.openSession(entId, tableId);
        String entityName = HibernateUtils.getEntityName(entId, tableId);
        session.delete(entityName, data);
        session.close();
    }

    @Override
    public void deleteById(String entId, String tableId, Long id) {
        Session session = HibernateUtils.openSession(entId, tableId);
        String entityName = HibernateUtils.getEntityName(entId, tableId);
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        session.delete(entityName, data);
        session.close();
    }
}
