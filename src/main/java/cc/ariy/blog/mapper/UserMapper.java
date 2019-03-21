package cc.ariy.blog.mapper;

import cc.ariy.blog.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Ariy
 * @Since 2019/3/20
 */
public interface UserMapper {
    void save(User u);

    void saveUR(@Param("uid") Long uid, @Param("rid") Long rid);

    User getById(Long id);

    User getByName(String username);


}
