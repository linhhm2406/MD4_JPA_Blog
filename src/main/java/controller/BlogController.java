package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.blog.IBlogService;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("showList")
    public ModelAndView showList(){
        List<Blog> blogList = blogService.showAll();
        return new ModelAndView("showList","list",blogList);
    }

    @GetMapping("createNewBlog")
    public ModelAndView showCreateForm(Model model){
        return new ModelAndView("createForm","blog",new Blog());
    }

    @PostMapping("createNewBlog")
    public String createBlog(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/showList";
    }

    @GetMapping("editBlog/{id}")
    public ModelAndView showEditForm(@PathVariable long id){
        Blog blog = blogService.getOne(id);
        ModelAndView modelAndView = new ModelAndView("editForm");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/showList";
    }

    @GetMapping("deleteBlog/{id}")
    public String detete(@PathVariable long id){
        blogService.delete(id);
        return "redirect:/showList";
    }

    @GetMapping("likeBlog/{id}")
    public String upLike(@PathVariable long id){
        blogService.upLike(id);
        return "redirect:/showList";
    }

}
