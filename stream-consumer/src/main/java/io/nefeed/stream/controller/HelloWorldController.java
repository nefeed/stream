package io.nefeed.stream.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.nefeed.stream.service.HelloWorldService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 09:08
 */
@Controller
public class HelloWorldController {
    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(String name) {
        return helloWorldService.getHelloMessage(name);
    }
}
