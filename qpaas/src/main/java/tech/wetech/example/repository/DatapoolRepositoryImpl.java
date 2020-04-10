package tech.wetech.example.repository;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Repository;
import tech.wetech.example.entity.Datapool;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class DatapoolRepositoryImpl implements DatapoolRepository {

    @Autowired
    private EntityManager entityManager;

    private List<Datapool> getResultList(Query query) {
        //此处将会有新方法替代,但是官方还没有开发出来,所以暂时只能这么用
        return query.unwrap(NativeQuery.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .getResultList();
    }

    @Override
    public List<Datapool> findAll() {
        Query query = entityManager.createNativeQuery("select * from ent_${entId}_datapool_${appId}");
        return getResultList(query);
    }

    @Override
    public List<Datapool> findAll(Sort sort) {
        Query query = entityManager.createNativeQuery(QueryUtils.applySorting("select * from ent_${entId}_datapool_${appId}", sort));
        return getResultList(query);
    }

    @Override
    public int deleteById(Long id) {
        Query query = entityManager.createNativeQuery("delete from ent_${entId}_datapool_${appId} where id=:id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    @Override
    public int save(Datapool datapool) {
        Set<String> keys = datapool.keySet();
        String columns = keys.stream().collect(Collectors.joining(","));
        String preparedColumns = keys.stream().collect(Collectors.joining(",", ":", ""));
        String sql = "insert into ent_${entId}_datapool_${appId}(" + columns + ") values(" + preparedColumns + ")";
        Query query = entityManager.createNativeQuery(sql);
        datapool.forEach((key, value) -> query.setParameter(key, value));
        return query.executeUpdate();
    }

}
