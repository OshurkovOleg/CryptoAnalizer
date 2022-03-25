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

public class Decoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        try (BufferedReader readeOfCodingFile = newBufferedReader(Path.of(parameters[0]));
             BufferedWriter writeOfEncodingFile = newBufferedWriter(Path.of(parameters[1]))) {


            int encryptedChar;
            int positionCharAfterTurn;

            while (readeOfCodingFile.ready()) {

                char character = Character.toLowerCase((char) readeOfCodingFile.read());
                positionCharAfterTurn = (ALPHABET.indexOf(character) - Integer.parseInt(parameters[2]));


                if (positionCharAfterTurn < 0) {
                    encryptedChar = ALPHABET.size() - (positionCharAfterTurn * -1);
                } else {
                    encryptedChar = positionCharAfterTurn;
                }


                if (ALPHABET.contains(character)) {
                    writeOfEncodingFile.write(ALPHABET.get(encryptedChar));
                }
            }
        } catch (IOException e) {
            throw new AppException("Проблема > " + e);
        }

        return new Result(" декодирование текста ", ResultCode.OK);
    }

}
