package pattern.samples.decorator;

public class HoneyCoffee extends SpecialCoffee {
	private int honeyPortion;

	public HoneyCoffee(Coffee coffee) {
		super(coffee);
		this.honeyPortion = 1;
	}

	public int getHoneyPortion() {
		return honeyPortion;
	}

	@Override
	public void prepare() {
		super.prepare();
		System.out.println("Add " + getHoneyPortion() + " portion of honey");
	}
}
