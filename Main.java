import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Server> servers = new ArrayList<>();

        Server server1 = new Server(3);
        Server server2 = new Server(3);
        Server server3 = new Server(1);

        servers.addAll(List.of(server1, server2, server3));

        Microservice checkout1 = new CheckoutService();
        Microservice payment1 = new PaymentService();
        Microservice checkout2 = new CheckoutService();
        Microservice payment2 = new PaymentService();
        Microservice checkout3 = new CheckoutService();
        Microservice payment3 = new PaymentService();
        
        deployService(servers, checkout1);
        deployService(servers, payment1);
        deployService(servers, checkout2);
        deployService(servers, payment2);
        deployService(servers, checkout3);
        deployService(servers, payment3);

        // Simular um fluxo de comunicação
        checkout1.sendMessage(server1.getId(), payment1.getId(), "process_payment");
        checkout2.sendMessage(server2.getId(), payment2.getId(), "process_payment");
        checkout3.sendMessage(server2.getId(), payment3.getId(), "process_payment");
    }


    public static boolean deployService(List<Server> servers, Microservice service) {
        for (Server server : servers) {
            if (server.addService(service)) {
                return true;
            }
        }
        System.out.println("All servers are full. Could not deploy " + service.getName());
        return false;
    }

}