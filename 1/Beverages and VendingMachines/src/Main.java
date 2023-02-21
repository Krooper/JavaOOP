import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] hotBevNames = new String[] {"Americano", "Black Tea", "Green Tea", "Cappuccino", "Latte"};
        int[] hotBevVolumes = new int[] {200, 300, 450, 600};
        int[] hotBevPrices = new int[] {50, 75, 100, 150};
        int[] hotBevTemps = new int[] {50, 60, 70, 80, 90};

        ArrayList<Product> hotBevs = new ArrayList<>();

        // Инициализируем несколько горячих напитков, создаем из них список.
        for (String hotBevName : hotBevNames) {
            for (int hotBevTemp : hotBevTemps) {
                for (int i = 0; i < hotBevVolumes.length; i++) {
                    Product newHotBev = new HotBeverage(hotBevName, hotBevPrices[i], hotBevVolumes[i], hotBevTemp);
                    hotBevs.add(newHotBev);
                }
            }
        }
        // У нас есть класс BevVendingMachine, который соотв. интерфейсу VendingMachine. Создадим сначала его экземпляр
        BevVendingMachine someBevMachine = new BevVendingMachine();
        someBevMachine.initProducts(hotBevs);

        // При попытке вызвать метод только по имени, он скажет, что надо запрашивать по-другому
        // (указывая другие параметры) - как этот метод и переопределен в классе HotBevVendingMachine.
        System.out.println(someBevMachine.getProduct("Americano"));

        // При попытке вызвать метод только по имени и объемы, мы получим желаемый результат
        System.out.println(someBevMachine.getProduct("Americano", 450));

        // При использовании метода с температурой, он скажет, что не знает такого и у него таких напитков нет
        System.out.println(someBevMachine.getProduct("Americano", 300, 80));

        System.out.println();

        HotBevVendingMachine someHotBevMachine = new HotBevVendingMachine();
        someHotBevMachine.initProducts(hotBevs);

        // При попытке вызвать метод только по имени, он скажет, что надо запрашивать по-другому
        // (указывая другие параметры) - как этот метод и переопределен в классе HotBevVendingMachine.
        System.out.println(someHotBevMachine.getProduct("Americano"));

        // Аналогичный результат при использовании названия и объема
        System.out.println(someHotBevMachine.getProduct("Americano", 450));

        // При использовании же перегруженного метода (с использованием всех характеристик напитка)
        // мы получим тот результат, который и ожидаем.
        System.out.println(someHotBevMachine.getProduct("Americano", 300, 80));


        // Создадим экземпляр итератора и вызовем его методы
        BevIterator HotBevIterator = new BevIterator(someHotBevMachine);

        // Пройдемся по всем напиткам в аппарате
        for (Product bev : someHotBevMachine.getProducts()){
            System.out.println(HotBevIterator.next());
        }
        // Видим, что последним выводится null
        // Видим, что и метод hasNext() также выводит false
        System.out.println(HotBevIterator.hasNext());

    }
}