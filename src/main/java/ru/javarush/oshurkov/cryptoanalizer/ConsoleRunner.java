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

        String[] parametrsUser = new String[4];
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
            parametrsUser[0] = scanner.nextLine().toLowerCase();

            if (parametrsUser[0].equals("exit")) {
                System.exit(0);
            }

            // checking the command entered

            if (!(parametrsUser[0].equals("encode") || parametrsUser[0].equals("decode") || parametrsUser[0].equals("bruteforce"))) {
                System.out.println("Команда не обнаружена, повторите попытку.\n");
            } else {

                //command Encode

                //read file
                if (parametrsUser[0].equalsIgnoreCase("encode")) {
                    while (true) {
                        System.out.print(FILE_EXECUTION);
                        parametrsUser[1] = scanner.nextLine();

                        if (parametrsUser[1].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (parametrsUser[1].isEmpty()) {
                            parametrsUser[1] = PATH_TO_DEFAULT_TEXT;
                            break;
                        } else if (!Files.exists(Path.of(parametrsUser[1]))) {
                            System.out.println(FILE_NOT_FOUND);
                        } else {
                            break;
                        }
                    }


                    //write file

                    System.out.print(FILE_SAVE_RESULT);
                    parametrsUser[2] = scanner.nextLine();

                    if (parametrsUser[2].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (parametrsUser[2].isEmpty()) {
                        parametrsUser[2] = PATH_TO_DEFAULT_ENCRYPTION;
                    } else if (!Files.exists(Path.of(parametrsUser[2]))) {
                        try {
                            Files.createFile(Path.of(parametrsUser[2]));
                        } catch (IOException e) {
                            throw new AppException("Проблема при создании файла > " + e);
                        }
                        System.out.println(FILE_NOT_FOUND_AND_CREATE);

                    }


                    //get crypto-key

                    while (true) {
                        System.out.print(KEY_ENCRYPTION);
                        parametrsUser[3] = scanner.nextLine();
                        if (parametrsUser[3].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (parametrsUser[3].isEmpty()) {
                            System.out.println("Нельзя шифровать без ключа, повторите ввод.\n");
                        } else if (Integer.parseInt(parametrsUser[3]) < 0 || Integer.parseInt(parametrsUser[3]) > (ALPHABET.size() - 1)) {
                            System.out.println("Указанное значение не доступно. \n");
                        } else {
                            break;
                        }
                    }
                }


                //command Decode

                //read file
                if (parametrsUser[0].equalsIgnoreCase("decode")) {
                    while (true) {
                        System.out.print(FILE_EXECUTION);
                        parametrsUser[1] = scanner.nextLine();

                        if (parametrsUser[1].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (parametrsUser[1].isEmpty()) {
                            parametrsUser[1] = PATH_TO_DEFAULT_ENCRYPTION;
                            break;
                        } else if (!Files.exists(Path.of(parametrsUser[1]))) {
                            System.out.println(FILE_NOT_FOUND);
                        } else {
                            break;
                        }
                    }


                    //write file
                    System.out.print(FILE_SAVE_RESULT);
                    parametrsUser[2] = scanner.nextLine();

                    if (parametrsUser[2].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (parametrsUser[2].isEmpty()) {
                        parametrsUser[2] = PATH_TO_DEFAULT_DECRYPTION;
                    } else if (!Files.exists(Path.of(parametrsUser[2]))) {
                        try {
                            Files.createFile(Path.of(parametrsUser[2]));
                        } catch (IOException e) {
                            throw new AppException("Проблема при создании файла > " + e);
                        }
                        System.out.println(FILE_NOT_FOUND_AND_CREATE);
                    }


                    // get crypto-key
                    while (true) {
                        System.out.print(KEY_ENCRYPTION);
                        parametrsUser[3] = scanner.nextLine();
                        if (parametrsUser[3].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (parametrsUser[3].isEmpty()) {
                            System.out.println("Нельзя шифровать без ключа, повторите ввод.\n");
                        } else if (Integer.parseInt(parametrsUser[3]) < 0 || Integer.parseInt(parametrsUser[3]) > (ALPHABET.size() - 1)) {
                            System.out.println("Указанное значение не доступно. \n");
                        } else {
                            break;
                        }
                    }
                }


                //command BruteForce

                //read file
                if (parametrsUser[0].equalsIgnoreCase("bruteforce")) {
                    while (true) {
                        System.out.print(FILE_EXECUTION);
                        parametrsUser[1] = scanner.nextLine();

                        if (parametrsUser[1].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        } else if (parametrsUser[1].isEmpty()) {
                            parametrsUser[1] = PATH_TO_DEFAULT_ENCRYPTION;
                            break;
                        } else if (!Files.exists(Path.of(parametrsUser[1]))) {
                            System.out.println(FILE_NOT_FOUND);
                        } else {
                            break;
                        }
                    }

                    //write file
                    System.out.print(FILE_SAVE_RESULT);
                    parametrsUser[2] = scanner.nextLine();

                    if (parametrsUser[2].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (parametrsUser[2].isEmpty()) {
                        parametrsUser[2] = PATH_TO_DEFAULT_BRUTEFORCE;
                    } else if (!Files.exists(Path.of(parametrsUser[2]))) {
                        try {
                            Files.createFile(Path.of(parametrsUser[2]));
                        } catch (IOException e) {
                            throw new AppException("Проблема при создании файла > " + e);
                        }
                        System.out.println(FILE_NOT_FOUND_AND_CREATE);
                    }
                }


                //encode text.txt encode.txt 12
                Application application = new Application();
                Result result = application.run(parametrsUser);
                System.out.println(result);
                System.out.println("\n");
            }

        }
    }
}

//release version 1.0.0.2 (done testing and refactoring code)
