package Project2020;

public class Pencil extends Item{
	private String type="";
	private double tipSize;

    public Pencil(String name, String description, int id,	int stock , double price,double tipSize,String type) {
    	super(name,description,id,stock,price);
    	

    	this.type=type;
    	this.tipSize=tipSize;
    }
    
    public String getDetails() {
    	return getBasicInfo()+ '\n'+ "It has a tip size of : "+ this.tipSize+" mm"+ '\n' +"It is of type: "+this.type;
    }
    
    public  String getcategory()
    {
    	return "Pencil";
    }
}
