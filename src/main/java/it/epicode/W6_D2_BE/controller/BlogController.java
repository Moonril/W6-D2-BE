package it.epicode.W6_D2_BE.controller;

import it.epicode.W6_D2_BE.dto.BlogDto;
import it.epicode.W6_D2_BE.exceptions.NotFoundException;
import it.epicode.W6_D2_BE.exceptions.ValidationException;
import it.epicode.W6_D2_BE.model.Blog;
import it.epicode.W6_D2_BE.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Blog saveBlog(@RequestBody @Validated BlogDto blogDto, BindingResult bindingResult) throws NotFoundException, ValidationException {
        if(bindingResult.hasErrors()){
            throw new jakarta.validation.ValidationException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(e, s)->e+s));
        }
        return blogService.saveBlog(blogDto);
    }

    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable int id) throws NotFoundException {
        return blogService.getBlog(id);
    }

    @GetMapping
    public List<Blog> getAllBLogs(){
        return blogService.getAllBLogs();
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable int id, @RequestBody BlogDto blogDto, BindingResult bindingResult) throws NotFoundException, ValidationException{
        if(bindingResult.hasErrors()){
            throw new jakarta.validation.ValidationException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(e, s)->e+s));
        }
        return blogService.updateBlog(id, blogDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable int id) throws NotFoundException{
        blogService.deleteBlog(id);
    }


}
