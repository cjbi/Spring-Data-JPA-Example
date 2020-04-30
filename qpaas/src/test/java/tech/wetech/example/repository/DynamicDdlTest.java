package tech.wetech.example.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.wetech.example.SystemContextHolder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author cjbi
 */
@SpringBootTest
public class DynamicDdlTest {

    @Autowired
    private EntityManager entityManager;

    public static final String XML_MAPPING =
            "<hibernate-mapping>\n" +
                    "    <class entity-name=\"Student\" table=\"t_student\" dynamic-update=\"true\">\n" +
                    "        <id name=\"id\" type=\"java.lang.Long\" length=\"64\" unsaved-value=\"null\">\n" +
                    "            <generator class=\"identity\" />\n" +
                    "        </id>" +
                    "        <property type=\"java.lang.String\" name=\"username\" column=\"username\"/>\n" +
                    "        <property name=\"password\" type=\"java.lang.String\" column=\"password\"/>\n" +
                    "        <property name=\"sex\" type=\"java.lang.String\" column=\"sex\"/>\n" +
                    "        <property name=\"age\" type=\"java.lang.Integer\" column=\"age\"/>\n" +
                    "        <property name=\"birthday\" type=\"java.util.Date\" column=\"birthday\"/>\n" +
                    "    </class>" +
                    "</hibernate-mapping>";

    @Test
    public void testDynamicDdl() {
        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
        StandardServiceRegistry serviceRegistry = sessionFactory.getSessionFactoryOptions().getServiceRegistry();
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        sessionFactory.getSessionFactoryOptions();
        metadataSources.addInputStream(new ByteArrayInputStream(XML_MAPPING.getBytes()));
        Metadata metadata = metadataSources.buildMetadata();
        //更新数据库Schema,如果不存在就创建表,存在就更新字段,不会影响已有字段
//        SchemaUpdate schemaUpdate = new SchemaUpdate();
//        schemaUpdate.setHaltOnError(true);
//        schemaUpdate.execute(EnumSet.of(TargetType.STDOUT, TargetType.DATABASE), metadata, serviceRegistry);

        //合并配置
        Configuration cfg = new Configuration();
        cfg.addInputStream(new ByteArrayInputStream(XML_MAPPING.getBytes()));
        SessionFactory newSessionFactory = cfg.buildSessionFactory(serviceRegistry);
        //保存对象
        Session newSession = newSessionFactory.openSession();
//        for (int i = 0; i < 10; i++) {
//            Map<String, Object> student = new HashMap<>();
//            student.put("username", "张三" + i);
//            student.put("password", "adsfwr" + i);
//            student.put("sex", i % 2 == 0 ? "male" : "female");
//            student.put("age", i);
//            student.put("birthday", new Date());
//            newSession.save("Student", student);
//        }
        //查询所有对象
        Query query = newSession.createQuery("select username as username,password as password from Student where id=1410");
        List list = query.getResultList();
        System.out.println("resultList: " + list);
    }

    @Test
    public void testDynamicModel() {
        SystemContextHolder.setEntId("apiceshiqiye");
        SystemContextHolder.setTableId("dfmaindefault");
        SystemContextHolder.setDynamicModel(true);
        Query query = entityManager.createQuery("from apiceshiqiyedfmaindefault");
        List list = query.getResultList();
        System.out.println(list);
    }

}
