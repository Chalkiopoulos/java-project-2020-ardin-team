package Project2020;

public class NoSuchIDFoundException extends Exception {
	
	public NoSuchIDFoundException() {
		super ("There is no item with the given ID");
	}

}