package it.epicode.W6_D2_BE.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorDto {
    @NotEmpty(message = "il nome non può essere vuoto")
    private String nome;
    @NotEmpty(message = "il nome della città non può essere vuoto")
    private String cognome;
    @NotNull(message = "la data non può essere lasciata in biano")
    private LocalDate dataNascita;
    @NotEmpty(message = "l'email non può essere vuota")
    private String email;
}
