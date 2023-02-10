import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface VendingMachine {

    void initProducts(ArrayList<Product> someProducts);

    String getProduct(String name);

    String getProduct(String name, int volume);

    String getProduct(String name, int volume, int temp);
}
