public class PaymentService extends BaseMicroservice {
    public PaymentService() {
        super("PaymentService");
    }

    @Override
    public void handleRequest(String fromService, String fromServiceId, String message) {
        System.out.println(this.name + "[id:" + this.getId() + "] received message from " + fromService + "[id:"+ fromServiceId + "] : " + message + ".");
        if (message.equals("process_payment")) {
            System.out.println("Payment processed.");
        }
    }
}
