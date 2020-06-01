package Project2020;

public class Pen extends Item{
	private String color;
	private double tipSize;

    public Pen(String name, String description, int id,	int stock , double price,String color, double tipSize) {
    	super(name,description,id,stock,price);
    	this.color =color;
    	this.tipSize=tipSize;
    }
    public String getDetails() {
    	return getBasicInfo()+ '\n'+ "It has a tip size of : "+ this.tipSize+" mm"+ '\n' +"It is of color: "+this.color;
    }
    
    public  String getcategory()
    {
    	return "Pen";
    }
}
