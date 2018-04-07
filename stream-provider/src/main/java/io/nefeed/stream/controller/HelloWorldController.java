package io.nefeed.stream.controller;

import io.nefeed.stream.service.HelloWorldService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 09:08
 */
@Controller
public class HelloWorldController {
    @Resource
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(String name) {
        return helloWorldService.getHelloMessage(name);
    }
}
