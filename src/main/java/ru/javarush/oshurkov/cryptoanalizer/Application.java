package ru.javarush.oshurkov.cryptoanalizer;

import ru.javarush.oshurkov.cryptoanalizer.controllers.MainController;
import ru.javarush.oshurkov.cryptoanalizer.entity.Result;
import ru.javarush.oshurkov.cryptoanalizer.exceptions.AppException;

import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        //encode text.txt encode.txt 12
        if (args.length > 0) {
            String action = args[0]; //encode
            //parameters - text.txt encode.txt 12
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainController.doAction(action, parameters);
        } else {
            throw new AppException("no args");
        }
    }
}
