package pattern.samples.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject {
	private List<Observer> observers;
	private String message;
	private boolean changed;

	public Topic() {
		this.observers = new ArrayList<>();
	}

	public void postMessage(String message){
		System.out.println("Message posted: " + message);
		this.message = message;
		this.changed = true;
		notifyObservers();
	}

	@Override
	public void register(Observer observer) {
		if(observer ==null)
			throw new NullPointerException("Null observer");
		if(!observers.contains(observer))
			observers.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		if(observers.contains(observer))
			observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersToNotify = null;
		if(!changed)
			return;
		observersToNotify = new ArrayList<>(observers);
		this.changed = false;
		for(Observer observer : observersToNotify){
			observer.update();
		}
	}

	@Override
	public Object getUpdate(Observer observer) {
		return this.message;
	}
}
