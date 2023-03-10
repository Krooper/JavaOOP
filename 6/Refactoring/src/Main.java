import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
 * отвечающие фильтру. Критерии фильтрации можно хранить в Map.
 * Например: “Введите цифру, соответствующую необходимому критерию:
 * <p>
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет
 * <p>
 * Далее нужно запросить минимальные значения для указанных критериев -
 * сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Main {
    // Метод для создания множества ноутбуков со случайными характеристиками, ограниченных их набором в соотв. массиве
    public static HashSet<Notebook> getNotebookSet() {
        HashSet<Notebook> notebooks = new HashSet<>();
        Notebook.setCriteriaMap();
        Notebook.setCharacteristicsMap();
        for (int i = 0; i < 100; i++) {
            String brand = CharSource.brands[(int) Math.floor(Math.random() * CharSource.brands.length)];
            Integer ram = CharSource.rams[(int) Math.floor(Math.random() * CharSource.rams.length)];
            Integer hardDriveCap = CharSource.roms[(int) Math.floor(Math.random() * CharSource.roms.length)];
            String proc = CharSource.procs[(int) Math.floor(Math.random() * CharSource.procs.length)];
            Double screenDiag = CharSource.screenDiags[(int) Math.floor(Math.random() * CharSource.screenDiags.length)];
            String os = CharSource.oss[(int) Math.floor(Math.random() * CharSource.oss.length)];
            String colour = CharSource.colours[(int) Math.floor(Math.random() * CharSource.colours.length)];
            Boolean inStock = CharSource.inStocks[(int) Math.floor(Math.random() * CharSource.inStocks.length)];
            Integer price = (int) (Math.random() * (100_000 + 1));
            Notebook newNotebook = new Notebook(i + 1, brand, ram, hardDriveCap, proc,
                    screenDiag, os, colour, inStock, price);
            notebooks.add(newNotebook);
        }
        return notebooks;
    }



    public static void main(String[] args) {
        Shop myShop = new Shop("New Shop");
        myShop.setNotebooks(getNotebookSet());
        User newUser = new User("Петя");
        /*
 Можно вывести все получившиеся ноутбуки:
        myShop.printNotebooks();
*/
        boolean end = false;
        while (!end) {
            // Запрашиваем у пользователя критерии, по которым он хочет сделать фильтр и печатаем их.
            newUser.setRequestedCriteria();
            newUser.printCriteria();

            // Запрашиваем у пользователя конкретные характеристики для фильтрации
            newUser.setRequestedChars();
            HashMap<String, String> filterMap = newUser.getRequestedChars();

            // Переформатируем требования пользователя в запрос для магазина, выводим пользователю его запрос
            myShop.setRequest(filterMap);
            myShop.printRequest();

            // Выводим список отфильтрованных ноутбуков
            myShop.printFilteredNotes();

            // Вопрос, хочет ли пользователь еще раз отфильтровать по другим критериям и характеристикам
            System.out.println("Do you want to make another request?\nInput 'N to stop', Enter to continue");
            Scanner scan = new Scanner(System.in);
            String n = scan.nextLine();
            if (Objects.equals(n, "n") || Objects.equals(n, "N")) {
                end = true;
            }
        }
    }
}
