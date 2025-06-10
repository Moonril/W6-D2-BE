package it.epicode.W6_D2_BE.exceptions;

public class BlogNotFoundException extends Exception {
    public BlogNotFoundException(String message) {
        super(message);
    }
}
