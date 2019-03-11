package com.liam.springboot.thymeleaf.web;

import com.liam.springboot.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Liam
 * @Date: 2018/12/7 19:51
 */
@Controller
public class ExampleController {
    @RequestMapping("/string")
    public String string(ModelMap map) {
        map.addAttribute("userName", "liam");
        return "string";
    }

    @RequestMapping("/if")
    public String ifunless(ModelMap map) {
        map.addAttribute("flag", "yes");
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }

    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "123");
        map.addAttribute("img", "http://img.jituwang.com/uploads/allimg/150716/258557-150G623162135.jpg");
        return "url";
    }

    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "liam");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "woman");
        return "switch";
    }

    @RequestMapping("/inline")
    public String inline(ModelMap map) {
        map.addAttribute("userName", "liam");
        return "inline";
    }

    @RequestMapping("/object")
    public String object(HttpServletRequest request) {
        request.setAttribute("request", "i am request");
        request.getSession().setAttribute("session", "i am session");
        return "object";
    }

    @RequestMapping("/utility")
    public String utility(ModelMap map) {
        map.addAttribute("userName", "liam");
        map.addAttribute("users", getUserList());
        map.addAttribute("count", 12);
        map.addAttribute("date", new Date());
        return "utility";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/fragment")
    public String fragment() {
        return "fragment";
    }

    @RequestMapping("/layout")
    public String layout() {
        return "layout";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    private List<User> getUserList() {
        List<User> list = new ArrayList<User>();
        User user1 = new User("大牛", 12, "123456");
        User user2 = new User("小牛", 6, "123563");
        User user3 = new User("Liam", 66, "666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
}
