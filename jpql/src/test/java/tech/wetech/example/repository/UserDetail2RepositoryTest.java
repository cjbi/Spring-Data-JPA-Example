package tech.wetech.example.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.wetech.example.dto.UserDetailDTO;
import tech.wetech.example.entity.UserDetail;
import tech.wetech.example.entity.UserDetail2;

@SpringBootTest
public class UserDetail2RepositoryTest {

    @Autowired
    private UserDetail2Repository userDetail2Repository;

    private static final Logger log = LoggerFactory.getLogger(UserDetail2RepositoryTest.class);

    @Test
    public void findByUserId() {
        UserDetail2 userDetail = userDetail2Repository.findByUserId(1L);
        log.info("注解关联查询:{}", userDetail);
    }

    @Test
    public void findByUserIdWithDTO() {
        UserDetailDTO userDetailDTO = userDetail2Repository.findByUserIdWithDTO(1L);
        log.info("join关联查询:{}", userDetailDTO);
    }

}
