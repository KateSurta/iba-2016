
public class Subscriber2 implements My_PublisherActionListener {

    
    public void doAction(String message) {
        System.out.println(message + " from "+ this.getClass().getName());
    }

}
