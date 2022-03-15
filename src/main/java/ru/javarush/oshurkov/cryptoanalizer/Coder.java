package ru.javarush.oshurkov.cryptoanalizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.newBufferedWriter;


public class Coder {

//    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\":-!? ";
    public static final String FILE_NOT_FOUND = "Файл не существует, повторите попытку";

    public static void main(String[] args) {

        Scanner scannerConsole = new Scanner(System.in);
        Path pathToCodingFile;
        Path pathToEncodingFile;


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

        // Запускаем процесс чтение и записи в указанные файлы
/*

        try (BufferedReader readeOfCodingFile = newBufferedReader(pathToCodingFile);
             BufferedWriter writeOfEncodingFile = newBufferedWriter(pathToEncodingFile)) {


        } catch (IOException e) {
            throw new ExceptionProject("Проблема > " + e);
        }
*/

    }
}

