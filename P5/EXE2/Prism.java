

class Prism extends Rectangle implements Cloneable {
	private double height;
	
	public Prism(Double x, Double y, Double l, Double w, Double h, String  name, Colour colour)
	{
		super(x, y, l, w, name, colour);
		height = h;
	}


	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void  set_height(Double h)
	{
		height = h;
	}
	
	public Double  height()
	{
		return height;
	}
	
	public Double  area()
	{
		return  2 * (length * width) + 2 * (height * length) + 2 * (height * width); 
	}
	
	public Double  perimeter()
	{
		return  width  * 2 + length * 2;
	}
	
	public Double  volume()
	{
		return  width  * length * height;
	}
	
	
	public String toString()
	{
		String s = super.toString()+ "\nHeight: " + height;
		return s;
	}

	@Override
	public void shrink(double n) throws SizeFactorException {

		if(n < LIMIT) throw new SizeFactorException();

		height = height / n;
		length = length / n;
		width = width / n;
	}

	@Override
	public void enlarge(double n) throws SizeFactorException {

		if(n < LIMIT) throw new SizeFactorException();

		height = height * n;
		length = length * n;
		width = width * n;

	}
}