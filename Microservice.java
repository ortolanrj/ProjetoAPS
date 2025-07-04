public interface Microservice {
    String getId();
    String getName();
    void setServer(Server server);
    void handleRequest(String from, String message);
    void sendMessage(String serverId, String serviceId, String message);
}