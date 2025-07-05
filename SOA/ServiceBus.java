package SOA;
import java.util.ArrayList;
import java.util.HashMap;

public class ServiceBus{
    private final HashMap<String, ArrayList<Service>> subscribers = new HashMap<>(); 

    public void subscribe(String topic, Service service){
        ArrayList<Service> subscribersList = subscribers.get(topic);
        if (!subscribersList.contains(service)) {
            subscribersList.add(service);
        }
        subscribers.put(topic, subscribersList);
        System.out.println(service.getName() + " subiscribed to topic: " + topic + ".");
    }

    public void publishMensage(Message message){
       ArrayList<Service> subscribersList = subscribers.get(message.getTopic());
       for(Service service : subscribersList){
            service.handleRequest(message.getTopic(), message.getPayload(), message.getAuthor());
       }
       System.out.println(""); 
    }

}
