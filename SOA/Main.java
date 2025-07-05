package SOA;

import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> db = new HashMap<>();
        ServiceBus bus = new ServiceBus();

        UserService userService = new UserService(db, bus);
        ShoppingService shopingService = new ShoppingService(db, bus);

        userService.createUser("Maria");
        shopingService.createOrder("productX", db.get("Maria").get(0));
    }    
}
