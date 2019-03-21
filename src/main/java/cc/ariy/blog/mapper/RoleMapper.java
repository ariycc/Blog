package cc.ariy.blog.mapper;

import cc.ariy.blog.domain.Role;

/**
 * @Author Ariy
 * @Since 2019/3/20
 */
public interface RoleMapper {
    Role getByUserId(Long id);

    Role getByName(String name);
}
