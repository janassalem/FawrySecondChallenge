public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if (stock < quantity) throw new IllegalArgumentException("Quantum book store - Not enough stock.");
        stock -= quantity;
        Notifier shipper = new ShippingService();
        shipper.send(address);
        return quantity * price;
    }

    public int getStock() { return stock; }
}
