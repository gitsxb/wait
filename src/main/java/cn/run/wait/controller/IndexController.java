package cn.run.wait.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SXB on 2018/7/30.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String toIndex(){
        return "index1";
    }

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/{page}/a")
    public String toPage(@PathVariable(name = "page")String page){
        return page;
    }
}
