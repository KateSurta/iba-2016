import java.util.ArrayList;

public interface My_PublisherInterface {
	
	ArrayList<My_PublisherActionListener> getListeners();

    void addListener(My_PublisherActionListener listener);

    public void removeListener(My_PublisherActionListener listener);

    public void removeAllListeners();   

    public void notifySubscribers(String message);
}
