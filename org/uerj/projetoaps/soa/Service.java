package org.uerj.projetoaps.soa;
import java.util.HashMap;
import java.util.ArrayList;

public abstract class Service {
   private final String name; 
   
   private final HashMap<String, ArrayList<String>> db;
   private final ServiceBus bus;

   public Service(String name, HashMap<String, ArrayList<String>> db, ServiceBus bus){
        this.name = name;
        this.db = db;
        this.bus = bus;
   }

   public String getName(){
        return this.name;
   }

   public HashMap<String, ArrayList<String>> getDB(){
     return this.db;
   }

   public ServiceBus getBus(){
     return this.bus;
   }

   public void handleRequest(String topic, String payload, String author){}
}
