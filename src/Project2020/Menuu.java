package Project2020;

public class Menuu {
	private Eshop eshop;
	//το index χρησιμοποιείται στην Switch και συμβολίζει την κατάσταση του menu
	int index=0;
	Buyer selectedBuyer;
	
	public Menuu (Eshop eshop0) {
		this.eshop=eshop0;
		
		
	}
	public void setIndex(int i)
	{
		index=i;
	}
	public int returnIndex() {return index;};
	
	
	public void login() {
		boolean userFound=false,userIsOwner=false;
		Buyer loginBuyer;
	
		String name=Str.input("Give your Username");
		String email=Str.input("Give your Email");
		

			// Εδω ελεγχω αν αυτό που εβαλε ο χρηστης ειναι ονομα και mail του owner
			if (this.eshop.getowner().getname().equals(name) && this.eshop.getowner().getemail().equals(email))
			{
				userFound=true;
				userIsOwner=true;
				index=1;
			}
				
			if(!userIsOwner) // εδω ελεγχω αν αυτα που εγραψε ο χρηστης ειναι στοιχεια καποιου buyer
			{
				for(int i=0; i<this.eshop.buyerList.size(); i++)
				{
					
					if( (this.eshop.buyerList.get(i).getname().equals(name)) && (this.eshop.buyerList.get(i).getemail().equals(email)) )
					{
						userFound=true;
						loginBuyer=this.eshop.buyerList.get(i);
						index=2;
						selectedBuyer = loginBuyer;
					}
				}
			}
			if(!userFound) {
				
				int num= Str.inputInt("The user has not been found!, press 0 to add a new Buyer, 1 to exit and 2 to restart the login Process", 0, 2);
				
				if (num==0)
				{
					Buyer newBuyer= new Buyer(name,email);
					this.eshop.buyerList.add(newBuyer);
					index=2;
					selectedBuyer =  newBuyer;
				}
				else if (num==1)
				{
					index=-1;//this way the programme is terminated
				}
				else
				{
					index=0;// καλα ετσι κιαλλιως 0 θα ηταν για να μπηκε εδω αλλα κλαιν
				}
			}

			
			
	}

public void buyerMenu()
{
	System.out.println("Hello "+ selectedBuyer.getname());
	System.out.println(" Name: "+ selectedBuyer.getname()+'\t'+" Points: "+selectedBuyer.getbonus()+'\t'+" Category: "+ selectedBuyer.getBuyerCategory());
  System.out.println("press 1 to browse store ");
  System.out.println("press 2 to view cart ");
  System.out.println("press 3 to checkout ");
  System.out.println("press 4 to go back ");
  System.out.println("press 5 to go to the login menu ");
  System.out.println("press 6 to exit programme ");
  
  int choice= Str.inputInt("Type the number of your choice", 1, 6);
  switch(choice){
	
		case 1:
			index=3;
			break;
		case 2:
			index=4;
			break;
		case 3:
			selectedBuyer.getShoppingCart().checkout(selectedBuyer);
		  index=2;
		  break;
		case 4:
			index=0;
			break;
		case 5:
			index=0;
			break;
		case 6:
			index=-1;
			break;
		default:
			index = 2 ;
			break;
	}
}
public void browseStoreMenu()
{
	System.out.println("Welcome to " + this.eshop.getname());
	this.eshop.showCategories();
	String choice = Str.input("Type the name of the category you wish to see (all lowercase) and anything else to go back");
	switch(choice)
	{
	case "pens":
		index=5;
		break;
	case "pencils":
		index=6;
		break;
	case "notebooks":
	index=7;
	break;
	case "paper":
	index=8;
	break;
	
	default:
		index=2;
		break;
	}

}

public void pensMenu() 
{
 int i;// αυτο ειναι to index του selectedbuyer
 
 
 boolean flag=false;
 Item selectedItem=null;
 this.eshop.showProductsInCategory("pens");	

 int choice= Str.inputInt("Type the ID of the item you wish to examine. (press -1 to browse store)", -1,1000000);
 
 if (choice==-1) index=3;
 for(int j=0; j<this.eshop.itemsList.size(); j++)
 {
	 if (choice==this.eshop.itemsList.get(j).getid())
	 {
		 flag=true;
		 try {
			selectedItem=this.eshop.getitembyid(choice);
		} catch (NoSuchIDFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 if (flag)
 {
	 
	 System.out.println(selectedItem.toString());
	 
	 int check = Str.inputInt("Do you wish to make a purchase of this item?(press 0 for yes, 1 for no and 2 to return to the main menu )", 0, 2);
	 if(check==0)
	 {
		 
		 int amount= Str.inputInt("How much of this item do you wish to buy?", 1, selectedItem.getstock());
		 i=this.eshop.buyerList.indexOf(selectedBuyer);
		 this.eshop.buyerList.get(i).placeOrder(selectedItem, amount);
	 }
	 else if(check == 1)
	 {
		 
		 index=5;
	 }
	 else
	 {
		 index=3;
	 }
	 
 }
 else
 {
	 System.out.println("you have chosen a number that does not correspond with an item.");
	 index=5;
 }
 

}

public void pencilsMenu() 
{
 int i;// αυτο ειναι to index του selectedbuyer
 boolean flag=false;
 Item selectedItem=null;
 this.eshop.showProductsInCategory("pencils");	
 int choice = Str.inputInt("Type the ID of the item you wish to examine. (press -1 to browse store)", -1, 1000000);
 if (choice==-1) index=3;
 for(int j=0; j<this.eshop.itemsList.size(); j++)
 {
	 if (choice==this.eshop.itemsList.get(j).getid())
	 {
		 flag=true;
		 try {
			selectedItem=this.eshop.getitembyid(choice);
		} catch (NoSuchIDFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 if (flag)
 {
	 
	 System.out.println(selectedItem.toString());
	 int check = Str.inputInt("Do you wish to make a purchase of this item?(press 0 for yes, 1 for no and 2 to return to the main menu )", 0, 2);
	 if(check==0)
	 {
		 
		 int amount = Str.inputInt("How much of this item do you wish to buy?", 1, selectedItem.getstock());
		 i=this.eshop.buyerList.indexOf(selectedBuyer);
		 this.eshop.buyerList.get(i).placeOrder(selectedItem, amount);
	 }
	 else if(check == 1)
	 {
		 
		 index=6;
	 }
	 else
	 {
		 index=3;
	 }
	 
 }
 else
 {
	 System.out.println("you have chosen a number that does not correspond with an item.");
	 index=6;
 }
 

}	

public void notebooksMenu() 
{
 int i;// αυτο ειναι to index του selectedbuyer
 boolean flag=false;
 Item selectedItem=null;
 this.eshop.showProductsInCategory("notebooks");	
 int choice = Str.inputInt("Type the ID of the item you wish to examine. (press -1 to browse store)", -1, 1000000);
 if (choice==-1) index=3;
 for(int j=0; j<this.eshop.itemsList.size(); j++)
 {
	 if (choice==this.eshop.itemsList.get(j).getid())
	 {
		 flag=true;
		 try {
			selectedItem=this.eshop.getitembyid(choice);
		} catch (NoSuchIDFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 if (flag)
 {
	 
	 System.out.println(selectedItem.toString());
	 int check = Str.inputInt("Do you wish to make a purchase of this item?(press 0 for yes, 1 for no and 2 to return to the main menu )", 0, 2);
	 if(check ==0)
	 {
		 System.out.println("How much of this item do you wish to buy?");
		 int amount = Str.inputInt("How much of this item do you wish to buy?", 1, selectedItem.getstock());
		 i=this.eshop.buyerList.indexOf(selectedBuyer);
		 this.eshop.buyerList.get(i).placeOrder(selectedItem, amount);
	 }
	 else if(check == 1)
	 {
		 
		 index=7;
	 }
	 else
	 {
		 index=3;
	 }
	 
 }
 else
 {
	 System.out.println("you have chosen a number that does not correspond with an item.");
	 index=7;
 }
 

}
public void paperMenu() 
{
 int i;// αυτο ειναι to index του selectedbuyer
 boolean flag=false;
 Item selectedItem=null;
 this.eshop.showProductsInCategory("paper");	
 int choice = Str.inputInt("Type the ID of the item you wish to examine. (press -1 to browse store)", -1, 1000000);
 if (choice==-1) index=3;
 for(int j=0; j<this.eshop.itemsList.size(); j++)
 {
	 if (choice==this.eshop.itemsList.get(j).getid())
	 {
		 flag=true;
		 try {
			selectedItem=this.eshop.getitembyid(choice);
		} catch (NoSuchIDFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 if (flag)
 {
	 
	 System.out.println(selectedItem.toString());
	 System.out.println("Do you wish to make a purchase of this item?(press 0 for yes and 1 for no )");
	 int check = Str.inputInt("Do you wish to make a purchase of this item?(press 0 for yes, 1 for no and 2 to return to the main menu )", 0, 2);
	 if(check==0)
	 {
		 int amount = Str.inputInt("How much of this item do you wish to buy?", 1, selectedItem.getstock());
		 i=this.eshop.buyerList.indexOf(selectedBuyer);
		 this.eshop.buyerList.get(i).placeOrder(selectedItem, amount);
	 }
	 else if(check == 1)
	 {
		 
		 index=8;
	 }
	 else
	 {
		 index=3;
	 }
	 
 }
 else
 {
	 System.out.println("you have chosen a number that does not correspond with an item.");
	 index=8;
 }
 

}

public void viewCartMenu()
{

 if (selectedBuyer.getShoppingCart().orderList.isEmpty())
 {
	 System.out.println("The shopping cart is empty");
	 index=2;
 }
 else 
 { 
	 selectedBuyer.getShoppingCart().showCart(selectedBuyer);
	 int choice = Str.inputInt("Press 1 to choose an order, press 2 to clear the shopping cart, press 3 to checkout(4 to go back)", 1, 4);
	 switch(choice)
	 {
	 case 1:
		 index=9;
		 break;
	 case 2:
		 selectedBuyer.getShoppingCart().clearCart();
		 index=2;
		 break;
	 case 3:
		 selectedBuyer.getShoppingCart().checkout(selectedBuyer);
		 break;
		default:
		 index=4;
		 break;
	 }
	 
	 
 }

}
	
public void viewCartAMenu(){
	int choiceItemOrdered = Str.inputInt("Select the number of the order you want to examine", 0, selectedBuyer.getShoppingCart().orderList.size());
	int choice= Str.inputInt("Press 1 to delete the order , press 2 to change the ordered amount press 3 to go back to viewing cart", 1, 3);
 switch(choice)
 {
 case 1:
	 selectedBuyer.getShoppingCart().removeItemOrdered(choiceItemOrdered);
	 index=4;
	 break;
 case 2:
	 try {
		 System.out.println("What is the new ordered amount?");
		 int newamount=Str.inputInt("What is the new ordered amount?", 0,this.eshop.itemsList.get(choiceItemOrdered).getstock()-1);
		selectedBuyer.getShoppingCart().changeItemOrderedQuantity(choiceItemOrdered, newamount);
	} catch (NotEnoughStockException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 index=4;
	 break;
 case 3:
	 index=4;
	 break;
 default:
	 index=9;
	 break;
	 
 }
 
 


}

public void ownerMenu() {
	
	
	System.out.println("Welcome "+ this.eshop.getowner().getname() + " to your eshop"+ '\n');
	System.out.println("Press 1 to Browse your shop");
	System.out.println("Press 2 to check your clients ");
	System.out.println("Press 3 to restart the login process");
	System.out.println("Press 4 to exit the programme");
	  int choice = Str.inputInt(" ", 1, 4); 
	
	switch(choice) {
	case 1:
		index=10;
		break;
	case 2:
		index=11;
		
		break;
	case 3:
		index=0;
		
		break;
	case 4:
		index=-1;
		
		break;
	default:
		index=1;
		break;
	}

}
public void ownerBrowseStoreMenu() {
	
	this.eshop.showCategories();
	String choice=Str.input("Type the name of the category you wish to see (all lowercase) or anything else to go back");
	switch(choice)
	{
	case "pen":
		index=12;
		break;
	case "pencil":
		index=13;
		break;
	case "notebook":
	index=14;
	break;
	case "paper":
	index=15;
	break;
	
	default:
		index=1;
		break;
	}

}


public void ownerPensMenu() 
{
 boolean flag=false;
 Item selectedItem=null;
 this.eshop.showProductsInCategory("pens");	
 int choice = Str.inputInt("Type the ID of the item you wish to examine. (press -1 to browse store)", -2, 90000000);
 if (choice==-1) index=10;
 else {
 for(int j=0; j<this.eshop.itemsList.size(); j++)
 {
	 if (choice==this.eshop.itemsList.get(j).getid())
	 {
		 flag=true;
		 try {
			selectedItem=this.eshop.getitembyid(choice);
		} catch (NoSuchIDFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 if (flag)
 {
	 
	 System.out.println(selectedItem.toString());
	 int check = Str.inputInt("Do you wish to change the selected item ?(press 0 for yes and 1 for no and 2 to return to the main Menu)", 0, 2);
	 if(check==0)
	 {
		 
		 	this.eshop.updateItemStock(selectedItem);
		 	this.eshop.updateItemPrice(selectedItem);
		  	
	 }
	 	else if(check == 1){
		 index=12;
	 }
	 	else{
	 		index=10;
	 	}
	 
 }
 	else{
 		System.out.println("you have chosen a number that does not correspond with an item.");
 		index=1;
 	}
 }
 
 
}

public void ownerPencilMenu() {
 boolean flag=false;
 Item selectedItem=null;
 this.eshop.showProductsInCategory("pencils");	
 int choice = Str.inputInt("Type the ID of the item you wish to examine. (press -1 to browse store)", -2, 100000);
 
if (choice==-1) index=10;
else {
 for(int j=0; j<this.eshop.itemsList.size(); j++)
 {
	 if (choice==this.eshop.itemsList.get(j).getid())
	 {
		 flag=true;
		 try {
			selectedItem=this.eshop.getitembyid(choice);
		} catch (NoSuchIDFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 if (flag)
 {
	 
	 System.out.println(selectedItem.toString());
	 int check = Str.inputInt("Do you wish to change the selected item ?(press 0 for yes and 1 for no and 2 to return to the main Menu)", 0, 2);
	 if(check==0){
		 
		 	this.eshop.updateItemStock(selectedItem);
		 	this.eshop.updateItemPrice(selectedItem);
		  	
	 }
	 else if(check == 1)
	 {
		 
		 index=13;
	 }
	 else
	 {
		 index=10;
	 }
	 
 }
 	else	{
 		System.out.println("you have chosen a number that does not correspond with an item.");
 		index=1;
 	}
	} 
}


public void ownerNotebooksMenu() {
 boolean flag=false;
 Item selectedItem=null;
 this.eshop.showProductsInCategory("notebooks");	
 int choice = Str.inputInt("Type the ID of the item you wish to examine. (press -1 to browse store)", -2, 100000);
 if (choice==-1) index=10;
 else {
 for(int j=0; j<this.eshop.itemsList.size(); j++)
 {
	 if (choice==this.eshop.itemsList.get(j).getid())
	 {
		 flag=true;
		 try {
			selectedItem=this.eshop.getitembyid(choice);
		} catch (NoSuchIDFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 if (flag)
 {
	 
	 System.out.println(selectedItem.toString());
	 int check = Str.inputInt("Do you wish to change the selected item ?(press 0 for yes and 1 for no and 2 to return to the main Menu)", 0, 2);
	 if(check==0)
	 {
		 
		 	this.eshop.updateItemStock(selectedItem);
		 	this.eshop.updateItemPrice(selectedItem);
		  	
	 }
	 else if(check == 1)
	 {
		 
		 index=14;
	 }
	 else
	 {
		 index=10;
	 }
	 
 }
 else
 {
	 System.out.println("you have chosen a number that does not correspond with an item.");
	 index=1;
 }
 } 
 
}
public void ownerPaperMenu() 
{
 boolean flag=false;
 Item selectedItem=null;
 this.eshop.showProductsInCategory("paper");	
 int choice = Str.inputInt("Type the ID of the item you wish to examine. (press -1 to browse store)", -2, 100000);
 if (choice==-1) index=10;
 else {
 for(int j=0; j<this.eshop.itemsList.size(); j++)
 {
	 if (choice==this.eshop.itemsList.get(j).getid())
	 {
		 flag=true;
		 try {
			selectedItem=this.eshop.getitembyid(choice);
		} catch (NoSuchIDFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 if (flag)
 {
	 
	 System.out.println(selectedItem.toString());
	 int check = Str.inputInt("Do you wish to change the selected item ?(press 0 for yes and 1 for no and 2 to return to the main Menu)", 0, 2);
	 if(check==0)
	 {
		 
		 	this.eshop.updateItemStock(selectedItem);
		 	this.eshop.updateItemPrice(selectedItem);
		  	
	 }
	 else if(check == 1)
	 {
		 
		 index=15;
	 }
	 else
	 {
		 index=10;
	 }
	 
 }
 else
 {
	 System.out.println("you have chosen a number that does not correspond with an item.");
	 index=1;
 }
}
}
public void ownerCheckStatusMenu() {
	
	eshop.checkStatus();
	int j = Str.inputInt("Choose a client's number to see his statistics and Cart."+'\n', 0, this.eshop.buyerList.size());
	if(j<eshop.buyerList.size()) {
		for(int k=0; k<this.eshop.buyerList.get(j).getShoppingCart().orderList.size(); k++){
			System.out.println(eshop.buyerList.get(j).getShoppingCart().orderList.get(k).toString());
	}
	
	int b=Str.inputInt("If you wish to delete this Buyer press 0 or 1 to return to the previous menu", 0, 1);
		if(b==0) {
		
			index=11;
			eshop.buyerList.get(j).getShoppingCart().clearCart();
			eshop.buyerList.remove(j);
		
			}
			else index=1;
		}
	}
}	
	






