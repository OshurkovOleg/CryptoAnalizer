package ru.javarush.oshurkov.cryptoanalizer.constants;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');

    public static final List<String> DICTIONARY = Arrays.asList("но ", "если ", "то ", " к ", " по ", " и ", " пр");

}
