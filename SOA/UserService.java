package SOA;
import java.util.HashMap;
import java.util.UUID;


import java.util.ArrayList;

public class UserService extends Service {

    public UserService(HashMap<String, ArrayList<String>> db, ServiceBus bus){
        super("UserService", db, bus);
        bus.subscribe("order_created", this);
    }

    public void createUser(String userName){
        String userId = UUID.randomUUID().toString().substring(0, 8);
        ArrayList<String> list = new ArrayList<>();
        list.add(userId);
        getDB().put(userName, list);

        System.out.println(this.getName() + " has added an user to data base.");

        Message message = new Message("user_created", userId + "|" + userName, this.getName());
        getBus().publishMessage(message);
    }

    @Override
    public void handleRequest(String topic, String payload, String author){
       if (topic.equals("order_created")) {
            String[] payload_parts = payload.split("\\|");

            ArrayList<String> orderList = getDB().getOrDefault(payload_parts[0], new ArrayList<String>());
            orderList.add(payload_parts[1]);

            getDB().put(payload_parts[0], orderList);

            System.out.println(this.getName() + " has added and order to the user data base.");
       }
    }
    
}
