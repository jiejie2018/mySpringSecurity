package com.miao.security.demo.serviceImpl;

import com.miao.security.demo.config.MyPasswordEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //自定义登录逻辑
        //如果用户名不存在 抛出UsernameNotFoundException
        if (!"admin".equals(username)) {
            throw  new UsernameNotFoundException("用户名不存在");
        }
        String password = passwordEncoder.encode("123");
// 	public User(String username, String password,
//			Collection<? extends GrantedAuthority> authorities) {
//		this(username, password, true, true, true, true, authorities);
//	}           // 需要看一下  createAuthorityList commaSeparatedStringToAuthorityList这两个的区别
  //       return new User(username,password, AuthorityUtils.createAuthorityList("admin,adMIN,ROLE_abc"));
        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,adMIN,ROLE_abc"));
    }
}
