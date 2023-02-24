import java.util.ArrayList;

public interface VendingMachine<T extends Product> {

    void initProducts(ArrayList<T> someProducts);

    ArrayList<T> getProducts();

    String getProduct(String name);

    String getProduct(String name, int volume);

    String getProduct(String name, int volume, int temp);
}
