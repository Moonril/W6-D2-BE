package it.epicode.W6_D2_BE.service;

import it.epicode.W6_D2_BE.exceptions.BlogNotFoundException;
import it.epicode.W6_D2_BE.model.Blog;
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
    private List<Blog> blogs = new ArrayList<>();


    public Blog saveBlog(Blog blog){
        blog.setId(new Random().nextInt(1,2000));
        blog.setCover("https://picsum.photos/200/300");
        blogs.add(blog);
        return blog;
    }

    public Blog getBlog(int id) throws BlogNotFoundException{
        return blogs.stream().filter(blog -> blog.getId() == id).findFirst().orElseThrow(() -> new BlogNotFoundException("Nessun blog trovato con id: " + id));
    }

    public List<Blog> getAllBLogs(){
        return blogs;
    }

    public Blog updateBlog(int id, Blog blog) throws BlogNotFoundException{
        Blog blogToUpdate = getBlog(id);

        blogToUpdate.setTitolo(blog.getTitolo());
        blogToUpdate.setContenuto(blog.getContenuto());
        blogToUpdate.setCategoria(blog.getCategoria());
        blogToUpdate.setTempoDiLettura(blog.getTempoDiLettura());

        return blogToUpdate;
    }

    public void deleteBlog(int id) throws BlogNotFoundException{
        Blog blogToDelete = getBlog(id);

        blogs.remove(blogToDelete);
    }

}
