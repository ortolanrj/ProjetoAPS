package org.uerj.projetoaps.microservices;

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
            // System.out.println("Server[id:" + this.id + "] at full capacity. Cannot add " + microservice.getName() + "[id:" + microservice.getId() + "].");
            return false;
        }

        microservice.setServer(this);
        services.put(microservice.getId(), microservice);
        System.out.println("Service " + microservice.getName() + "[id:" + microservice.getId() + "] added to server[id:" + this.id + "].");
        return true;
    }

    public void receiveMessage(String fromService, String fromServiceId, String toServiceId, String message) {
        Microservice service = services.get(toServiceId);
        if (service != null) {
            service.handleRequest(fromService, fromServiceId, message);
        } else {
            System.out.println("Service " + toServiceId + " not found on Server " + this.id);
        }
    }

    public void sendMessage(String fromServerId, String toServerId, String fromService, String fromServiceId, String toServiceId, String message) {
        if (serverManager != null) {
            serverManager.routeMessage(fromServerId, toServerId, fromService, fromServiceId, toServiceId, message);
        }
    }

    public String getId() {
        return this.id;
    }
}
