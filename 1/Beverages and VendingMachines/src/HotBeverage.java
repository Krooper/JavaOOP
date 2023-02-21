public class HotBeverage extends Beverage {
    private final String name;
    private final int price;
    private final int volume;
    private int temp;

    public HotBeverage(String name, int price, int volume, int temp) {
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "HotBeverage{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", temp=" + temp +
                '}';
    }
}