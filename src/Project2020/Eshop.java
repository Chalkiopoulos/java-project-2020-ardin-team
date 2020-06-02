package Project2020;

import java.util.Scanner;
import java.util.ArrayList;


public class Eshop {
String name;
Owner owner;
ArrayList <Item> itemsList = new ArrayList <Item>();
ArrayList <Buyer> buyerList = new ArrayList <Buyer>();


public Eshop (Owner owner, String name)
	{
		this.name=name;
		this.owner= owner;
	}

public void addItem() throws ItemAlreadyExistsException
{
	boolean flag=false;
	int itemStock,itemID;
	String itemName,itemDescription;
	double itemPrice;
	int choice;
	Item item=null;
	
	
	Scanner myscan = new Scanner(System.in); // ΔΕΝ ΚΑΤΑΛΑΒΑΙΝΩ ΓΙΑΤΙ ΕΔΩ ΜΟΥ ΛΕΕΙ ΟΤΙ ΔΕΝ ΚΛΕΙΝΕΙ ΤΟ MYSCAN
											 // ΞΕΚΑΘΑΡΑ ΚΛΕΙΝΕΙ ΣΤΗ ΓΡΑΜΜΗ 128
	
	System.out.println("Give the item's name:");
	itemName=myscan.nextLine();
	System.out.println("Give the item's description:");
	itemDescription=myscan.nextLine();
	System.out.println("Give the item's id:");
	itemID=myscan.nextInt();
	System.out.println("Give the item's price:");
	itemPrice=myscan.nextDouble();
	System.out.println("Give the item's starting stock:");
	itemStock=myscan.nextInt();
	
	for (int i=0; i<itemsList.size(); i++)
	{
		if (itemID==itemsList.get(i).getid()||itemName==itemsList.get(i).getname())
		{
			throw new ItemAlreadyExistsException("Item already exists!!");
		}
	}
	
do
{	
	flag=false;
	System.out.println("What type of item do you want to add?"+'\n'+"Press 1 for Pencil"+'\n'+"Press 2 for Pen"+'\n'+"Press 3 for notebook"+'\n'+"Press 4 for paper");
	choice=myscan.nextInt();
	switch(choice)
	{
	case 1:
		{
			
			double tipsize;
			String type;
			
			System.out.println("Give tipsize in mm ");
			tipsize=myscan.nextDouble();
			System.out.println("Give type of pencil(H,B,HB)");
			type=myscan.nextLine();
			do 
				{
					type=myscan.nextLine();
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
			
			System.out.println("Give tipsize in mm ");
			tipsize=myscan.nextDouble();
			System.out.println("Give color of pen");
			color=myscan.nextLine();
			
			item = new Pen (itemName,itemDescription,itemID,itemStock,itemPrice,color,tipsize);
			
			break;
		}
	case 3:
		{
			int numsub;
			
			System.out.println("Give the number of subsections ");
			numsub=myscan.nextInt();
			item=new Notebook(itemName,itemDescription,itemID,itemStock,itemPrice,numsub);
			break;
		}
		
	case 4:
		{
			int weight;
			int pages;
			
			System.out.println("Give the weight in grammars(must be an integer) ");
			weight=myscan.nextInt();
			System.out.println("Give the number of pages ");
			pages=myscan.nextInt();
			
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
	myscan.close();
	itemsList.add(item);
	
}


public void addItem(Item itemTBA) throws ItemAlreadyExistsException // Ιδια μεθοδος αλλα εισάγει item που ηδη υπάρχει
{
	for (int i=0; i<itemsList.size(); i++)
	{
		if (itemTBA.getid()==itemsList.get(i).getid()||itemTBA.getname()==itemsList.get(i).getname())
		{
			throw new ItemAlreadyExistsException("Item already exists!!");
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
		throw new NoSuchIDFoundException("No such ID found! :/");
	}
 }

public void removeitem(Item itemTBR)// item To Be Removed
{
	itemsList.remove(itemTBR);
}

public void addBuyer() throws BuyerAlreadyExistsException
{
	Scanner myscan = new Scanner(System.in);
	
	String buyerName;
	String buyerEmail;
	
	System.out.println("Give the buyer's name:");
	buyerName=myscan.nextLine();
	System.out.println("Give the buyer's E-mail");
	buyerEmail=myscan.nextLine();
	
	myscan.close();
											// ελεγχω αν υπαρχει ηδη ο buyer που παει να δημιουργηθεί
	for (int i=0; i<buyerList.size(); i++)
	{
		if (buyerName==buyerList.get(i).getname()||buyerEmail==buyerList.get(i).getemail())
		{
			throw new BuyerAlreadyExistsException("The Buyer already exists!");
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
		if (buyerTBA.getname()==buyerList.get(i).getname()||buyerTBA.getemail()==buyerList.get(i).getemail())
		{
			throw new BuyerAlreadyExistsException("The Buyer you are trying to add already exists!");
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
	int nstock;
	
	Scanner myscan = new Scanner(System.in);
	System.out.println("Choose the new stock for the item: ");
	nstock=myscan.nextInt();
	itemTBSU.setstock(nstock);
	
	myscan.close();
}

public void showCategories()
{
	boolean showPens=false;
	boolean showPencils=false;
	boolean showNotebooks=false;
	boolean showPaper=false;
	
	for ( int i=0; i<itemsList.size(); i++ )
	{
		if (itemsList.get(i).getcategory()=="Pen") showPens=true;
		if (itemsList.get(i).getcategory()=="Pen") showPencils=true;
		if (itemsList.get(i).getcategory()=="Pen") showPaper=true;
		if (itemsList.get(i).getcategory()=="Pen") showNotebooks=true;
	}
	
	System.out.println('\n'+"The currently available categories are: "+ '\n');
	if (showPens)       System.out.println("Pens");
	if (showPencils)    System.out.println("Pencils");
	if (showNotebooks)  System.out.println("Notebook");
	if (showPaper)      System.out.println("Paper");
	
}

public void showProductsInCategory()
{
	boolean itemsExist=false;
	boolean flag= false;
	String chosencategory;
	int choice;
	Scanner myscan= new Scanner(System.in);
	System.out.println("Choose what category you want to see the products of :"+'\n'+"Press 1 for Pencil"+'\n'+"Press 2 for Pen"+'\n'+"Press 3 for notebook"+'\n'+"Press 4 for paper");
	choice=myscan.nextInt();
	
	
	do
	{	
		flag=false;
		System.out.println("What type of item do you want to add?"+'\n'+"Press 1 for Pencil"+'\n'+"Press 2 for Pen"+'\n'+"Press 3 for notebook"+'\n'+"Press 4 for paper");
		choice=myscan.hashCode();
		switch(choice)
		{
		case 1:
			{
				chosencategory="Pencil";
				break;
			}
			
		case 2:
			{
				chosencategory="Pen";
				break;
			}
		case 3:
			{
				chosencategory="Notebook";
				break;
			}
			
		case 4:
			{
				chosencategory="Paper";
				break;
			}
			
		default:
			{
				chosencategory="NoCategoryHasBeenChosen";
				flag=true;
				System.out.println("You did not enter a valid choice, try again");
			}	
			
		}
		
	}
	while (flag==true);
	myscan.close();
	
	for(int i=0; i<itemsList.size(); i++)
	{
		if (itemsList.get(i).getcategory()==chosencategory)
			System.out.println(itemsList.get(i).getname());
		    itemsExist=true;
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