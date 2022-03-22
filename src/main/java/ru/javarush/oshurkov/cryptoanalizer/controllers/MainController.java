package ru.javarush.oshurkov.cryptoanalizer.controllers;

import ru.javarush.oshurkov.cryptoanalizer.commands.Action;
import ru.javarush.oshurkov.cryptoanalizer.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        //action == encode
        //parameters = [text.txt,encode.txt,12]
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }
}

