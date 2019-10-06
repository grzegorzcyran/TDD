package pattern.samples.observer;

public class Main {

	public static void main(String[] args) {
		Observer observer = new TopicSubscriber("Sport news follower");

		Subject subject = new Topic();
		subject.register(observer);
		observer.setSubject(subject);

		((Topic) subject).postMessage("Messi goes to Real");
		subject.notifyObservers();
		//observer.update();
	}

}
