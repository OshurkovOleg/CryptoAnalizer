package ru.javarush.oshurkov.cryptoanalizer;

public class ExceptionProject extends RuntimeException{
    public ExceptionProject() {
    }

    public ExceptionProject(String message) {
        super(message);
    }

    public ExceptionProject(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionProject(Throwable cause) {
        super(cause);
    }
}
