package ru.javarush.oshurkov.cryptoanalizer.commands;

import ru.javarush.oshurkov.cryptoanalizer.entity.Result;

public interface Action {

    Result execute(String[] parameters);
}

