import java.util.ArrayList;

public class Stock {
    private String name;
    private int count;
    private double price;
    private ArrayList<String> subscribers;

    public Stock(String name, int count, double price) {
        this.name = name;
        this.count = count;
        this.price = price;
        subscribers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getSubscribers() {
        return subscribers;
    }
}
