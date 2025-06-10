package it.epicode.W6_D2_BE.model;

import lombok.Data;

@Data
public class Blog {
    private int id;
    private String categoria;
    private String titolo;
    //  private cover;
    private String contenuto;
    private int tempoDiLettura;
}
