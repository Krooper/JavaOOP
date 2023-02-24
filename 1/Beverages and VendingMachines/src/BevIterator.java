import java.util.ArrayList;
import java.util.Iterator;

public class BevIterator<O extends VendingMachine<T>, T extends Product> implements Iterator<T> {

    private int counter;
    private final ArrayList<T> beverages;

    public BevIterator(O VendMachine) {
        this.counter = 0;
        this.beverages = VendMachine.getProducts();
    }

    @Override
    public boolean hasNext() {
        return counter < beverages.size() - 1;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        counter++;
        return beverages.get(counter);
    }
}
