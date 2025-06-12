package it.epicode.W6_D2_BE.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BlogDto {
    @NotEmpty(message = "categoria non può essere vuoto")
    private String categoria;
    @NotEmpty(message = "il titolo non può essere vuoto")
    private String titolo;

    private String cover;
    @NotEmpty(message = "il contenuto non può essere vuoto")
    private String contenuto;
    @NotNull(message = "il tempo non può essere vuoto")
    private int tempoDiLettura;

    private int authorId;
}
