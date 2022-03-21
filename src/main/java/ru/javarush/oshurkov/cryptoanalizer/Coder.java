package ru.javarush.oshurkov.cryptoanalizer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.newBufferedWriter;


public class Coder {

    private static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');

    private static final List<String> DICTIONARY = Arrays.asList("но ", "если ", "то ", " к ", " по ", " и ", " пр");

    public static final String FILE_NOT_FOUND = "Файл не существует, повторите попытку \n";
    public static final String NOT_FOUND_KEY = "Ключ выходит за пределы допустимых значений, повторите попытку \n";
    public static final String NOT_FOUND_NUMBER = "Введено не число, укажите число в уканных пределах \n";
    static Path pathToCodingFile;
    static Path pathToEncodingFile;
    static int key = 0;
    static char codeChar = 0;
    static char uncodeChar = 0;
    static Scanner scannerConsole = new Scanner(System.in);
    static int hackKey = 0;
    public static int count = 0;
    public static StringBuilder str = new StringBuilder();
    public static List<Character> listCharText = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("Доброе пожаловать в программу для кодирования текста.");
        System.out.println("========================================================");
        System.out.println();

        bruteForce();


    }


    static public void codingText() {
        while (true) {
            System.out.print("Укажите путь до файла который будем кодировать: ");
            pathToCodingFile = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(pathToCodingFile)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Укажите путь и название файла куда будем сохранять результат : ");
            pathToEncodingFile = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(pathToEncodingFile)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }

        do {
            scannerConsole.nextLine();
            System.out.print("Укажите ключ кодировки текста от 0 до " + (ALPHABET.size() - 1) + " : ");

            if (scannerConsole.hasNextInt()) {
                key = scannerConsole.nextInt();

                if (key < 0 || key > (ALPHABET.size() - 1)) {
                    System.out.println(NOT_FOUND_KEY);
                } else {
                    break;
                }

            } else {
                System.out.println(NOT_FOUND_NUMBER);
            }

        } while (true);


        try (BufferedReader readeOfCodingFile = newBufferedReader(pathToCodingFile);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathToEncodingFile)) {


            while (readeOfCodingFile.ready()) {
                char a = Character.toLowerCase((char) readeOfCodingFile.read());

                if (ALPHABET.contains(a)) {
                    codeChar = ALPHABET.get((ALPHABET.indexOf(a) + key) % ALPHABET.size());
                    writeOfEncodingFile.write(codeChar);
                }
            }
        } catch (IOException e) {
            throw new ExceptionProject("Проблема > " + e);
        }
    }


    static public void uncodingText() {
        while (true) {
            System.out.print("Укажите путь до файла который будем раскодировать: ");
            pathToCodingFile = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(pathToCodingFile)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Укажите путь и название файла куда будем сохранять результат : ");
            pathToEncodingFile = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(pathToEncodingFile)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }

        do {
            scannerConsole.nextLine();
            System.out.print("Укажите ключ для раскодирования текста : ");

            if (scannerConsole.hasNextInt()) {
                key = scannerConsole.nextInt();

                if (key < 0 || key > (ALPHABET.size() - 1)) {
                    System.out.println(NOT_FOUND_KEY);
                } else {
                    break;
                }

            } else {
                System.out.println(NOT_FOUND_NUMBER);
            }

        } while (true);

        try (BufferedReader readeOfCodingFile = newBufferedReader(pathToCodingFile);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathToEncodingFile)) {

            Collections.reverse(ALPHABET);

            while (readeOfCodingFile.ready()) {

                char symbol = Character.toLowerCase((char) readeOfCodingFile.read());

                if (ALPHABET.contains(symbol)) {
                    codeChar = ALPHABET.get((ALPHABET.indexOf(symbol) + key) % ALPHABET.size());
                    writeOfEncodingFile.write(codeChar);
                }
            }
        } catch (IOException e) {
            throw new ExceptionProject("Проблема > " + e);
        }
    }


    static public void bruteForce() {

        while (true) {
            System.out.print("Укажите путь до файла который будем взламывать: ");
            pathToCodingFile = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(pathToCodingFile)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Укажите путь и название файла куда будем сохранять результат взлома : ");
            pathToEncodingFile = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(pathToEncodingFile)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }

        try (BufferedReader readeOfCodingFile = newBufferedReader(pathToCodingFile);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathToEncodingFile)) {

            Collections.reverse(ALPHABET);

            while (readeOfCodingFile.ready()) {
                char symbol = Character.toLowerCase((char) readeOfCodingFile.read());
                if (ALPHABET.contains(symbol)) {
                    listCharText.add(symbol);
                }
            }

            while (true) {

                for (Character element : listCharText) {
                    uncodeChar = ALPHABET.get((ALPHABET.indexOf(element) + hackKey) % ALPHABET.size());
                    str.append(uncodeChar);
                }

                String strRes = str.toString();

                for (String s : DICTIONARY) {
                    if (strRes.contains(s)) {
                        count++;
                    }
                }


                if (count > 3) {
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
            throw new ExceptionProject("Проблема > " + e);
        }

    }
}
