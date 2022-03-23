package ru.javarush.oshurkov.cryptoanalizer.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');

    public static final List<String> DICTIONARY = Arrays.asList("но ", "если ", "то ", " к ", " по ", " и ", " пр");

    public static final String ENTER_COMMAND = "Укажите команду: ";
    public static final String FILE_EXECUTION = "Укажите путь до файла исполнения: ";
    public static final String FILE_SAVE_RESULT = "Укажите путь до файла с результатом: ";
    public static final String KEY_ENCRYPTION = "Укажите ключ шифрования от 0 до " + (ALPHABET.size() - 1) + ": "  ;
    public static final String PATH_TO_DEFAULT_TEXT = "text\\text.txt";
    public static final String PATH_TO_DEFAULT_ENCRYPTION = "text\\encrypted.txt";
    public static final String PATH_TO_DEFAULT_DECRYPTION = "text\\decrypted.txt";
    public static final String PATH_TO_DEFAULT_BRUTEFORCE = "text\\bruteforce.txt";

}
