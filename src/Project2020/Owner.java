package Project2020;

public class Owner extends User {
	public Owner(String name ,String email){
		super(name , email);
		this.isAdmin=true;
	}
	
}
