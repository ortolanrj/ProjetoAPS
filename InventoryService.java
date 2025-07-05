import java.util.HashMap;

public class InventoryService extends BaseMicroservice{
    private final HashMap<String, Integer> dbInventory = new HashMap<>();

    public InventoryService() {
        super("InventoryService");
        dbInventory.put("productX", 2);
        dbInventory.put("productY", 12);
    }

    @Override
    public void handleRequest(String fromService, String fromServiceId, String message) {
        System.out.println(this.name + "[id:" + this.getId() + "] received message from " + fromService + "[id:"+ fromServiceId + "] : " + message + ".");
        String[] message_parts = message.split("\\|");
        if (message_parts[0].equals("check_inventory")) {
            System.out.println("Inventory checked.");
        }
    }
}
