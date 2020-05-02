package tech.wetech.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.example.repository.DatapoolRepository;

import java.util.Map;

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

    @GetMapping("/datapool/findBy")
    public Object findBy(@RequestParam Map<String, Object> param) {
        return datapoolRepository.findBy("dingdanxitong", "jichuyinqingceshi", param);
    }

}
