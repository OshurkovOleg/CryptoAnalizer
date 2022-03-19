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

    public static final String FILE_NOT_FOUND = "Файл не существует, повторите попытку \n";
    public static final String NOT_FOUND_KEY = "Ключ выходит за пределы допустимых значений, повторите попытку \n";
    public static final String NOT_FOUND_NUMBER = "Введено не число, укажите число в уканных пределах \n";
    static Path pathToCodingFile;
    static Path pathToEncodingFile;
    static int key = 0;
    static char codeChar = 0;
    static Scanner scannerConsole = new Scanner(System.in);

    public static void main(String[] args) {

/*
        System.out.println("Доброе пожаловать в программу для шифрования информации.");
        System.out.println("========================================================");
        System.out.println();


//        Указываем пути к файлам и проверяем их на наличие файла по указанному пути
        while (true) {
            System.out.print("Укажите путь до исполняемого файла: ");
            pathToCodingFile = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(pathToCodingFile)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Укажите путь до файла с результатом выполнения: ");
            pathToEncodingFile = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(pathToEncodingFile)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }

        // Задаем ключ шифрования в пределах от 1 до 127
        do {
            scannerConsole.nextLine();
            System.out.print("Укажите ключ шифрования от 0 до " + (ALPHABET.size() - 1) + " : ");

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
*/


//**************************************************************************************************
        // Кодируем текст

/*        try (BufferedReader readeOfCodingFile = newBufferedReader(pathToCodingFile);
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
        }*/


//*****************************************************************************************************
        // Расшифровать текст используя ключ

/*
        try (BufferedReader readeOfCodingFile = newBufferedReader(pathToCodingFile);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathToEncodingFile)) {

            Collections.reverse(ALPHABET);

            while (readeOfCodingFile.ready()) {

                char b = Character.toLowerCase((char) readeOfCodingFile.read());

                if (ALPHABET.contains(b)) {
                        codeChar = ALPHABET.get((ALPHABET.indexOf(b) + key) % ALPHABET.size());
                        writeOfEncodingFile.write(codeChar);
                }
            }
        } catch (IOException e) {
            throw new ExceptionProject("Проблема > " + e);
        }
*/


//***********************************************************************************************************
        // Взлом закодиранного текста с перебором ключа


/*        try (BufferedReader readeOfCodingFile = newBufferedReader(Path.of("C:\\test\\file.txt"));
             BufferedWriter writeOfEncodingFile = newBufferedWriter(Path.of("C:\\test\\result.txt"))) {

            int hackKey = 0;
            Collections.reverse(ALPHABET);

            while (readeOfCodingFile.ready()) {

                char b = Character.toLowerCase((char) readeOfCodingFile.read());

                if (ALPHABET.contains(b)) {
                        codeChar = ALPHABET.get((ALPHABET.indexOf(b) + hackKey) % ALPHABET.size());
                        writeOfEncodingFile.write(codeChar);


                }
            }
        } catch (IOException e) {
            throw new ExceptionProject("Проблема > " + e);
        }*/

    }
}
