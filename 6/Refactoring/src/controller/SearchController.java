package controller;

import model.Shop;
import model.User;
import model.Search;

import java.util.HashMap;

public class SearchController {
    private Shop shopForSearching;
    public Shop getShopForSearching() {
        return shopForSearching;
    }
    public void setShopForSearching(Shop shopForSearcing) {
        this.shopForSearching = shopForSearcing;
    }

    private User initialUSer;
    public User getInitialUSer() {
        return initialUSer;
    }
    public void setInitialUSer(User initialUSer) {
        this.initialUSer = initialUSer;
    }

    public SearchController(Shop shopForSearching, User initialUSer) {
        this.shopForSearching = shopForSearching;
        this.initialUSer = initialUSer;
    }
    // Запрашиваем у пользователя критерии, по которым он хочет сделать фильтр и печатаем их.
    public void newSearch (){
        this.initialUSer.setRequestedCriteria();
        this.initialUSer.printCriteria();

        // Запрашиваем у пользователя конкретные характеристики для фильтрации
        this.initialUSer.setRequestedChars();
        HashMap<String, String> filterMap = this.initialUSer.getRequestedChars();

        // Переформатируем требования пользователя в запрос для магазина, выводим пользователю его запрос
        this.shopForSearching.setRequest(filterMap);
        this.shopForSearching.getRequest().printRequest();

        // Создадим фильтр по поступившему запросу:
        Search newUserFilter = new Search(this.shopForSearching.getRequest());
        this.initialUSer.setFilter(newUserFilter);
    }
}
