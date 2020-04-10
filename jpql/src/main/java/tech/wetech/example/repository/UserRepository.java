package tech.wetech.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.wetech.example.dto.UserSimpleDTO;
import tech.wetech.example.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 关键字方法名查询
     *
     * @param username
     * @param locked
     * @return
     */
    User findDistinctFirstByUsernameAndLocked(String username, Integer locked);

    /**
     * Query注解JPQL模糊查询
     *
     * @param username
     * @return
     */
    @Query("from User where username like CONCAT('%',:username,'%') and locked=0")
    List<User> findAllByUsernameLike(String username);

    /**
     * Query注解JPQL in查询指定字段
     *
     * @param ids
     * @return
     */
    @Query("select new User(id,username) from User where id in (:ids) and locked=0")
    List<User> findAllByIdIn(List<Long> ids);

    /**
     * Query注解JPQL in查询指定字段返回DTO
     *
     * @param ids
     * @return
     */
    @Query("select new tech.wetech.example.dto.UserSimpleDTO(id,username,roleIds) from User where id in (:ids) and locked=0")
    List<UserSimpleDTO> findAllByIdInWithDTO(List<Long> ids);

    /**
     * Query注解JPQL in查询指定字段返回Map
     * @param ids
     * @return
     */
    @Query("select id as id,username as username,roleIds as roleIds from User where id in (:ids) and locked=0")
    List<Map<String, Object>> findAllByIdInWithMap(List<Long> ids);


}
