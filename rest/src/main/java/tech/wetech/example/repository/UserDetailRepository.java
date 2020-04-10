package tech.wetech.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import tech.wetech.example.entity.UserDetail;

/**
 * @author cjbi
 */
@RepositoryRestResource(collectionResourceRel = "userDetail", path = "user")
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    @RestResource(path = "cityStartsWith", rel = "cityStartsWith")
    Page findByCityStartsWith(@Param("city") String city, Pageable p);

}
