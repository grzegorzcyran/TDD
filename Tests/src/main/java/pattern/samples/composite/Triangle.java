package pattern.samples.composite;

public class Triangle implements Shape {

	private String triangleName;

	public Triangle(String shapeName) {
		this.triangleName = shapeName;
	}

	@Override
	public String getShapeName() {
		return triangleName;
	}

	@Override
	public void draw() {
		System.out.println("Drawing triangle " + getShapeName());
	}
}
