package Project2020;

public class NotEnoughStockException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NotEnoughStockException(String msg) {
		super (msg);
	}
}
