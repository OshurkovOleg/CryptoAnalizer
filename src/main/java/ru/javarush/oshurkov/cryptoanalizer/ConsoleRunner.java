package ru.javarush.oshurkov.cryptoanalizer;

import static ru.javarush.oshurkov.cryptoanalizer.constants.Constants.*;

import ru.javarush.oshurkov.cryptoanalizer.controllers.Actions;
import ru.javarush.oshurkov.cryptoanalizer.entity.Result;
import ru.javarush.oshurkov.cryptoanalizer.exceptions.AppException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class ConsoleRunner {


    public static void main(String[] args) {

        args = new String[4];
        Scanner scanner = new Scanner(System.in);

        //welcome in programm
        System.out.println("Доброе пожаловать в программу шифрования");
        System.out.println("========================================\n");
        System.out.println("Укажите одну из доступных команд: " + Actions.ENCODE + ", "
                + Actions.DECODE + ", "
                + Actions.BRUTEFORCE + ", для выхода exit. \n");

        // command request
        while (true) {
            System.out.print(ENTER_COMMAND);
            args[0] = scanner.nextLine().toLowerCase();

            if (args[0].equals("exit")) {
                System.exit(0);
            }

            // checking the command entered

            if (!(args[0].equals("encode") || args[0].equals("decode") || args[0].equals("bruteforce"))) {
                System.out.println("Команда не обнаружена, повторите попытку.\n");
            } else {

                //command Encode

                //read file
                if (args[0].equalsIgnoreCase("encode")) {
                    while (true) {
                        System.out.print(FILE_EXECUTION);
                        args[1] = scanner.nextLine();

                        if (args[1].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (args[1].isEmpty()) {
                            args[1] = PATH_TO_DEFAULT_TEXT;
                            break;
                        } else if (!Files.exists(Path.of(args[1]))) {
                            System.out.println(FILE_NOT_FOUND);
                        } else {
                            break;
                        }
                    }


                    //write file

                    System.out.print(FILE_SAVE_RESULT);
                    args[2] = scanner.nextLine();

                    if (args[2].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (args[2].isEmpty()) {
                        args[2] = PATH_TO_DEFAULT_ENCRYPTION;
                    } else if (!Files.exists(Path.of(args[2]))) {
                        try {
                            Files.createFile(Path.of(args[2]));
                        } catch (IOException e) {
                            throw new AppException("Проблема при создании файла > " + e);
                        }
                        System.out.println(FILE_NOT_FOUND_AND_CREATE);

                    }


                    //get crypto-key

                    while (true) {
                        System.out.print(KEY_ENCRYPTION);
                        args[3] = scanner.nextLine();
                        if (args[3].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (args[3].isEmpty()) {
                            System.out.println("Нельзя шифровать без ключа, повторите ввод.\n");
                        } else if (Integer.parseInt(args[3]) < 0 || Integer.parseInt(args[3]) > (ALPHABET.size() - 1)) {
                            System.out.println("Указанное значение не доступно. \n");
                        } else {
                            break;
                        }
                    }
                }


                //command Decode

                //read file
                if (args[0].equalsIgnoreCase("decode")) {
                    while (true) {
                        System.out.print(FILE_EXECUTION);
                        args[1] = scanner.nextLine();

                        if (args[1].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (args[1].isEmpty()) {
                            args[1] = PATH_TO_DEFAULT_ENCRYPTION;
                            break;
                        } else if (!Files.exists(Path.of(args[1]))) {
                            System.out.println(FILE_NOT_FOUND);
                        } else {
                            break;
                        }
                    }


                    //write file
                    System.out.print(FILE_SAVE_RESULT);
                    args[2] = scanner.nextLine();

                    if (args[2].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (args[2].isEmpty()) {
                        args[2] = PATH_TO_DEFAULT_DECRYPTION;
                    } else if (!Files.exists(Path.of(args[2]))) {
                        try {
                            Files.createFile(Path.of(args[2]));
                        } catch (IOException e) {
                            throw new AppException("Проблема при создании файла > " + e);
                        }
                        System.out.println(FILE_NOT_FOUND_AND_CREATE);
                    }


                    // get crypto-key
                    while (true) {
                        System.out.print(KEY_ENCRYPTION);
                        args[3] = scanner.nextLine();
                        if (args[3].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (args[3].isEmpty()) {
                            System.out.println("Нельзя шифровать без ключа, повторите ввод.\n");
                        } else if (Integer.parseInt(args[3]) < 0 || Integer.parseInt(args[3]) > (ALPHABET.size() - 1)) {
                            System.out.println("Указанное значение не доступно. \n");
                        } else {
                            break;
                        }
                    }
                }


                //command BruteForce

                //read file
                if (args[0].equalsIgnoreCase("bruteforce")) {
                    while (true) {
                        System.out.print(FILE_EXECUTION);
                        args[1] = scanner.nextLine();

                        if (args[1].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (args[1].isEmpty()) {
                            args[1] = PATH_TO_DEFAULT_ENCRYPTION;
                            break;
                        } else if (!Files.exists(Path.of(args[1]))) {
                            System.out.println(FILE_NOT_FOUND);
                        } else {
                            break;
                        }
                    }

                    //write file
                    System.out.print(FILE_SAVE_RESULT);
                    args[2] = scanner.nextLine();

                    if (args[2].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (args[2].isEmpty()) {
                        args[2] = PATH_TO_DEFAULT_BRUTEFORCE;
                    } else if (!Files.exists(Path.of(args[2]))) {
                        try {
                            Files.createFile(Path.of(args[2]));
                        } catch (IOException e) {
                            throw new AppException("Проблема при создании файла > " + e);
                        }
                        System.out.println(FILE_NOT_FOUND_AND_CREATE);
                    }
                }


                //encode text.txt encode.txt 12
                Application application = new Application();
                Result result = application.run(args);
                System.out.println(result);
                System.out.println("\n");
            }

        }
    }
}

//release version 1.0.0.2 (done testing and refactoring code)
