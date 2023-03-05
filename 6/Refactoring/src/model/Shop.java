package model;

import service.SearchService;

import java.util.*;

public class Shop {
    // Базовый конструктор для магазина.
    public Shop(String name) {
        this.name = name;
    }

    // Поле с названием магазина
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Поле со всеми ноутбуками в магазине
    private static HashSet<Notebook> notebooks;
    public static HashSet<Notebook> getNotebooks() {
        return notebooks;
    }
    public void setNotebooks(HashSet<Notebook> someNotes) {
        notebooks = someNotes;
    }

    // Поле request, являющееся отдельным классом, для обработки запроса от пользователя.
    // В реальности, наверное, это должен быть список запросов (для хранения истории),
    // но тут для примера пусть будет только один.
    private SearchService request;
    public void setRequest(HashMap<String, String> filter) {
        SearchService newRequest = new SearchService();
        newRequest.setUserRequest(filter);

        if (newRequest.getBrands().size() == 0) {
            newRequest.setBrands();
        }
        if (newRequest.getRams().size() == 0) {
            newRequest.setRams();
        }
        if (newRequest.getRoms().size() == 0) {
            newRequest.setRoms();
        }
        if (newRequest.getScreens().size() == 0) {
            newRequest.setScreens();
        }
        if (newRequest.getProcs().size() == 0) {
            newRequest.setProcs();
        }
        if (newRequest.getOss().size() == 0) {
            newRequest.setOss();
        }
        if (newRequest.getColours().size() == 0) {
            newRequest.setColours();
        }
        if (newRequest.getInStocks().size() == 0) {
            newRequest.setInStocks();
        }
        this.request = newRequest;
    }
    public SearchService getRequest() {
        return request;
    }

    // Метод для печати всех ноутбуков в магазине
    @Override
    public String toString() {
        StringBuilder outStr = new StringBuilder();
        for (Notebook notebook: notebooks) {
            outStr.append(outStr).append(notebook.toString());
        }
        return outStr.toString();
    }
}
