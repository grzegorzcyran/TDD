package pattern.samples.decorator;

public abstract class SpecialCoffee implements Coffee{
	protected Coffee coffee;

	public SpecialCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public void prepare() {
		this.coffee.prepare();
	}
}
