package pattern.samples.observer;

public class TopicSubscriber implements Observer {

	private String name;
	private Subject topic;

	public TopicSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		String message = topic.getUpdate(this).toString();
		if(message == null) {
			System.out.println("No new message on " + name);
		} else {
			System.out.println("New message: "+ message + " on " + name);
		}
	}

	@Override
	public void setSubject(Subject subject) {
		this.topic = subject;
	}
}
