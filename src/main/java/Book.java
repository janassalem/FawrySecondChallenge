import java.io.Serializable;

public abstract class Book implements Buyable, Serializable {
    protected String isbn, title, author;
    protected int publishYear;
    protected double price;

    public Book(String isbn, String title, String author, int publishYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
    }

    public String getIsbn() { return isbn; }
    public int getPublishYear() { return publishYear; }
    public double getPrice() { return price; }

    public boolean isOutdated(int currentYear, int threshold) {
        return currentYear - publishYear > threshold;
    }

    @Override
    public abstract double buy(int quantity, String email, String address);

    @Override
    public String toString() {
        return String.format("Quantum book store - %s (%s) by %s - $%.2f", title, isbn, author, price);
    }
}
