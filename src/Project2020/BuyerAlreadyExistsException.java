package Project2020;

public class BuyerAlreadyExistsException extends Exception{

	public BuyerAlreadyExistsException() {
		super ("This buyer already exists");
	}

}