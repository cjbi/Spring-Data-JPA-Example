package tech.wetech.example.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.wetech.example.entity.UserDetail;

import java.util.List;

@SpringBootTest
public class UserDetailRepositoryTest {
    @Autowired
    private UserDetailRepository userDetailRepository;

    private static final Logger log = LoggerFactory.getLogger(UserDetailRepositoryTest.class);

    @Test
    public void findByUserId() {
        List<UserDetail> list = userDetailRepository.findAll();
        log.info("注解关联查询:{}", list);
    }
}
