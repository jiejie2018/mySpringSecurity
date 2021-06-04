package com.miao.security.demo.HandleConfig;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

public class MyAuthHandle  implements AuthenticationSuccessHandler {
    private String url;


    public MyAuthHandle(String url) {
        System.out.println(url);
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        User userPrincipal = (User) request.getUserPrincipal();
//        System.out.println(userPrincipal.getUsername());
//        System.out.println(userPrincipal.getPassword());
//        System.out.println(userPrincipal.getAuthorities());
//        System.out.println(request.getPathInfo());
        response.sendRedirect(url);
    }
}
