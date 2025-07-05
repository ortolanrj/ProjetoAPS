package SOA;
import java.util.HashMap;
import java.util.ArrayList;

public class ShoppingService extends Service {

    public ShoppingService(HashMap<String, ArrayList<String>> db, ServiceBus bus){
        super("ShopingService", db, bus);
    }

    public void createOrder(){
        
    }

    @Override
    public void handleRequest(String topic, String payload, String fromService){
    }
    
}

