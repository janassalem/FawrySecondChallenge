public class MailService implements Notifier {
    @Override
    public void send(String email) {
        System.out.println("Quantum book store - Sending ebook to " + email);
    }
}
