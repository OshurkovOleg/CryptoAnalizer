package ru.javarush.oshurkov.cryptoanalizer;

import static ru.javarush.oshurkov.cryptoanalizer.constants.Constants.*;

import ru.javarush.oshurkov.cryptoanalizer.controllers.Actions;
import ru.javarush.oshurkov.cryptoanalizer.entity.Result;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class ConsoleRunner {


    public static void main(String[] args) {
        args = new String[4];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доброе пожаловать в программу шифрования");
        System.out.println("========================================\n");
        System.out.println("Укажите одну из доступных команд: " + Actions.ENCODE + ", "
                + Actions.DECODE + ", "
                + Actions.BRUTEFORCE + ", для выхода exit. \n");

        while (true) {

            System.out.print(ENTER_COMMAND);
            args[0] = scanner.nextLine();

            if (args[0].equalsIgnoreCase("exit")) {
                System.exit(0);
            }


            //command encode
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
                        System.out.println("По указанному пути файл не существует, повторите попытку");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print(FILE_SAVE_RESULT);
                    args[2] = scanner.nextLine();

                    if (args[2].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (args[2].isEmpty()) {
                        args[2] = PATH_TO_DEFAULT_ENCRYPTION;
                        break;
                    } else if (!Files.exists(Path.of(args[2]))) {
                        System.out.println("По указанному пути файл не существует, повторите попытку");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print(KEY_ENCRYPTION);
                    args[3] = scanner.nextLine();
                    if (args[3].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (args[3].isEmpty()) {
                        System.out.println("Нельзя шифровать без ключа, повторите ввод.");
                    } else if (Integer.parseInt(args[3]) < 0 || Integer.parseInt(args[3]) > (ALPHABET.size() - 1)) {
                        System.out.println("Пожалуйста." + KEY_ENCRYPTION);
                    } else {
                        break;
                    }
                }
            }

            //command decode

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
                        System.out.println("По указанному пути файл не существует, повторите попытку");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print(FILE_SAVE_RESULT);
                    args[2] = scanner.nextLine();

                    if (args[2].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (args[2].isEmpty()) {
                        args[2] = PATH_TO_DEFAULT_DECRYPTION;
                        break;
                    } else if (!Files.exists(Path.of(args[2]))) {
                        System.out.println("По указанному пути файл не существует, повторите попытку");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print(KEY_ENCRYPTION);
                    args[3] = scanner.nextLine();
                    if (args[3].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (args[3].isEmpty()) {
                        System.out.println("Нельзя шифровать без ключа, повторите ввод.");
                    } else if (Integer.parseInt(args[3]) < 0 || Integer.parseInt(args[3]) > (ALPHABET.size() - 1)) {
                        System.out.println("Пожалуйста." + KEY_ENCRYPTION);
                    } else {
                        break;
                    }
                }
            }

            //command bruteforce

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
                        System.out.println("По указанному пути файл не существует, повторите попытку");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print(FILE_SAVE_RESULT);
                    args[2] = scanner.nextLine();

                    if (args[2].equalsIgnoreCase("exit")) {
                        System.exit(0);
                    } else if (args[2].isEmpty()) {
                        args[2] = PATH_TO_DEFAULT_BRUTEFORCE;
                        break;
                    } else if (!Files.exists(Path.of(args[2]))) {
                        System.out.println("По указанному пути файл не существует, повторите попытку");
                    } else {
                        break;
                    }
                }
            }


            //encode text.txt encode.txt 12
            Application application = new Application();
            Result result = application.run(args);
            System.out.println(result);

            System.out.println("Для выхода укажите команду exit, чтобы продолжить нажмите enter");

            if (scanner.nextLine().equalsIgnoreCase("exit")) {
                System.exit(0);
            }

        }
    }
}
