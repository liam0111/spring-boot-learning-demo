package com.liam.springboot.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Liam
 * @Date: 2018/12/7 19:49
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "https://liam0111.github.io");
        return "hello";
    }
}
