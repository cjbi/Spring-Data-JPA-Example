package tech.wetech.example.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class DatapoolRepositoryTest {

    @Autowired
    private DatapoolRepository datapoolRepository;

    private static final Logger log = LoggerFactory.getLogger(AppBaseRepositoryTest.class);

    @Test
    public void testFindAll() {
        for (int i = 0; i < 100; i++) {
            List<Map<String, Object>> lists = datapoolRepository.findAll("dingdanxitong", "jichuyinqingceshi");
            log.info("查询所有:{}", lists);
        }
    }

    @Test
    public void testSave() {
        for (int i = 0; i < 100; i++) {
            Map<String, Object> data = new HashMap<>();
            data.put("zifuchuan", "中国");
            data.put("zifuchuan2", "加油");
            data.put("owner", "cjbi");
            data.put("modifier", "cjbi");
            data.put("modified_method", "info/test/" + i);
            data.put("created_at", "2020-05-01 12:26:40");
            data.put("last_modified", "2020-05-01 12:26:40");
            data.put("app_key", "info");
            data.put("app_extend_key", i + "");
            datapoolRepository.save("dingdanxitong", "jichuyinqingceshi", data);
        }

    }

}
