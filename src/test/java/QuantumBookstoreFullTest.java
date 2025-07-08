import java.util.*;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        BookService store = Inventory.getInstance();

        Book PBookExample = BookFactory.createPaperBook("AICSIT20", "PaperBook Example Test", "PaperBook Author", 2008, 45.0, 10);
        Book EBookExample = BookFactory.createEBook("ISBN002", "EBook Example Test", "Author Example EB", 2018, 30.0, "PDF");
        Book DemoBookExample = BookFactory.createDemoBook("12345", "DemoBook Example Test", "Author Example DB", 2010);

        store.addBook(PBookExample);
        store.addBook(EBookExample);
        store.addBook(DemoBookExample);

        store.listBooks();

        try {
            double paid = store.buyBook("ISBN001", 2, "user@example.com", "123 St, Cairo");
            System.out.println("Quantum book store - Paid: $" + paid);

            paid = store.buyBook("ISBN002", 1, "reader@example.com", "");
            System.out.println("Quantum book store - Paid: $" + paid);

            store.buyBook("ISBN003", 1, "demo@example.com", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Outdated Books ---");
        List<Book> outdated = store.removeOutdatedBooks(2025, 10);
        outdated.forEach(b -> System.out.println("Quantum book store - Removed: " + b));

        try {
            store.saveInventory("store.dat");
            System.out.println("Quantum book store - Inventory saved.");

            store.loadInventory("store.dat");
            System.out.println("Quantum book store - Inventory loaded.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
