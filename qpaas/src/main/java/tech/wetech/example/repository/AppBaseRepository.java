package tech.wetech.example.repository;

import tech.wetech.example.dto.AppBaseDTO;
import tech.wetech.example.entity.AppBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
@Repository
public interface AppBaseRepository extends JpaRepository<AppBase, Long> {

    /**
     * 关键字方法名查询
     *
     * @param appId
     * @return
     */
    List<AppBase> findAllByAppId(String appId);

    /**
     * 关键字方法名查询
     * 通过appId和name查询第一条记录
     * @param appId
     * @param Name
     * @return
     */
    AppBase findFirstByAppIdAndAndName(String appId,String Name);

    /**
     * Query注解查询指定字段
     *
     * @param appType
     * @return
     */
    @Query("select new AppBase(appId,name) from AppBase where appType=:appType and name<>''")
    List<AppBase> findAppBasesByAppType(String appType);

    /**
     * 查询统计
     *
     * @param appType
     * @return
     */
    @Query("select count(id) from AppBase where appType=:appType and name<>'' and id>100")
    long countAllByAppType(String appType);

    /**
     * 返回DTO
     *
     * @param appType
     * @return
     */
    @Query("select new tech.wetech.example.dto.AppBaseDTO(link,appShow,description) from AppBase where appType=:appType and name<>'' and id>100 ")
    List<AppBaseDTO> findAllWithDTO(String appType);

    /**
     * 返回Map
     *
     * @param appType
     * @return
     */
    @Query("select link as link,appShow as appShow,description as description from AppBase where appType=:appType and name<>'' and id>100 ")
    List<Map<String, Object>> findAllWithMap(String appType);

}
