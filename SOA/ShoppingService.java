package SOA;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.UUID;

public class ShoppingService extends Service {

    public ShoppingService(HashMap<String, ArrayList<String>> db, ServiceBus bus){
        super("ShopingService", db, bus);
    }

    public void createOrder(String productName, String userId){
        String orderId = UUID.randomUUID().toString().substring(0, 8); 
        Message message = new Message("order_created", userId + "|" + orderId, this.getName());

        System.out.println(this.getName() + " has issued an order for user[" + userId + "].");
        getBus().publishMessage(message);
    }

    @Override
    public void handleRequest(String topic, String payload, String fromService){}
    
}

