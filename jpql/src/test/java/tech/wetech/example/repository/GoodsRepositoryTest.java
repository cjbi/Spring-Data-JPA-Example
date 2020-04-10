package tech.wetech.example.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import tech.wetech.example.entity.Goods;

import java.util.List;

@SpringBootTest
public class GoodsRepositoryTest {
    @Autowired
    private GoodsRepository goodsRepository;

    private static final Logger log = LoggerFactory.getLogger(UserDetail2RepositoryTest.class);

    @Test
    public void findAll() {
        List<Goods> list = goodsRepository.findAll();
        log.info("查询所有数据:{}", list);
    }

    @Test
    public void findByNameStartsWith() {
        List<Goods> list = goodsRepository.findByNameStartsWith("日式", Sort.by(Sort.Direction.DESC, "sortOrder", "name"));
        log.info("查询排序:{}", list);
    }

    @Test
    public void findByHot() {
        Page<Goods> page = goodsRepository.findByHot(false, PageRequest.of(1, 20, Sort.by(Sort.Direction.DESC, "sortOrder", "name")));
        log.info("分页查询带排序:{}", page);
    }


}
