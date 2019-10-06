package pattern.samples.decorator;

public class CaffeeLatte extends SpecialCoffee {

	private int milkPortion;

	public CaffeeLatte(Coffee coffee) {
		super(coffee);
		milkPortion = 1;
	}

	public int getMilkPortion() {
		return milkPortion;
	}

	@Override
	public void prepare() {
		super.prepare();
		System.out.println("Adding " + getMilkPortion() + " portion of milk");
	}
}
