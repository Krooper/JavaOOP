import java.util.ArrayList;
import java.util.Iterator;

public class BevIterator implements Iterator<Product> {

    private int counter;
    private final ArrayList<Product> beverages;

    public BevIterator(VendingMachine VendMachine) {
        this.counter = 0;
        this.beverages = VendMachine.getProducts();
    }

    @Override
    public boolean hasNext() {
        return counter < beverages.size() - 1;
    }

    @Override
    public Product next() {
        if (!hasNext()) {
            return null;
        }
        counter++;
        return beverages.get(counter);
    }
}
