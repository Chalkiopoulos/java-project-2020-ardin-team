package Project2020;

public class BuyerAlreadyExistsException extends Exception{

	public BuyerAlreadyExistsException() {
		super ("The name or email you entered are already taken");
	}

}