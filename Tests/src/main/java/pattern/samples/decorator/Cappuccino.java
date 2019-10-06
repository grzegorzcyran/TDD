package pattern.samples.decorator;

public class Cappuccino extends SpecialCoffee {

	private String extraCookie;
	private int milkPortion;

	public Cappuccino(Coffee coffee) {
		super(coffee);
		extraCookie = "Add cookie dessert";
		milkPortion = 2;
	}

	public String getExtraCookie() {
		return extraCookie;
	}

	public int getMilkPortion() {
		return milkPortion;
	}

	@Override
	public void prepare() {
		super.prepare();
		System.out.println(getExtraCookie());
		System.out.println("Add " + getMilkPortion() + " portion of milk");
	}
}
