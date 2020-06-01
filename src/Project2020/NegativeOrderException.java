package Project2020;

public class NegativeOrderException extends Exception {
	
	public NegativeOrderException() {
		super ("You can't place an order with a negative quantity");
	}

}
