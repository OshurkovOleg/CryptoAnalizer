package ru.javarush.oshurkov.cryptoanalizer.entity;

public class Result {

    private final String message;

    private final ResultCode resultCode;


    public Result(String message, ResultCode resultCode) {
        this.message = message;
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "Результат: " +
                "Выполнена команда = " + message  +
                ", Статус = " + resultCode ;
    }
}
