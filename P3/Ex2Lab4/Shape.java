package Ex1Lab4;

import java.lang.Comparable;

abstract class Shape implements Comparable {
	protected Point origin;
	protected Text name;
	abstract protected Double area();
	abstract protected Double perimeter();
	abstract protected Double volume();
	
	protected Shape(Double x_origin, Double y_origin, String name, Colour colour){
		
		origin = new Point(x_origin,y_origin, colour);
		this.name = new Text(name);
	}


	protected Point  getOrigin()   {
		return origin;
	}
	
	protected String  getName()   {
		return name.getText();
	}
	 
	
	protected  Double distance(   Shape  other){
		return origin.distance(other.origin);
	}
	
	protected Double  distance(Shape a, Shape  b){
		return Point.distance(a.origin, b.origin);
	}
	
	
	protected void  move(Double dx, Double dy){
		origin.setx(origin.getx()+dx);
		origin.sety(origin.gety()+dy);
	}
	
	@Override
	public String toString(){
		String s = "\nShape name: " + name + "\nOrigin: " + origin;
		return s;
	}

	@Override
	public int compareTo(Object o){
		Shape shape = (Shape) o;
		return this.getName().compareTo(shape.getName());
	}
}

