import java.util.HashMap;
import java.util.UUID;

public class Server {

    private HashMap<String, Microservice> services = new HashMap<>();
    private final int capacity;
    private final String id;
    private ServerManager serverManager;

    public Server(int capacity) {
        this.capacity = capacity;
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public void setServerManager(ServerManager manager) {
        this.serverManager = manager;
    }


    public boolean addService(Microservice microservice) {
        if (services.size() >= capacity) {
            System.out.println("Server at full capacity. Cannot add " + microservice.getName());
            return false;
        }

        microservice.setServer(this);
        services.put(microservice.getName(), microservice);
        System.out.println("Service " + microservice.getName() + " added to server.");
        return true;
    }

    public void receiveMessage(String fromService, String toService, String message) {
        Microservice service = services.get(toService);
        if (service != null) {
            service.handleRequest(fromService, message);
        } else {
            System.out.println("Service " + toService + " not found on Server " + id);
        }
    }

    public void sendMessageToOtherServer(String fromServerId, String toServerId, String fromService, String toService, String message) {
        if (serverManager != null) {
            serverManager.routeMessage(this.getId(), toServerId, fromService, toService, message);
        }
    }

    public String getId() {
        return this.id;
    }
}
