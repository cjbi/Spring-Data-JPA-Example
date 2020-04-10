package tech.wetech.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.wetech.example.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 通过sql返回
     * @param nameLike
     * @return
     */
    @Query(value = "select * from t_user where username like CONCAT('%',:nameLike,'%') and locked=0", nativeQuery = true)
    List<User> findUserByUserNameLike(String nameLike);

    /**
     * 通过Map返回
     * @param nameLike
     * @return
     */
    @Query(value = "select id as id,username as username from t_user where username like CONCAT('%',:nameLike,'%') and locked=0", nativeQuery = true)
    List<Map<String, Object>> findUserByUserNameLikeWithDTO(String nameLike);

}
