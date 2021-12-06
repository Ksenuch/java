package L4;

public class Consumer extends Person{
    private Product wantsToBuy;

    public Consumer(String name, Product wantsToBuy) {
        super(name);
        this.wantsToBuy = wantsToBuy;
    }

    public Product getWantsToBuy() {
        return wantsToBuy;
    }
}
