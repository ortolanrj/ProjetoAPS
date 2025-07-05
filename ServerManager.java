import java.util.ArrayList;
import java.util.List;

public class ServerManager {
    private final List<Server> servers = new ArrayList<>();

    public ServerManager(){}

    public void addServer(Server server) {
        server.setServerManager(this);
        servers.add(server);
    }

    public boolean deployService(Microservice service) {
        for (Server server : servers) {
            if (server.addService(service)) {
                service.setServer(server);
                return true;
            }
        }
        System.out.println("All servers are full. Could not deploy " + service.getName() + " [id:" + service.getId() + "]");
        return false;
    }

     public void routeMessage(String fromServerId, String toServerId, String fromService, String fromServiceId, String toService, String message) {
        Server targetServer = servers.stream()
                .filter(s -> s.getId().equals(toServerId))
                .findFirst()
                .orElse(null);

        if (targetServer != null) {
            targetServer.receiveMessage(fromService, fromServiceId, toService, message);
        } else {
            System.out.println("Target server " + toServerId + " not found.");
        }
    }
}
