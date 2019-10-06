package pattern.samples.composite;

public class Circle implements Shape {

	private String circleName;

	public Circle(String shapeName) {
		this.circleName = shapeName;
	}

	@Override
	public String getShapeName() {
		return circleName;
	}

	@Override
	public void draw() {
		System.out.println("Drawing circle " + getShapeName());
	}

}
