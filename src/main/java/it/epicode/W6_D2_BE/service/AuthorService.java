package it.epicode.W6_D2_BE.service;


import com.cloudinary.Cloudinary;
import it.epicode.W6_D2_BE.dto.AuthorDto;
import it.epicode.W6_D2_BE.exceptions.NotFoundException;
import it.epicode.W6_D2_BE.model.Author;
import it.epicode.W6_D2_BE.model.Blog;
import it.epicode.W6_D2_BE.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private Cloudinary cloudinary;


    public Author saveAuthor(AuthorDto authorDto){
        Author author = new Author();
        author.setNome(authorDto.getNome());
        author.setCognome(authorDto.getCognome());
        author.setDataNascita(authorDto.getDataNascita());
        author.setEmail(authorDto.getEmail());

        return authorRepository.save(author);
    }

    public Author getAuthor(int id) throws NotFoundException {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Autore con id: " + id + " non trovato"));

    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author updateAuthor(int id, AuthorDto authorDto) throws NotFoundException{
        Author authorToUpdate = getAuthor(id);

        authorToUpdate.setNome(authorDto.getNome());
        authorToUpdate.setCognome(authorDto.getCognome());
        authorToUpdate.setEmail(authorDto.getEmail());
        authorToUpdate.setDataNascita(authorDto.getDataNascita());

        return authorToUpdate;
    }

    public void deleteAuthor(int id) throws NotFoundException{
        Author authorToDelete = getAuthor(id);

        authorRepository.delete(authorToDelete);
    }

    public String patchAuthor(int id, MultipartFile file) throws NotFoundException, IOException {
        Author autoreDaPatchare = getAuthor(id);

        String url = (String)cloudinary.uploader().upload(file.getBytes(), Collections.emptyMap()).get("url"); // (String) conversione

        autoreDaPatchare.setUrlAvatar(url);

        authorRepository.save(autoreDaPatchare);

        return url;
    }

}
