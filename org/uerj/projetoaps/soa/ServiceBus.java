package org.uerj.projetoaps.soa;
import java.util.ArrayList;
import java.util.HashMap;

public class ServiceBus{
    private final HashMap<String, ArrayList<Service>> subscribers;

    public ServiceBus(){
        this.subscribers = new HashMap<>();
    }

    public void subscribe(String topic, Service service){
        ArrayList<Service> subscribersList = subscribers.getOrDefault(topic, new ArrayList<Service>());
        if (!subscribersList.contains(service)) {
            subscribersList.add(service);
        }
        subscribers.put(topic, subscribersList);
        System.out.println(service.getName() + " subiscribed to topic: " + topic + ".");
    }

    public void publishMessage(Message message){
       ArrayList<Service> subscribersList = subscribers.get(message.getTopic());
       System.out.println(message.getAuthor() + " has published a message in the topic: " + message.getTopic() + "."); 
       if (subscribersList != null){
            for(Service service : subscribersList){
                service.handleRequest(message.getTopic(), message.getPayload(), message.getAuthor());
            }
       }
    }

}
