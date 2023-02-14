import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotBevVendingMachine extends BevVendingMachine {

    private ArrayList<Product> hotBevs = new ArrayList<>();

    public void initProducts(ArrayList<Product> someBevs) {
        hotBevs.addAll(someBevs);
    }

    @Override
    public String getProduct(String name) {
        return "We have different options for " + name + ". Please choose precisely!";
    }

    @Override
    public String getProduct(String name, int volume) {
        return "We have different options for " + name + " of volume " + volume + ". Please choose precisely!";
    }

    @Override
    public String getProduct(String name, int volume, int temp) {
        return "Here's your " + name + " of volume " +
                volume + " ml, its temperature - " + temp + " Celsius.";
    }
}
