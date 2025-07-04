import java.util.UUID;

public abstract class BaseMicroservice implements Microservice {
    protected Server server;
    protected String name;
    protected String id;

    public BaseMicroservice(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }


    @Override
    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public void sendMessage(String serverId, String serviceId, String message) {
        if (this.server != null) {
            this.server.sendMessageToOtherServer(this.server.getId(), serverId, this.name, serviceId, message);
        }
    }
}
