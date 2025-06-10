package it.epicode.W6_D2_BE.controller;

import it.epicode.W6_D2_BE.exceptions.BlogNotFoundException;
import it.epicode.W6_D2_BE.model.Blog;
import it.epicode.W6_D2_BE.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Blog saveBlog(@RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }

    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable int id) throws BlogNotFoundException {
        return blogService.getBlog(id);
    }

    @GetMapping
    public List<Blog> getAllBLogs(){
        return blogService.getAllBLogs();
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable int id, @RequestBody Blog blog) throws BlogNotFoundException{
        return blogService.updateBlog(id, blog);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable int id) throws BlogNotFoundException{
        blogService.deleteBlog(id);
    }


}
