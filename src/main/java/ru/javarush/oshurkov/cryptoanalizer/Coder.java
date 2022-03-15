package ru.javarush.oshurkov.cryptoanalizer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.newBufferedWriter;


public class Coder {

    //    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\":-!? ";
    public static final String FILE_NOT_FOUND = "Файл не существует, повторите попытку \n";
    public static final String NOT_FOUND_KEY = "Ключ выходит за пределы допустимых значений, повторите попытку \n";
    public static final String NOT_FOUND_NUMBER = "Введено не число, укажите число в уканных пределах \n";

    public static void main(String[] args) {

        Scanner scannerConsole = new Scanner(System.in);
        Path pathToCodingFile;
        Path pathToEncodingFile;
        int key;


//        Указываем пути к файлам и проверяем их на наличие файла по указанному пути
        while (true) {
            System.out.println("Введите путь до файла для шифрования");
            pathToCodingFile = Path.of(scannerConsole.nextLine());
            if (!Files.isRegularFile(pathToCodingFile)) {
                System.out.println(FILE_NOT_FOUND);
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Введите путь до файла для расшифровки");
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
            System.out.print("Укажите ключ шифрования от 1 до 127 = ");

            if (scannerConsole.hasNextInt()) {
                key = scannerConsole.nextInt();

                if (key < 1 || key > 127) {
                    System.out.println(NOT_FOUND_KEY);
                } else {
                    break;
                }

            } else {
                System.out.println(NOT_FOUND_NUMBER);
            }

        } while (true);

        // Запускаем процесс чтение и записи в указанные файлы

 /*       try (BufferedReader readeOfCodingFile = newBufferedReader(pathToCodingFile);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathToEncodingFile)) {


        } catch (IOException e) {
            throw new ExceptionProject("Проблема > " + e);
        }*/

    }
}
