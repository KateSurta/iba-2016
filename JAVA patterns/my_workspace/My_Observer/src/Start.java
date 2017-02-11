
public class Start {
	
	public static void main(String[] args) {
        Subscriber1 subscriber1 = new Subscriber1();
        Subscriber2 subscriber2 = new Subscriber2();

        My_Publisher publisher = new My_Publisher();

        publisher.addListener(subscriber1);
        publisher.addListener(subscriber2);

        publisher.createNewMessage("Message!");
    }
}
