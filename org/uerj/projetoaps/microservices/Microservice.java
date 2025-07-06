package org.uerj.projetoaps.microservices;

import java.util.UUID;

public abstract class Microservice {
    protected Server server;
    protected String name;
    protected String id;

    public Microservice(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }


    public void setServer(Server server) {
        this.server = server;
    }

    public void sendMessage(String serverId, String serviceId, String message) {
        if (this.server != null) {
            this.server.sendMessage(this.server.getId(), serverId, this.name, this.id, serviceId, message);
        }
    }

    public void handleRequest(String from, String serviceId, String message) {}
}
