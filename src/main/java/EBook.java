public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, String author, int year, double price, String fileType) {
        super(isbn, title, author, year, price);
        this.fileType = fileType;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        Notifier mailer = new MailService();
        mailer.send(email);
        return quantity * price;
    }
}
