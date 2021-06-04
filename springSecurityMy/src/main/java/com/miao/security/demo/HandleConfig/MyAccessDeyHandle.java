package com.miao.security.demo.HandleConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@Configuration
public class MyAccessDeyHandle implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
       // 自定义403异常
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setHeader("content-Type","application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("{\"status\":\"error\"}");
        printWriter.flush();
        printWriter.close();
    }
}
