package it.epicode.W6_D2_BE.controller;

import it.epicode.W6_D2_BE.exceptions.AuthorNotFoundExcpetion;
import it.epicode.W6_D2_BE.exceptions.BlogNotFoundException;
import it.epicode.W6_D2_BE.model.Author;
import it.epicode.W6_D2_BE.model.Blog;
import it.epicode.W6_D2_BE.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Author saveAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable int id) throws AuthorNotFoundExcpetion {
        return authorService.getAuthor(id);
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) throws AuthorNotFoundExcpetion{
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) throws AuthorNotFoundExcpetion{
        authorService.deleteAuthor(id);
    }

}
