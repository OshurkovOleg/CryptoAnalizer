package ru.javarush.oshurkov.cryptoanalizer.commands;

import ru.javarush.oshurkov.cryptoanalizer.entity.Result;
import ru.javarush.oshurkov.cryptoanalizer.entity.ResultCode;
import ru.javarush.oshurkov.cryptoanalizer.exceptions.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.newBufferedWriter;
import static ru.javarush.oshurkov.cryptoanalizer.constants.Constants.ALPHABET;
import static ru.javarush.oshurkov.cryptoanalizer.constants.Constants.DICTIONARY;

public class BruteForce implements Action {


    @Override
    public Result execute(String[] parameters) {

        Path pathOfFileForReader = Path.of("text\\" + parameters[0]);
        Path pathOfFileForWrite = Path.of("text\\" + parameters[1]);
        List<Character> listCharText = new ArrayList<>();
        char encryptedChar;
        int hackKey = 0;
        int hitCounter = 0;
        StringBuilder str = new StringBuilder();


        try (BufferedReader readeOfCodingFile = newBufferedReader(pathOfFileForReader);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathOfFileForWrite)) {

            Collections.reverse(ALPHABET);


            while (readeOfCodingFile.ready()) {
                char character = Character.toLowerCase((char) readeOfCodingFile.read());
                if (ALPHABET.contains(character)) {
                    listCharText.add(character);
                }
            }

            while (true) {


                for (Character element : listCharText) {
                    encryptedChar = ALPHABET.get((ALPHABET.indexOf(element) + hackKey) % ALPHABET.size());
                    str.append(encryptedChar);
                }

                String strRes = str.toString();

                for (String s : DICTIONARY) {
                    if (strRes.contains(s)) {
                        hitCounter++;
                    }
                }

                if (hitCounter > 5) {
                    writeOfEncodingFile.write(strRes);
                    break;
                } else {
                    if (hackKey < ALPHABET.size()) {
                        hackKey++;
                        str = new StringBuilder();
                    } else {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new AppException("Проблема > " + e);
        }
        return new Result("BruteForce complete", ResultCode.OK);
    }
}
