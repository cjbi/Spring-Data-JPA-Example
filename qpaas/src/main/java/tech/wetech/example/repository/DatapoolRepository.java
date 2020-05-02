package tech.wetech.example.repository;

import java.util.List;
import java.util.Map;


/**
 * @author cjbi
 */
public interface DatapoolRepository {
    /**
     * 查询所有
     *
     * @param entId
     * @param tableId
     * @return
     */
    List<Map<String, Object>> findAll(String entId, String tableId);

    /**
     * 根据条件查询
     * @param entId
     * @param tableId
     * @param param
     * @return
     */
    List<Map<String, Object>> findBy(String entId, String tableId, Map<String, Object> param);

    /**
     * 保存
     *
     * @param data
     * @return id
     */
    Long save(String entId, String tableId, Map<String, Object> data);

    /**
     * 更新，必须存在id
     *
     * @param entId
     * @param tableId
     * @param data
     * @return
     */
    void update(String entId, String tableId, Map<String, Object> data);

    /**
     * 保存或者更新数据
     *
     * @param entId
     * @param tableId
     * @param data
     */
    void saveOrUpdate(String entId, String tableId, Map<String, Object> data);

    /**
     * 根据条件删除
     *
     * @param entId
     * @param tableId
     * @param data
     */
    void delete(String entId, String tableId, Map<String, Object> data);

    /**
     * 根据id删除
     *
     * @param entId
     * @param tableId
     * @param id
     */
    void deleteById(String entId, String tableId, Long id);

}
