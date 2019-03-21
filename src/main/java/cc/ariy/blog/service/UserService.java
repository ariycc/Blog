package cc.ariy.blog.service;

import cc.ariy.blog.domain.Role;
import cc.ariy.blog.domain.User;
import cc.ariy.blog.mapper.RoleMapper;
import cc.ariy.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Ariy
 * @Since 2019/3/21
 */

@Service
@Primary
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private RoleMapper roleMapper;

    public boolean save(User u) {
        String username = u.getUsername();
        if(exist(username)) {
            return false;
        }
        encryptPassword(u);
        List<Role> roles = new ArrayList<>();
        Role r = roleMapper.getByName("ROLE_USER");
        roles.add(r);
        u.setRoles(roles);
        userMapper.save(u);
        userMapper.saveUR(u.getId(),r.getId());
        return true;
    }

    public User getByUsername(String username) {
        return userMapper.getByName(username);
    }

    private boolean exist(String username) {
        User u = userMapper.getByName(username);
        return (u != null);
    }

    private void encryptPassword(User u) {
        u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
    }
}
