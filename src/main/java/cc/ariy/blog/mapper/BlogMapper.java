package cc.ariy.blog.mapper;

import cc.ariy.blog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Ariy
 * @Since 2019/3/18
 */
@Mapper
public interface BlogMapper {

    void save(Blog b);

    //void delete(Integer id);

    Blog get(Integer id);

    List<Blog> listAll();

    //void update(Blog b);
}
