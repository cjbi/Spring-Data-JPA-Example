package tech.wetech.example.controller;

import tech.wetech.example.repository.DatapoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cjbi
 */
@RestController
public class DatapoolController {

    @Autowired
    private DatapoolRepository datapoolRepository;

    @GetMapping("/datapool/findAll")
    public Object findAll() {
        return datapoolRepository.findAll("dingdanxitong", "jichuyinqingceshi");
    }

}
