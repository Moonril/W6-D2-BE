package it.epicode.W6_D2_BE.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {
    //dati che vogliamo mostrare al client quando c'è un errore
    private String message;
    private LocalDateTime dataErrore;
}
