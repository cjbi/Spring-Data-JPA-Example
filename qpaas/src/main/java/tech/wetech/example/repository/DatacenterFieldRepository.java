package tech.wetech.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.wetech.example.entity.DatacenterField;

import java.util.List;

/**
 * @author cjbi
 */
public interface DatacenterFieldRepository extends JpaRepository<DatacenterField, Long> {

    List<DatacenterField> findByBelongs(String belongs);
}
