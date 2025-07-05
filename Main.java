
public class Main {
    public static void main(String[] args) {
        ServerManager manager = new ServerManager();

        Server server1 = new Server(3);
        Server server2 = new Server(4);
        Server server3 = new Server(5);

        manager.addServer(server1);
        manager.addServer(server2);
        manager.addServer(server3);

        Microservice checkout1 = new CheckoutService();
        Microservice payment1 = new PaymentService();
        Microservice inventory1 = new InventoryService();
        Microservice checkout2 = new CheckoutService();
        Microservice payment2 = new PaymentService();
        Microservice inventory2 = new InventoryService();
        Microservice checkout3 = new CheckoutService();
        Microservice payment3 = new PaymentService();
        Microservice inventory3 = new InventoryService();
        
        manager.deployService(checkout1);
        manager.deployService(payment1);
        manager.deployService(inventory1);
        manager.deployService(checkout2);
        manager.deployService(payment2);
        manager.deployService(inventory2);
        manager.deployService(checkout3);
        manager.deployService(payment3);
        manager.deployService(inventory3);

        // Simular um fluxo de comunicação
        checkout1.sendMessage(server1.getId(), inventory1.getId(), "check_inventory|productX");
        checkout2.sendMessage(server2.getId(), inventory2.getId(), "check_inventory|productY");
        checkout3.sendMessage(server3.getId(), inventory3.getId(), "check_inventory|productY");

        inventory1.sendMessage(server1.getId(), payment1.getId(), "process_payment");
        inventory2.sendMessage(server2.getId(), payment2.getId(), "process_payment");
        inventory3.sendMessage(server3.getId(), payment3.getId(), "process_payment");
    }
}