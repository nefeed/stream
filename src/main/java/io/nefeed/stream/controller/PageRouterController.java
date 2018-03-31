package io.nefeed.stream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-31 03:27
 */
@Controller("/page")
public class PageRouterController {

    @RequestMapping("/")
    public String home() {
        return "/index";
    }

    @RequestMapping("/home")
    public String home(ModelMap modelMap) {

        modelMap.put("name", "Magical Sam");

        List<String> list = new ArrayList<>();
        list.add("sam a");
        list.add("sam b");
        list.add("sam c");
        list.add("sam d");
        modelMap.put("list", list);

        return "/home";
    }

}
