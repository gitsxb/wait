package cn.run.wait.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SXB on 2018/7/30.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
}
