public class BookFactory {
    public static Book createPaperBook(String isbn, String title, String author, int year, double price, int stock) {
        return new PaperBook(isbn, title, author, year, price, stock);
    }

    public static Book createEBook(String isbn, String title, String author, int year, double price, String fileType) {
        return new EBook(isbn, title, author, year, price, fileType);
    }

    public static Book createDemoBook(String isbn, String title, String author, int year) {
        return new DemoBook(isbn, title, author, year);
    }
}
