public class PaymentService extends BaseMicroservice {
    public PaymentService() {
        super("PaymentService");
    }

    @Override
    public void handleRequest(String from, String message) {
        System.out.println(name + " received message from " + from + ": " + message);
        if (message.equals("process_payment")) {
            System.out.println("Payment processed.");
        }
    }
}
