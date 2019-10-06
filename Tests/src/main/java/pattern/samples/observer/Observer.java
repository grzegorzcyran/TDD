package pattern.samples.observer;

public interface Observer {
	//method to update observer, used by subject
	public void update();

	//set subject to observe
	public void setSubject(Subject subject);
}
