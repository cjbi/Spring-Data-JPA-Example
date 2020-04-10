package tech.wetech.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.wetech.example.dto.UserDetailDTO;
import tech.wetech.example.entity.UserDetail;

/**
 * @author cjbi
 */
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    /**
     * 通过userId查询用户详情
     * OneToOne、OneToMany等注解会自动关联表,担心查询性能的话也可以开启懒加载模式,按需查询关联表
     * @param userId
     * @return
     */
    UserDetail findByUserId(Long userId);

    /**
     * 关联查询，通过OneToOne,
     * @param userId
     * @return
     */
    @Query("select new tech.wetech.example.dto.UserDetailDTO(u.id,u.username,d.address,d.city,d.description) from UserDetail d left join User u on(d.user=u) where u.id=:userId")
    UserDetailDTO findByUserIdWithDTO(Long userId);

}
