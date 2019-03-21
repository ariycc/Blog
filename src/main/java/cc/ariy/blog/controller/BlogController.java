package cc.ariy.blog.controller;

import cc.ariy.blog.domain.Blog;
import cc.ariy.blog.domain.User;
import cc.ariy.blog.service.BlogService;
import cc.ariy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Ariy
 * @Since 2019/3/18
 */
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/blogs")
    public String blogs(Model m) {
        m.addAttribute("blogs",blogService.listAll());
        return "blogs";
    }

    @RequestMapping("/blog/{id}")
    public String blog(@PathVariable("id") Integer id, Model m) {
        m.addAttribute("blog", blogService.get(id));
        return "blog";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String create(@RequestParam("name") String name, @RequestParam("text") String text) {
        Blog b = new Blog();
        b.setName(name);
        b.setText(text);
        blogService.save(b);
        return "redirect:/blogs";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(User u) {
        if(userService.save(u)) {
            return "redirect:register?success";
        }
        return "redirect:register?error";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }





}
