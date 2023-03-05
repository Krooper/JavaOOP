package source;

import model.Notebook;
import source.CharSource;

import java.util.HashSet;
// Класс с методом для создания множества ноутбуков со случайными характеристиками,
// ограниченных их набором в соотв. массиве
public class NotebooksDB {

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

}
