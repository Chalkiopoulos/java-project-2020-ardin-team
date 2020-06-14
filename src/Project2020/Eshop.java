package Project2020;


import java.util.ArrayList;


public class Eshop {
private String name;
private Owner owner;
ArrayList <Item> itemsList = new ArrayList <Item>();
ArrayList <Buyer> buyerList = new ArrayList <Buyer>();


public Eshop (Owner owner, String name)
	{
		this.name=name;
		this.owner= owner;
	}

public Owner getowner()
{
	return this.owner;
}

public String getname()
{
	return this.name;
}


public void addItem() throws ItemAlreadyExistsException
{
	boolean flag=false;
	int itemStock,itemID;
	String itemName,itemDescription;
	double itemPrice;
	int choice;
	Item item=null;
	
	
	itemName= Str.input("Give the item's name:");
	itemDescription=Str.input("Give the item's Description:");
	itemID= (int)Str.longOf("Give the item's id:");
	itemPrice= Str.doubleOf("Give the item's price:");
	itemStock=(int)Str.longOf("Give the item's starting stock:");
	
	for (int i=0; i<itemsList.size(); i++)
	{
		if (itemID==itemsList.get(i).getid()||itemName.equals(itemsList.get(i).getname()))
		{
			throw new ItemAlreadyExistsException();
		}
	}
	
do
{	
	flag=false;
	choice=Str.inputInt("What type of item do you want to add?"+'\n'+"Press 1 for Pencil"+'\n'+"Press 2 for Pen"+'\n'+"Press 3 for notebook"+'\n'+"Press 4 for paper", 1, 4);
	switch(choice)
	{
	case 1:
		{
			
			double tipsize;
			String type;
		
			tipsize= Str.doubleOf("Give tipsize in mm ");
			System.out.println("Give type of pencil(H,B,HB)");
			do 
				{
				type=Str.input("Give type of pencil(H,B,HB)");
					if(type!="H"&&type!="B"&&type!="HB")
						System.out.println("This is not a valid type give another type");
				}
			while(type!="H"&&type!="B"&&type!="HB");
			
			item=new Pencil(itemName,itemDescription,itemID,itemStock,itemPrice,tipsize,type);
			break;
		}
		
	case 2:
		{
			String color;
			double tipsize;
			
			tipsize= Str.doubleOf("Give tipsize in mm ");
			color=Str.input("Give color of pen");
			
			item = new Pen (itemName,itemDescription,itemID,itemStock,itemPrice,color,tipsize);
			
			break;
		}
	case 3:
		{
			int numsub;
			
			numsub=(int)Str.longOf("Give the number of subsections ");
			item=new Notebook(itemName,itemDescription,itemID,itemStock,itemPrice,numsub);
			break;
		}
		
	case 4:
		{
			int weight;
			int pages;
				weight=(int)Str.longOf("Give the weight in grammars ");
				pages=(int)Str.longOf("Give the number of pages ");
		item=new Paper(itemName,itemDescription,itemID,itemStock,itemPrice,weight,pages);
		break;
		}
		
	default:
		{
			flag=true;
			System.out.println("You did not enter a valid choice, try again");
		}	
	}
	
}
	while (flag==true);
	itemsList.add(item);
	
}


public void addItem(Item itemTBA) throws ItemAlreadyExistsException // Ιδια μεθοδος αλλα εισάγει item που ηδη υπάρχει
{
	for (int i=0; i<itemsList.size(); i++)
	{
		if (itemTBA.getid()==itemsList.get(i).getid()||itemTBA.getname().equals(itemsList.get(i).getname()))
		{
			throw new ItemAlreadyExistsException();
		}
	}
	
	itemsList.add(itemTBA);
}



public Item getitembyid(int id) throws NoSuchIDFoundException
 {
	int index=0;
	boolean flag=false;
	
	if (itemsList.isEmpty())
	{
		return null;
	}
	
	for ( int i=0; i<itemsList.size(); i++ )
	   {
		if(id==itemsList.get(i).getid()) 
			{
			flag=true;
			index=i;
			break;
			}
	   }
	

	
	if (flag)
		{return  itemsList.get(index);}
	 
	else
	{
		throw new NoSuchIDFoundException();
	}
 }

public void removeitem(Item itemTBR)// item To Be Removed
{
	itemsList.remove(itemTBR);
}

public void addBuyer() throws BuyerAlreadyExistsException
{
	
	String buyerName=Str.input("Give the buyer's name:");
	String buyerEmail=Str.input("Give the buyer's E-mail ");
	
																						// ελεγχω αν υπαρχει ηδη ο buyer που παει να δημιουργηθεί
	for (int i=0; i<buyerList.size(); i++)  	// με το OR ( || ) ελεγχω αν τα στοιχεια ανηκουν στον owner 
	{
		if (buyerName.equals(buyerList.get(i).getname())||buyerEmail.equals(buyerList.get(i).getemail()) || (buyerName.equals(owner.getname())||buyerEmail.equals(owner.getemail())) )
		{
			throw new BuyerAlreadyExistsException();
		}
	}
	
	Buyer buyerTBA=new Buyer(buyerName,buyerEmail);//Buyer To Be Added
	
	buyerList.add(buyerTBA);
}


public void addBuyer(Buyer buyerTBA) throws BuyerAlreadyExistsException // ιδια μεθοδος αλλά βαζει μέσα buyer 
																		// που ηδη υπάρχει
{
						// ελεγχω αν υπαρχει ηδη ο buyer που παει να δημιουργηθεί
	for (int i=0; i<buyerList.size(); i++)
	{
		if (buyerTBA.getname().equals(buyerList.get(i).getname())||buyerTBA.getemail().equals(buyerList.get(i).getemail()))
		{
			throw new BuyerAlreadyExistsException();
		}
	}
	
	
	
	buyerList.add(buyerTBA);
}


void removebuyer(Buyer buyerTBR)//buyer To Be Removed
{
	buyerList.remove(buyerTBR);
}

public void updateItemStock(Item itemTBSU)//item To Be Stock Updated
{
	int nstock= Str.inputInt("Choose the new stock for the item: ",0,90000);
	itemTBSU.setstock(nstock);
	
}

public void updateItemPrice(Item itemTBSU)//item To Be Price Updated
{
	double nprice;
	
	 nprice= (double)Str.inputInt("Choose the new price for the item: ", 0, 90000);
	
	itemTBSU.setprice(nprice);
}

public void showCategories()
{
	boolean showPens=false;
	boolean showPencils=false;
	boolean showNotebooks=false;
	boolean showPaper=false;
	
	for ( int i=0; i<itemsList.size(); i++ )
	{
		if (itemsList.get(i).getcategory().equals("pen")) showPens=true;
		if (itemsList.get(i).getcategory().equals("pencil")) showPencils=true;
		if (itemsList.get(i).getcategory().equals("paper")) showPaper=true;
		if (itemsList.get(i).getcategory().equals("notebook")) showNotebooks=true;
	}
	
	System.out.println('\n'+"The currently available categories are: "+ '\n');
	if (showPens)       System.out.println("pen");
	if (showPencils)    System.out.println("pencil");
	if (showNotebooks)  System.out.println("notebook");
	if (showPaper)      System.out.println("paper");
	if (!(showPens||showPencils||showNotebooks||showPaper)) {System.out.println("There are no available categories");}
}

public void showProductsInCategory(String chosenCategory)
{
	boolean itemsExist=false;
	
	for(int i=0; i<itemsList.size(); i++)
	{
		if (itemsList.get(i).getcategory().equals(chosenCategory)) {
			System.out.println(itemsList.get(i).getname()+" "+itemsList.get(i).getid() );
		    itemsExist=true;
		}
	}
  
	if (!itemsExist) {System.out.println("The chosen category has no items");}
	
}

public void showProduct(Item itemTBS)//To Be Shown 
    {
		System.out.println(itemTBS.getDetails());
	}

public void checkStatus()
{
		if (buyerList.isEmpty())
			{System.out.println("There are currently no available buyers");}
		
		else
	{
		for (int i=0; i<buyerList.size(); i++)
		{
			System.out.println(i+" Name: "+ buyerList.get(i).getname()+'\t'+"Points: "+buyerList.get(i).getbonus()+'\t'+"Category: "+ buyerList.get(i).getBuyerCategory());
		}
	}	
}

}