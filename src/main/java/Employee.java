import java.io.IOException;
import java.util.ArrayList;

public class Employee extends Person{
    public static int money = 0;
    public static ArrayList<Product> products = new ArrayList<Product>();

    public Employee(String name) {
        super(name);
    }

    public boolean Serve(Consumer c) {

        int index = 0;

        for (Product p : products) {

            if (p.getName() == c.getWantsToBuy().getName() && p.getPrice() <= c.getWantsToBuy().getPrice()) {
                money += c.getWantsToBuy().getPrice();
                products.remove(index);

                return true;
            }
            index++;
        }

        return false;
    }

    public static void Display() {

        System.out.print("Заработано: " + money);

        System.out.println("\nСейчас на складе: ");

        for (Product p : products)
            System.out.println(p.getName() + " за " + p.getPrice());
    }

    public static void makesale(int percent) {
        for (Product p : products)
            p.setPrice(p.getPrice() - (p.getPrice() / 100 * percent));
    }
}
