package it.epicode.W6_D2_BE.model;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Author {
    private int id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String email;
    private String avatar;

}
