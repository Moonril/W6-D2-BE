package it.epicode.W6_D2_BE.service;

import com.cloudinary.Cloudinary;
import it.epicode.W6_D2_BE.dto.BlogDto;
import it.epicode.W6_D2_BE.exceptions.NotFoundException;
import it.epicode.W6_D2_BE.model.Author;
import it.epicode.W6_D2_BE.model.Blog;
import it.epicode.W6_D2_BE.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
GET /blogPosts => ritorna la lista di blog post
GET /blogPosts /123 => ritorna un singolo blog post
POST /blogPosts => crea un nuovo blog post
PUT /blogPosts /123 => modifica lo specifico blog post
DELETE /blogPosts /123 => cancella lo specifico blog post
 */


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AuthorService authorService;




    public Blog saveBlog(BlogDto blogDto) throws NotFoundException {
        Author author = authorService.getAuthor(blogDto.getAuthorId());

        Blog blog = new Blog();
        blog.setTitolo(blogDto.getTitolo());
        blog.setContenuto(blogDto.getContenuto());
        blog.setCategoria(blogDto.getCategoria());
        blog.setTempoDiLettura(blogDto.getTempoDiLettura());
        blog.setAutore(author);

        return  blogRepository.save(blog);


    }



    public Blog getBlog(int id) throws NotFoundException{
        return blogRepository.findById(id).orElseThrow(() -> new NotFoundException("Blog con id: " + id + " non trovato"));
    }

    public List<Blog> getAllBLogs(){
        return blogRepository.findAll();
    }

    public Blog updateBlog(int id, BlogDto blogDto) throws NotFoundException{
        Blog blogToUpdate = getBlog(id);

        blogToUpdate.setTitolo(blogDto.getTitolo());
        blogToUpdate.setContenuto(blogDto.getContenuto());
        blogToUpdate.setCategoria(blogDto.getCategoria());
        blogToUpdate.setTempoDiLettura(blogDto.getTempoDiLettura());

        if(blogToUpdate.getAutore().getId()!=blogDto.getAuthorId()){
            Author author = authorService.getAuthor(blogDto.getAuthorId());
            blogToUpdate.setAutore(author);
        }

        return blogRepository.save(blogToUpdate);
    }

    public void deleteBlog(int id) throws NotFoundException{
        Blog blogToDelete = getBlog(id);

        blogRepository.delete(blogToDelete);
    }

}
