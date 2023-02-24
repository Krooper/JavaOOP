import java.util.ArrayList;

public class HotBevVendingMachine<T extends Product> extends BevVendingMachine<T> {

    private ArrayList<T> hotBevs = new ArrayList<T>();

    public void initProducts(ArrayList<T> someBevs) {
        this.hotBevs = someBevs;
    }

    public ArrayList<T> getProducts() {
        return hotBevs;
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
