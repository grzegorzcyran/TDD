package pattern.samples.decorator;

public class BasicCoffee implements Coffee{

	@Override
	public void prepare() {
		System.out.println("Basic coffee, just boiling water and coffee");
	}
}
