import java.util.concurrent.CountDownLatch;

class Text implements Cloneable, Resizeable
{
	
	private final Double DEFAULT_SIZE = 10.0;
	
    private Colour colour;
    private double fontSize;
    
    private String text;


	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	public Text(String text) {
       this.text = text;
       fontSize = DEFAULT_SIZE;
	}
	
	public Double getFontSize(){
		return fontSize;
	}
	
	public void setColour(String s){
		colour = new Colour(s);
	}
	
	public void setText(String newText){
		text = newText;
	}
	
	public String getText(){
		return text ;
	}
	
	@Override
	public String toString(){
		return (text);
	}


	@Override
	public void shrink(double n) throws SizeFactorException {

		if(n < LIMIT) throw new SizeFactorException();

		fontSize = fontSize / n;
	}

	@Override
	public void enlarge(double n) throws SizeFactorException {

		if(n < LIMIT) throw new SizeFactorException();

		fontSize = fontSize * n;
	}
}
