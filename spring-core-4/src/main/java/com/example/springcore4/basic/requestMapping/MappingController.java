package com.example.springcore4.basic.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping("/hello")
    //@RequestMapping({"/hello", "/hello2"})
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("hello");
        return "hello";
    }

    @GetMapping("/mapping-get-v2")
    public String helloBasic(@RequestParam(value="name") String name) {
        log.info("mapping-get-v2 {}", name);
        return "mapping-get-v2";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingGet(@PathVariable("userId") String userId) {
        log.info("mappingGet userId={}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable("userId") String userId, @PathVariable("orderId") Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }



}
