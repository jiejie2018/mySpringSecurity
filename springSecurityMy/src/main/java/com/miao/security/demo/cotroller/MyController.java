package com.miao.security.demo.cotroller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
//    @RequestMapping("login")
//    public String demo() {
//        return "redirect:main.html";
//    }
//    @Secured("Role_secured")
    @PreAuthorize("hasRole('ROLE_abc')")
   // @Secured("ROLE_abc")
    @RequestMapping("/toMain")
    public String main() {
        return "redirect:main.html";
    }

    @RequestMapping("/toError")
    public String error() {
        return "redirect:error.html";
    }

    @RequestMapping("/showLogin")
    public String showLogin() {
        return "login";
    }
}
