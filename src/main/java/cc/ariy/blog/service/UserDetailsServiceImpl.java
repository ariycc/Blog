package cc.ariy.blog.service;

import cc.ariy.blog.domain.Role;
import cc.ariy.blog.domain.User;
import cc.ariy.blog.domain.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Ariy
 * @Since 2019/3/21
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = userService.getByUsername(s);
        if(u == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        return new UserDetailImpl(u);
    }
}
