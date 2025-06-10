package it.epicode.W6_D2_BE.service;

import it.epicode.W6_D2_BE.exceptions.AuthorNotFoundExcpetion;
import it.epicode.W6_D2_BE.exceptions.BlogNotFoundException;
import it.epicode.W6_D2_BE.model.Author;
import it.epicode.W6_D2_BE.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public Author saveAuthor(Author author){
        author.setId(new Random().nextInt(1,2000));
        authors.add(author);
        return author;
    }

    public Author getAuthor(int id) throws AuthorNotFoundExcpetion {
        return authors.stream().filter(author -> author.getId() == id).findFirst().orElseThrow(() -> new AuthorNotFoundExcpetion("Nessun autore trovato con id: " + id));
    }

    public List<Author> getAllAuthors(){
        return authors;
    }

    public Author updateAuthor(int id, Author author) throws AuthorNotFoundExcpetion{
        Author authorToFind = getAuthor(id);

        authorToFind.setNome(author.getNome());
        authorToFind.setCognome(author.getCognome());
        authorToFind.setEmail(author.getEmail());
        authorToFind.setDataNascita(author.getDataNascita());

        return authorToFind;
    }

    public void deleteAuthor(int id) throws AuthorNotFoundExcpetion{
        Author authorToDelete = getAuthor(id);

        authors.remove(authorToDelete);
    }

}
