package tech.wetech.example.repository;

import tech.wetech.example.entity.Datapool;
import org.springframework.data.domain.Sort;

import java.util.List;


/**
 * @author cjbi
 */
public interface DatapoolRepository {

    List<Datapool> findAll();

    List<Datapool> findAll(Sort sort);

    int deleteById(Long id);

    int save(Datapool datapool);

}
