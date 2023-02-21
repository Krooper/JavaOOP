import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BevVendingMachine implements VendingMachine {

    public ArrayList<Product> getProducts() {
        return bevs;
    }

    private ArrayList<Product> bevs = new ArrayList<>();

    public void initProducts(ArrayList<Product> someBevs) {
        bevs.addAll(someBevs);
    }

    @Override
    public String getProduct(String name) {
        return "We have different options for " + name + ". Please choose precisely!";
    }

    @Override
    public String getProduct(String name, int volume) {
        return "Here's your " + name + " of volume " +
                volume + " ml";
    }

    @Override
    public String getProduct(String name, int volume, int temp) {
        return "I don't know what a temperature is. I do not have such drinks :(";
    }
}
