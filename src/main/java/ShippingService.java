public class ShippingService implements Notifier {
    @Override
    public void send(String address) {
        System.out.println("Quantum book store - Shipping to " + address);
    }
}
