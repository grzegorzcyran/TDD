package pattern.samples.composite;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {

	private List<Shape> shapes;

	private String drawingName;

	public Drawing(String shapeName) {
		this.shapes = new ArrayList<>();
		this.drawingName = shapeName;
	}

	@Override
	public String getShapeName() {
		return drawingName;
	}

	@Override
	public void draw() {
		System.out.println("Drawing " + getShapeName() + " and it's subshapes:");
		for(Shape shape : shapes) {
			shape.draw();
		}
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public void removeShape(Shape shape) {
		shapes.remove(shape);
	}

	public void clear(){
		System.out.println("Clearing all the shapes.");
		shapes.clear();
	}
}
