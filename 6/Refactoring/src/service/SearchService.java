package service;

import service.Parsers;
import source.CharSource;

import java.util.*;

// Отдельный класс "запрос для магазина" - для преобразования запроса пользователя в запрос для магазина.
// Включает в себя все критерии и характеристики, выбранные пользователем.
// В случае же, если пользователь не выбрал критериев, добавляет все критерии.
public class ShopRequest {
    private ArrayList<String> brands = new ArrayList<>();
    public ArrayList<String> getBrands() {
        return brands;
    }
    public void setBrands() {
        Collections.addAll(this.brands, CharSource.brands);
    }

    private ArrayList<Integer> rams = new ArrayList<>();
    public ArrayList<Integer> getRams() {
        return rams;
    }
    public void setRams() {
        Collections.addAll(this.rams, CharSource.rams);
    }

    private ArrayList<Integer> roms = new ArrayList<>();
    public ArrayList<Integer> getRoms() {
        return roms;
    }
    public void setRoms() {
        Collections.addAll(this.roms, CharSource.roms);
    }

    private ArrayList<String> procs = new ArrayList<>();
    public ArrayList<String> getProcs() {
        return procs;
    }
    public void setProcs() {
        Collections.addAll(this.procs, CharSource.procs);
    }

    private ArrayList<Double> screens = new ArrayList<>();

    public ArrayList<Double> getScreens() {
        return screens;
    }
    public void setScreens() {
        Collections.addAll(this.screens, CharSource.screenDiags);
    }

    private ArrayList<String> oss = new ArrayList<>();
    public ArrayList<String> getOss() {
        return oss;
    }
    public void setOss() {
        Collections.addAll(this.oss, CharSource.oss);
    }

    private ArrayList<String> colours = new ArrayList<>();
    public ArrayList<String> getColours() {
        return colours;
    }
    public void setColours() {
        Collections.addAll(this.colours, CharSource.colours);
    }

    private ArrayList<Boolean> inStocks = new ArrayList<>();
    public ArrayList<Boolean> getInStocks() {
        return inStocks;
    }
    public void setInStocks() {
        Collections.addAll(this.inStocks, CharSource.inStocks);
    }

    private int maxPrice = 100_000_000;
    public int getMaxPrice() {
        return maxPrice;
    }
    public void setMaxPrice(int maxPrice) {
        this.maxPrice = 100_000_000;
    }

    public void setUserRequest(HashMap<String, String> filter) {
        ArrayList<String> brands = new ArrayList<>();
        ArrayList<Integer> rams = new ArrayList<>();
        ArrayList<Integer> roms = new ArrayList<>();
        ArrayList<String> procs = new ArrayList<>();
        ArrayList<Double> screens = new ArrayList<>();
        ArrayList<String> oss = new ArrayList<>();
        ArrayList<String> colours = new ArrayList<>();
        ArrayList<Boolean> inStocks = new ArrayList<>();
        int maxPrice = 100_000_000;


        for (Map.Entry<String, String> entry : filter.entrySet()) {
            if (Parsers.tryParseInt(entry.getValue())) {
                int intCharacteristic = Integer.parseInt(entry.getValue());
                if (Objects.equals(entry.getKey(), "Price")) {
                    maxPrice = intCharacteristic;
                } else if (Objects.equals(entry.getKey().charAt(0), '2')) {
                    rams.add(intCharacteristic);
                } else if (Objects.equals(entry.getKey().charAt(0), '3')) {
                    roms.add(intCharacteristic);
                }
            } else if (Parsers.tryParseDouble(entry.getValue())) {
                double doubleCharacteristic = Double.parseDouble(entry.getValue());
                screens.add(doubleCharacteristic);
            } else if (Objects.equals(entry.getKey().charAt(0), '9')) {
                boolean boolCharacteristic = Boolean.parseBoolean(entry.getValue());
                inStocks.add(boolCharacteristic);
            } else {
                if (Objects.equals(entry.getKey().charAt(0), '1')) {
                    brands.add(entry.getValue());
                } else if (Objects.equals(entry.getKey().charAt(0), '4')) {
                    procs.add(entry.getValue());
                } else if (Objects.equals(entry.getKey().charAt(0), '6')) {
                    oss.add(entry.getValue());
                } else if (Objects.equals(entry.getKey().charAt(0), '7')) {
                    colours.add(entry.getValue());
                } else {
                    colours.add(entry.getValue());
                }
            }
        }
        this.brands = brands;
        this.rams = rams;
        this.roms = roms;
        this.procs = procs;
        this.screens = screens;
        this.oss = oss;
        this.colours = colours;
        this.inStocks = inStocks;
        this.maxPrice = maxPrice;
    }

    public void printRequest() {
        System.out.println();

        StringBuilder outStr = new StringBuilder();
        outStr.append("Brands:\n");
        if (this.getBrands().size() == CharSource.brands.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (String brand : this.getBrands()) {
                outStr.append("\t").append(brand).append("\n");
            }
        }

        outStr.append("Rams, Gb:\n");
        if (this.getRams().size() == CharSource.rams.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (int ram : this.getRams()) {
                outStr.append("\t").append(ram).append("\n");
            }
        }

        outStr.append("Roms, Gb:\n");
        if (this.getRoms().size() == CharSource.roms.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (int rom : this.getRoms()) {
                outStr.append("\t").append(rom).append("\n");
            }
        }

        outStr.append("Processors:\n");
        if (this.getProcs().size() == CharSource.procs.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (String proc : this.getProcs()) {
                outStr.append("\t").append(proc).append("\n");
            }
        }

        outStr.append("Screen sizes:\n");
        if (this.getScreens().size() == CharSource.screenDiags.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (Double screen : this.getScreens()) {
                outStr.append("\t").append(screen).append("\"").append("\n");
            }
        }

        outStr.append("OS:\n");
        if (this.getOss().size() == CharSource.oss.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (String os : this.getOss()) {
                outStr.append("\t").append(os).append("\n");
            }
        }

        outStr.append("Colours:\n");
        if (this.getColours().size() == CharSource.colours.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (String colour : this.getColours()) {
                outStr.append("\t").append(colour).append("\n");
            }
        }

        outStr.append("In Stock:\n");
        if (this.getInStocks().size() == CharSource.inStocks.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (Boolean colour : this.getInStocks()) {
                if (colour) {
                    outStr.append("\t").append("Yes").append("\n");
                } else {
                    outStr.append("\t").append("No").append("\n");
                }
            }
        }

        outStr.append("Max. price: ");
        if (this.getMaxPrice() == 100_000_000) {
            outStr.append("Any").append("\n");
        } else {
            outStr.append(this.getMaxPrice()).append(" RUB").append("\n");
        }

        System.out.println(outStr);
    }
}
