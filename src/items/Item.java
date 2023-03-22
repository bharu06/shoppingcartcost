package items;

public class Item implements IItem {

    double price;
    Category category;
    String name;

    public Item(String name, Category category, double price) {
        this.price = price;
        this.category = category;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "(" + price + ")";
    }
}
