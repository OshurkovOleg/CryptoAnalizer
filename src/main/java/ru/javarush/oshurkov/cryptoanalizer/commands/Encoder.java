package ru.javarush.oshurkov.cryptoanalizer.commands;

import ru.javarush.oshurkov.cryptoanalizer.entity.Result;
import ru.javarush.oshurkov.cryptoanalizer.entity.ResultCode;
import ru.javarush.oshurkov.cryptoanalizer.exceptions.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;


import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.newBufferedWriter;
import static ru.javarush.oshurkov.cryptoanalizer.constants.Constants.ALPHABET;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        Path pathOfFileForReader = Path.of("text\\" + parameters[0]);
        Path pathOfFileForWrite = Path.of("text\\" + parameters[1]);

        try (BufferedReader readerOfFile = newBufferedReader(pathOfFileForReader);
             BufferedWriter writeOfFile = newBufferedWriter(pathOfFileForWrite)) {

            char encryptedChar;

            while (readerOfFile.ready()) {
                char character = Character.toLowerCase((char) readerOfFile.read());

                if (ALPHABET.contains(character)) {
                    encryptedChar = ALPHABET.get((ALPHABET.indexOf(character) + Integer.parseInt(parameters[2])) % ALPHABET.size());
                    writeOfFile.write(encryptedChar);
                }
            }


        } catch (IOException e) {
            throw new AppException("Проблема > " + e);
        }
        return new Result("encode all right", ResultCode.OK);
    }
}

