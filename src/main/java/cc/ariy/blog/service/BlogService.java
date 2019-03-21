package cc.ariy.blog.service;

import cc.ariy.blog.domain.Blog;
import cc.ariy.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Ariy
 * @Since 2019/3/18
 */
@Service
public class BlogService {

    @Autowired(required = false)
    private BlogMapper blogMapper;

    public void save(Blog b) {
        blogMapper.save(b);
    }

    public Blog get(Integer id) {
        return blogMapper.get(id);
    }

    public List<Blog> listAll() {
        return blogMapper.listAll();
    }
}
