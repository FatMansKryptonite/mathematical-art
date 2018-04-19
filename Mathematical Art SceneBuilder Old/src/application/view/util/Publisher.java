package application.view.util;
import java.util.ArrayList;

public interface Publisher {
	
	public ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	public default void addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
	}
	
	public default boolean removeSubscriber(Subscriber subscriber) {
		return subscribers.remove(subscriber);
	}

	public default void updateSubscribers() {
		for(Subscriber subscriber : subscribers) {
			subscriber.update();
		}
	}
	
}
