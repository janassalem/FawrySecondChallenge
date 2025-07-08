public class DemoBook extends Book {
    public DemoBook(String isbn, String title, String author, int year) {
        super(isbn, title, author, year, 0.0);
    }

    @Override
    public double buy(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Quantum book store - This book is not for sale.");
    }
}
