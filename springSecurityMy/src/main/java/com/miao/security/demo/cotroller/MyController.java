package com.miao.security.demo.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
//    @RequestMapping("login")
//    public String demo() {
//        return "redirect:main.html";
//    }

    @RequestMapping("toMain")
    public String main() {
        return "redirect:main.html";
    }

    @RequestMapping("toError")
    public String error() {
        return "redirect:error.html";
    }
}
