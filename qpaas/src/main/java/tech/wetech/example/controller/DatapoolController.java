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
    public Object findAll(@RequestParam(defaultValue = "dingdanxitong") String entId, @RequestParam(defaultValue = "jichuyinqingceshi") String tableId) {
        return datapoolRepository.findAll(entId, tableId);
    }

    @GetMapping("/datapool/findBy")
    public Object findBy(@RequestParam(defaultValue = "dingdanxitong") String entId, @RequestParam(defaultValue = "jichuyinqingceshi") String tableId, @RequestParam Map<String, Object> param) {
        return datapoolRepository.findBy(entId, tableId, param);
    }

}
