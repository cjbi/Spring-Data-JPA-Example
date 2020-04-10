package tech.wetech.example.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.wetech.example.dto.UserSimpleDTO;
import tech.wetech.example.entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Test
    public void findDistinctFirstByUsernameAndLocked() {
        User user = userRepository.findDistinctFirstByUsernameAndLocked("张三", 0);
        log.info("关键字方法名查询:{}", user);
    }

    @Test
    public void findAllByUsernameLike() {
        List<User> list = userRepository.findAllByUsernameLike("a");
        log.info("Query注解查询:{}", list);
    }

    @Test
    public void findAllByIdIn() {
        List<User> list = userRepository.findAllByIdIn(Arrays.asList(1L, 3L, 5L, 8L));
        log.info("Query注解查询指定字段:{}", list);
    }

    @Test
    public void findAllByIdInWithDTO() {
        List<UserSimpleDTO> list = userRepository.findAllByIdInWithDTO(Arrays.asList(1L, 3L, 5L, 8L));
        log.info("Query注解查询指定字段:{}", list);
    }

    @Test
    public void findAllByIdInWithMap() {
        List<Map<String, Object>> list = userRepository.findAllByIdInWithMap(Arrays.asList(1L, 3L, 5L, 8L));
        log.info("Query注解查询指定字段:{}", list);
    }

}
