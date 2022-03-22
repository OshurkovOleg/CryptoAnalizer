package ru.javarush.oshurkov.cryptoanalizer.commands;

import ru.javarush.oshurkov.cryptoanalizer.entity.Result;
import ru.javarush.oshurkov.cryptoanalizer.entity.ResultCode;

public class Decoder implements Action {

    @Override
    public Result execute(String[] parameters)  {
        //TODO there does something
        return new Result("decode all right", ResultCode.OK);
    }

}
