import java.io.IOException;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    double buyBook(String isbn, int quantity, String email, String address);
    List<Book> removeOutdatedBooks(int currentYear, int threshold);
    void listBooks();
    void saveInventory(String filename) throws IOException;
    void loadInventory(String filename) throws IOException, ClassNotFoundException;
}
