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
    public static final String WHERE_SAVE_RESULT = "Куда будем сохранять результат ? \n";
    static Path pathToSourceFile;
    static Path pathToFileOfResult;
    static int key = 0;
    static char codeChar = 0;
    static char uncodeChar = 0;
    static Scanner scannerConsole = new Scanner(System.in);
    static int hackKey = 0;
    public static int count = 0;
    public static StringBuilder str = new StringBuilder();
    public static List<Character> listCharText = new ArrayList<>();


    public static void main(String[] args) {
    }


    static public void codingTextFromFile() {

        System.out.println("Какой файл будем кодировать ?");
        pathToSourceFile = pathOfFileSource();

        System.out.println(WHERE_SAVE_RESULT);
        pathToFileOfResult = pathOfFileResult();

        setKeyPasswordCoding();


        try (BufferedReader readeOfCodingFile = newBufferedReader(pathToSourceFile);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathToFileOfResult)) {

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


    static public void uncodingTextFromFile() {

        System.out.println("Какой файл будем раскодировать ?");
        pathToSourceFile = pathOfFileSource();

        System.out.println(WHERE_SAVE_RESULT);
        pathToFileOfResult = pathOfFileResult();

        setKeyPasswordCoding();


        try (BufferedReader readeOfCodingFile = newBufferedReader(pathToSourceFile);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathToFileOfResult)) {

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

        System.out.println("Какой файл будем взламывать?");
        pathToSourceFile = pathOfFileSource();

        System.out.print(WHERE_SAVE_RESULT);
        pathToFileOfResult = pathOfFileResult();

        Collections.reverse(ALPHABET);

        try (BufferedReader readeOfCodingFile = newBufferedReader(pathToSourceFile);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathToFileOfResult)) {


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


    public static Path pathOfFileSource() {
        Path path;
        while (true) {
            System.out.print("Укажите путь до файла: ");
            path = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(path)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }
        return path;
    }

    public static Path pathOfFileResult() {
        Path path;
        while (true) {
            System.out.print("Укажите путь до файла: ");
            path = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(path)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }
        return path;
    }

    public static void setKeyPasswordCoding() {

        do {
            scannerConsole.nextLine();
            System.out.print("Укажите ключ, которым будем кодировать/раскодировать текст, значение от 0 до " + (ALPHABET.size() - 1) + " : ");

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
    }


}
