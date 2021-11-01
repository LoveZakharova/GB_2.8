package JC_Lesson4;

import java.util.*;

public class WordsArray {
    public static void main(String[] args){

        List<String> wordsArray = new ArrayList<>();
        Collections.addAll(wordsArray,"Метод", "Класс", "Объект", "Массив", "Переопределение",
                "Конструктор", "Наследование", "Полиморфизм", "Переопределение", "Инкапсуляция",
                "Цикл", "Переменная", "Исключения", "Класс", "Массив",
                "Переопределение");

        //Найти и вывести список уникальных слов
        System.out.println("Всего слов в списке: ");
        System.out.println(wordsArray.size());
        Set<String> unique = new HashSet<>(wordsArray);
        System.out.println("Уникальных слов в списке: ");
        System.out.println(unique.size());

        //Посчитать, сколько раз встречается каждое слово.
        System.out.println("Сколько раз встречается каждое слово");
        for (String key: unique) {
            System.out.println(key + ": " + Collections.frequency(wordsArray, key));
        }
    }
}
