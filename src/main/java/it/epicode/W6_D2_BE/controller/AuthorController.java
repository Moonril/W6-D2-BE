package it.epicode.W6_D2_BE.controller;


import it.epicode.W6_D2_BE.dto.AuthorDto;
import it.epicode.W6_D2_BE.exceptions.NotFoundException;
import it.epicode.W6_D2_BE.exceptions.ValidationException;
import it.epicode.W6_D2_BE.model.Author;
import it.epicode.W6_D2_BE.model.Blog;
import it.epicode.W6_D2_BE.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Author saveAuthor(@RequestBody AuthorDto authorDto, BindingResult bindingResult) throws NotFoundException, ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(e, s)->e+s));
        }
        return authorService.saveAuthor(authorDto);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable int id) throws NotFoundException {
        return authorService.getAuthor(id);
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody AuthorDto authorDto, BindingResult bindingResult) throws NotFoundException, ValidationException{
        if(bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(e, s)->e+s));
        }
        return authorService.updateAuthor(id, authorDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) throws NotFoundException{
        authorService.deleteAuthor(id);
    }

    @PatchMapping("/{id}")
    public String patchAuthor(@PathVariable int id, @RequestBody MultipartFile file) throws NotFoundException, IOException {
        return authorService.patchAuthor(id, file);
    }

}
