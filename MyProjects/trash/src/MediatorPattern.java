import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {
    public static void main(String []args){
        ChatBot chat = new ChatBot();
        Users user = new Users(chat,"Alexey");
        Users user1 = new Users(chat, "Nikolay");
        user.sendMessage("Nikolay","ahahah privet");
    }
}

abstract class Clients{
    abstract void sendMessage(String name,String message);
    abstract void getMessage(String from,String message);
    abstract String getName();
}

class Users extends Clients{
    private ChatBot chat;
    private String name;
    public Users(ChatBot c, String name){
        this.chat = c;
        this.name = name;
        c.addClient(this);
    }

    @Override
    void sendMessage(String name, String message) {
        chat.sendMessage(this.name,name,message);
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    void getMessage(String from,String message) {
        System.out.println(this.name + ". You got message from " + from + '\n' + "Text: " + message);
    }
}


class ChatBot{
    List<Clients> clients;
    public ChatBot(){
        clients = new ArrayList<>();
    }
    public void addClient(Clients client){
        if(clients != null)
            clients.add(client);
    }
    public void removeClient(Clients client){
        for(Clients c : clients){
            if(c == client)
                clients.remove(c);
        }
    }
    public void sendMessage(String from, String to, String message){
        for(Clients c : clients){
            if(c.getName().equals(to)){
                c.getMessage(from,message);
            }
        }
    }
}