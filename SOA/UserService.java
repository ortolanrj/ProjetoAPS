package SOA;
import java.util.HashMap;
import java.util.ArrayList;

public class UserService extends Service {

    public UserService(HashMap<String, ArrayList<String>> db, ServiceBus bus){
        super("UserService", db, bus);
        bus.subscribe("order_created", this);
    }

    @Override
    public void handleRequest(String topic, String payload, String author){
       if (topic.equals("order_created")) {
            String[] payload_parts = payload.split("\\|");

            ArrayList<String> orderList = getDB().get(payload_parts[0]);
            orderList.add(payload_parts[1]);

            getDB().put(payload_parts[0], orderList);

            System.out.println("Order added to user history.");
       }
    }
    
}
