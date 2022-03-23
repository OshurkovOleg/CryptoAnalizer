package ru.javarush.oshurkov.cryptoanalizer.commands;

import ru.javarush.oshurkov.cryptoanalizer.entity.Result;
import ru.javarush.oshurkov.cryptoanalizer.entity.ResultCode;
import ru.javarush.oshurkov.cryptoanalizer.exceptions.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;

import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.newBufferedWriter;
import static ru.javarush.oshurkov.cryptoanalizer.constants.Constants.ALPHABET;

public class Decoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        try (BufferedReader readeOfCodingFile = newBufferedReader(Path.of(parameters[0]));
             BufferedWriter writeOfEncodingFile = newBufferedWriter(Path.of(parameters[1]))) {

            Collections.reverse(ALPHABET);
            char encryptedChar;

            while (readeOfCodingFile.ready()) {


                char character = Character.toLowerCase((char) readeOfCodingFile.read());

                if (ALPHABET.contains(character)) {
                    encryptedChar = ALPHABET.get((ALPHABET.indexOf(character) + Integer.parseInt(parameters[2])) % ALPHABET.size());
                    writeOfEncodingFile.write(encryptedChar);
                }
            }
        } catch (IOException e) {
            throw new AppException("Проблема > " + e);
        }

        Collections.reverse(ALPHABET);
        return new Result(" декодирование текста ", ResultCode.OK);
    }

}
