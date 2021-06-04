package com.miao.security.demo.config;

import com.miao.security.demo.HandleConfig.MyAccessDeyHandle;
import com.miao.security.demo.HandleConfig.MyAuthHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyPasswordEncode extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAccessDeyHandle myAccessDeyHandle;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin()
                // username 和 password是默认的值，可以修改，但是需要和前端form中的name对应 详情见：UsernamePasswordAuthenticationFilter
//                .usernameParameter("username")
//                .usernameParameter("password")
                // 当发现是/login时发现时登录，必须浩前端的action请求路径中的值相同
                .loginProcessingUrl("/login")
                //
                .loginPage("/login.html")
                // 相当于get请求
                // .successForwardUrl("/main.html");
                // 跳到第三方的网站
                // .successHandler(new MyAuthHandle("http://www.baidu.com"))
                //  .successForwardUrl("www.baidu.com")
                // 相当于post请求
                .successForwardUrl("/toMain")
                .failureForwardUrl("/toError");
        // 授权认证
        http.authorizeRequests()
                //这个不需要被认证
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                // 只有post类型的login.html请求才允许通过
                // .regexMatchers("post","login.html").permitAll()
                .antMatchers("/css/**","/pic/**","/js/**").permitAll()
                //任意路径下的PNG图片
                // .antMatchers("/**/*.PNG").permitAll()
                // main2.html 需要admin11权限
//                .antMatchers("/main2.html").hasAuthority("admin11")
//                .antMatchers("/main2.html").hasAnyAuthority("admin11","admin34")

                //对应权限里面的ROLE_abc
              //   .antMatchers("/main2.html").hasRole("abc")
                // 锁定某个ip 非127.0.0.1的，找不到则可以触发403的自定义异常
                .antMatchers("/main2.html").hasIpAddress("127.0.0.1")
                // 除了上面的permitAll，其他的都需要被认证
                .anyRequest().authenticated();

        //关闭csrf
        http.csrf().disable();

        //异常处理
        http.exceptionHandling()
                //使用自定义的异常处理
                .accessDeniedHandler(myAccessDeyHandle);

    }

    @Bean
    public PasswordEncoder getPasswdEncode () {
        return new BCryptPasswordEncoder();
    }
}
