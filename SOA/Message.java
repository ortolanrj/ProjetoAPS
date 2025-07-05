package SOA;
public class Message {
   private final String payload; 
   private final String topic;
   private final String author;

   public Message(String topic, String payload, String author){
    this.topic = topic;
    this.payload = payload;
    this.author = author;
   }

   public String getTopic(){
        return topic;
   }

   public String getPayload(){
        return payload;
   }

   public String getAuthor(){
     return author;
   }

}
