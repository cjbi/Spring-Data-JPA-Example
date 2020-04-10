package tech.wetech.example.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.wetech.example.SystemContextHolder;
import tech.wetech.example.dto.AppBaseDTO;
import tech.wetech.example.entity.AppBase;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class AppBaseRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(AppBaseRepositoryTest.class);

    @Autowired
    private AppBaseRepository appBaseRepository;


    @Test
    public void testFindFirstByAppIdAndAndName() {
        SystemContextHolder.setEntId("apiceshiqiye");
        AppBase appBase = appBaseRepository.findFirstByAppIdAndAndName("DFShuJuYuanBiao", "DF数据源表");
        log.info("通过条件查询第一条记录:{}", appBase);
    }

    /**
     * JPA规范扩展查询所有记录
     */
    @Test
    public void testSpecificExtension() {
        SystemContextHolder.setEntId("apiceshiqiye");
        List<AppBase> apps = appBaseRepository.findAll();
        log.info("内置方法查询所有记录:{}", apps);
    }

    /**
     * 关键字方法名查询
     * 文档: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
     */
    @Test
    public void testKeyWordsInsideMethod() {
        SystemContextHolder.setEntId("apiceshiqiye");
        List<AppBase> apps = appBaseRepository.findAllByAppId("DFMoRenPeiZhiHanCong");
        log.info("关键字方法名查询(简单查询):{}", apps);
    }

    /**
     * 通过query注解查询
     */
    @Test
    public void testQueryAnnotation() {
        SystemContextHolder.setEntId("apiceshiqiye");
        List<AppBase> apps = appBaseRepository.findAppBasesByAppType("information");
        log.info("根据条件查询:{}", apps);
        long total = appBaseRepository.countAllByAppType("information");
        log.info("查询总数:{}", total);
    }

    /**
     * 返回Map
     */
    @Test
    public void testResultMap() {
        SystemContextHolder.setEntId("apiceshiqiye");
        List<Map<String, Object>> list = appBaseRepository.findAllWithMap("information");
        log.info("返回Map：{}", list);
    }

    /**
     * 返回DTO
     */
    @Test
    public void testResultDTO() {
        SystemContextHolder.setEntId("apiceshiqiye");
        List<AppBaseDTO> list = appBaseRepository.findAllWithDTO("information");
        log.info("返回DTO:{}", list);
    }

}
