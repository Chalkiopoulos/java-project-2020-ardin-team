package Project2020;

public class Paper extends Item{
	private int weight; 
	private int pages;

    public Paper(String name, String description, int id,	int stock , double price,int weight,int pages) {
    	super(name,description,id,stock,price);
    	this.weight =weight;
    	this.pages=pages;
    }
    public String getDetails() {
        
        return getBasicInfo()+ '\n'+ "the weight is: "+ this.weight+" grammars"+ '\n' +"there are "+this.pages+" pages" ;
    }
    
    public  String getcategory()
    {
    	return "paper";
    }
}