package tech.wetech.example.repository;

import tech.wetech.example.SystemContextHolder;
import tech.wetech.example.entity.Datapool;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class DatapoolRepositoryTest {

    @Autowired
    private DatapoolRepository datapoolRepository;

    private static final Logger log = LoggerFactory.getLogger(AppBaseRepositoryTest.class);
    @Autowired
    private EntityManager entityManager;

    @Test
    public void testFindAll() {
        SystemContextHolder.setEntIdAndAppId("apiceshiqiye","dfzhucongzhubiao");
        List<Datapool> lists = datapoolRepository.findAll();
        log.info("查询所有:{}", lists);
    }

    @Test
    public void testEntityManager() {
        Query query = entityManager.createNativeQuery("select * from ent_apiceshiqiye_datapool_dfzhucongzhubiao");
//        query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String, Object>> resultList = query.getResultList();
        log.info("通过map返回:{}", resultList);
    }

}
