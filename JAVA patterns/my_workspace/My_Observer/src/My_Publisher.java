import java.util.ArrayList;

public class My_Publisher implements My_PublisherInterface{
    
    private ArrayList<My_PublisherActionListener> listeners = new ArrayList<>();

    
    public ArrayList<My_PublisherActionListener> getListeners() {
        return listeners;
    }
    
    
    public void addListener(My_PublisherActionListener listener){
        listeners.add(listener);
    }
    
   
    public void removeListener(My_PublisherActionListener listener){
        listeners.remove(listener);
    }
    
    
    public void removeAllListeners(){
        listeners.clear();
    }
    
   
    public void notifySubscribers(String message){
        for (My_PublisherActionListener actionListener : listeners) {
            actionListener.doAction(message);
        }
    }

    
    public void createNewMessage(String message){
        System.out.println("Publisher printed message "+message);
        notifySubscribers(message);
    }

}
