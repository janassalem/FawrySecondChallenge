import java.io.*;
import java.util.*;

public class Inventory implements BookService {
    private static Inventory instance;
    private Map<String, Book> books;

    private Inventory() {
        books = new HashMap<>();
    }

    public static Inventory getInstance() {
        if (instance == null) instance = new Inventory();
        return instance;
    }

    @Override
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Quantum book store - Book added: " + book);
    }

    @Override
    public List<Book> removeOutdatedBooks(int currentYear, int threshold) {
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Book> entry = it.next();
            if (entry.getValue().isOutdated(currentYear, threshold)) {
                removed.add(entry.getValue());
                it.remove();
            }
        }
        return removed;
    }

    @Override
    public double buyBook(String isbn, int quantity, String email, String address) {
        if (!books.containsKey(isbn)) throw new IllegalArgumentException("Quantum book store - Book not found.");
        return books.get(isbn).buy(quantity, email, address);
    }

    @Override
    public void listBooks() {
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }

    @Override
    public void saveInventory(String filename) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(books);
        out.close();
    }

    @Override
    public void loadInventory(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        books = (Map<String, Book>) in.readObject();
        in.close();
    }
}
