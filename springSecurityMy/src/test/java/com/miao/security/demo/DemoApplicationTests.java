package com.miao.security.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // 加密密码
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String miao = passwordEncoder.encode("miao");
        System.out.println(miao);
        System.out.println(passwordEncoder.matches("miao",miao));
    }

}
