import java.util.ArrayList;
import java.util.List;

//Задача из Билета №12:
// Необходимо реализовать следующий метод:
//        1. На вход получаем список названий книг
//        2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
//        3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
//        4. Количество полок константное - 5 штук
//        5. Вернуть книги распределенные по полкам

public class Main {
    public static void main(String[] args) {
        //Заполненный список с названиями книг
        List<String> bookNames = List.of("M", "E", "F", "A", "D", "C", "H", "I", "G", "J", "B", "L", "K");
        System.out.println(distributionBooksOnShelves(bookNames));
    }

    public static List<List<String>> distributionBooksOnShelves(List<String> bookNames) {
        int countShelves = 5;//Количество полок для книг
        List<List<String>> shelves = new ArrayList<>(countShelves); //Список пустых полок
        List<String> shelf = new ArrayList<>(); //Полка, которая будет наполняться книгами
        //Сортировка книг в алфавитном порядке
        List<String> newBookNames = bookNames.stream().sorted().toList();
        int countSumBooks = newBookNames.size();//Количество книг в списке
        //Количество книг, которое может поместиться на одной полке
        double roundResult = (double) countSumBooks / countShelves;
        int countBookOnShelf = (int) Math.ceil(roundResult);//Округление до целого числа в большую сторону
        //Распределение книг по полкам
        for (String book : newBookNames) {
            shelf.add(book);
            //Сверяем количество книг с максимально возможным и если оно равно, добавляем следующую полку
            if (shelf.size() == countBookOnShelf) {
                shelves.add(shelf);
                shelf = new ArrayList<>();
            }
        }
        //Проверяем наполненность полок и выводим список полок с книгами.
        if (shelf.size() > 0) {
            shelves.add(shelf);
        }
        return shelves;
    }
}