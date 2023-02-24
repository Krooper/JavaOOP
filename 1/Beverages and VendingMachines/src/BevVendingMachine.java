import java.util.ArrayList;

public class BevVendingMachine<T extends Product> implements VendingMachine<T> {
    private ArrayList<T> bevs  = new ArrayList<T>();

    @Override
    public void initProducts(ArrayList<T> someBevs) {
        this.bevs = someBevs;
    }

    public ArrayList<T> getProducts() {
        return bevs;
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
