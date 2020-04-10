package tech.wetech.example.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.wetech.example.entity.User;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Test
    public void findUserByNameLike() {
        List<User> list = userRepository.findUserByUserNameLike("a");
        log.info("SQL查询返回:{}", list);
    }

    @Test
    public void findUserByUserNameLikeWithDTO() {
        List<Map<String, Object>> list = userRepository.findUserByUserNameLikeWithDTO("a");
        log.info("SQL查询返回:{}", list);
    }

}
