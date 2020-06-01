package Project2020;

public abstract class User {
	private String name,email;	
	protected boolean isAdmin = false;
	
	public User(String name, String email) {
		this.name=name;
		this.email=email;
		
	}
		
	public String getname()
	{
		return this.name;
	}
	
	public String getemail()
	{
		return this.email;
	}

}
