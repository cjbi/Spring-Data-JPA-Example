package tech.wetech.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.wetech.example.dto.UserDetailDTO;
import tech.wetech.example.entity.UserDetail;
import tech.wetech.example.entity.UserDetail2;

/**
 * @author cjbi
 */
public interface UserDetail2Repository extends JpaRepository<UserDetail2, Long> {

    /**
     * 通过userId查询用户详情
     * 因为没配置关联关系，不会自动关联查询
     * @param userId
     * @return
     */
    UserDetail2 findByUserId(Long userId);

    @Query("select new tech.wetech.example.dto.UserDetailDTO(u.id,u.username,d.address,d.city,d.description) from UserDetail2 d left join User u on(d.userId=u.id) where u.id=:userId")
    UserDetailDTO findByUserIdWithDTO(Long userId);

}
