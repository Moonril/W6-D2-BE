package it.epicode.W6_D2_BE.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Author {
    private int id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String email;
    private String urlAvatar;


    //tolgo la lista degli studenti dalla generazione del JSON
    @JsonIgnore
    @OneToMany(mappedBy = "Author")
    private List<Blog> blogs;

}
