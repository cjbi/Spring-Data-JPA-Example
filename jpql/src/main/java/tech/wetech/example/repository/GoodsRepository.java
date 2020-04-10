package tech.wetech.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.wetech.example.entity.Goods;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    /**
     * 排序
     * @param name
     * @param sort
     * @return
     */
    List<Goods> findByNameStartsWith(String name, Sort sort);

    /**
     * 分页排序带排序
     * @param hot
     * @param pageable
     * @return
     */
    Page<Goods> findByHot(Boolean hot, Pageable pageable);

}
