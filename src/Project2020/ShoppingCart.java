package Project2020;
import java.util.ArrayList;
import java.util.Scanner;


public class ShoppingCart {
	ArrayList <ItemOrdered> orderList = new ArrayList <ItemOrdered>();
	
	
// Εδώ τσεκάρω αν η αιτούμενη ποσότητα του itemΟrdered είναι επαρκής σε σχέση με το stock του αντικειμένου 
	
	// Χρησιμοποίηται Ο DEFAULT CONSTRUCTOR
	
	void addItemOrdered(ItemOrdered ordered) throws NotEnoughStockException,NegativeOrderException  
{
		boolean flag=false;
		int i=0;

		for ( i=0; i<orderList.size(); i++ )  // ελεγχω αν υπάρχει ηδη παραγγελια ιδιου αντικειμένου
				{
				if(orderList.get(i).getItem().isthesame(ordered.getItem()))
				{
				flag=true;
				break;
				}
			}
		if(ordered.getquantity()<0)
		{
			throw new NegativeOrderException();
		}
		else if (flag)
		{
			// Εδω επειδή το αντικείμενο που παραγγέλνω υπάρχει ήδη σε άλλη παραγγελία
			// προσθετω την ποσότητα που παραγγέλνει τώρα ο χρήστης με αυτή που είχε παραγγείλει
			// πριν.
			orderList.get(i).setquantity(orderList.get(i).getquantity()+ordered.getquantity());
		}
		else if ((ordered.getquantity())> ((ordered.getItem()).getstock()))
		{
			throw new NotEnoughStockException(); 
		}
		else
		{ 
			ordered.getItem().setstock((ordered.getItem()).getstock()-ordered.getquantity());
			orderList.add(ordered);
		}
		
	
		
		
}
	
void removeItemOrdered(int i)
//ΠΡΟΣΟΧΗ ΠΡΟΣ ΣΦΗΚΑ ΚΑΙ ΟΠΟΙΟΝ ΑΛΛΟ ΦΤΙΑΞΕΙ ΜΕΝΟΥ
//ΤΟ i ΕΙΝΑΙ ΔΕΙΚΤΗΣ ΠΟΥ ΜΑΣ ΛΕΕΙ ΠΟΙΑ ΠΑΡΑΓΓΕΛΙΑ
//ΑΠΟ ΤΟ ARRAY LIST ΘΑ ΔΙΑΓΡΑΦΕΙ!!!!!!!!!!!!!!!!!
	{
		// εδω επιστρέφω ότι ειχε παραγγείλει ο χρηστης πισω στο stock του αντικειμένου και διαγραφω
		// την παραγγελία απο το shopping cart
	orderList.get(i).getItem().setstock(orderList.get(i).getItem().getstock()+orderList.get(i).getquantity());
	orderList.remove(i);
	}

void changeItemOrderedQuantity(int i, int newquantity) throws NotEnoughStockException
// ΠΑΛΙ Ο ΔΕΙΚΤΗΣ Ι ΕΧΕΙ ΙΔΙΑ ΧΡΗΣΙΜΟΤΗΤΑ
	{
	 try
	 {
		 //Αρχικά επιστρέφω την ποσότητα της αρχικής παραγγελίας πίσωω στο Stock
		 // και μετά υπολογίζω αν μετά από αυτή την κίνηση υπαρχει αρκετό Stock
		 // για τη νέα παραγγελία, αν υπάρχει κανω stock=stock-newquantity
		 // αν οχι κανω throw notenoughstockexception
		 orderList.get(i).getItem().setstock(orderList.get(i).getItem().getstock()+orderList.get(i).getquantity());
		 if (newquantity<orderList.get(i).getItem().getstock())
		  {
			 throw new NotEnoughStockException();
		  }
		 
		 else
		 {
			 orderList.get(i).getItem().setstock(orderList.get(i).getItem().getstock()-newquantity);
			 orderList.get(i).setquantity(newquantity);
		 }
	 }
	 catch(NotEnoughStockException e){}
			//Θέλω να με γυρναει ένα βήμα πίσω.
	
	}

void clearCart()
	{
	int times =orderList.size(); // ΠΡΟΣΟΧΗΗΗ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 for(int i=times; i<0; i--) // εδω δε ξερω αν πρεπει να παει απο times ή απο times-1 πρεπει να ελεγχθει
	 {							//  
		 removeItemOrdered(i);  // 
	 }
	}

double calculateNet()
	{
	 double result=0;
	 for (int i=0; i<orderList.size(); i++ )
	 {		// υπολογίζω το ποσό πολλαπλασιάζοντας για κάθε παραγγελία στη λιστα τιμή με ποσό παραγγελίας
		 result=result+orderList.get(i).getquantity()*orderList.get(i).getItem().getprice();
	 }
	 return result;
	}
	
double caluclateCourierCost(Buyer buyer) // ΠΑΙΡΝΕΙ ΣΑΝ ΟΡΙΣΜΑ ΤΟΝ BUYER TOY SHOPPINGCART
 { 
	
	double courierCost=((calculateNet()*2)/100);
	if (courierCost<3) courierCost=3;
	
	if(buyer.getBuyerCategory()=="SILVER") return(courierCost/2);
	else if(buyer.getBuyerCategory()=="GOLD") return 0;
	else return (courierCost);
 }
	
	public void showCart(Buyer buyer) // ΠΑΙΡΝΕΙ ΣΑΝ ΟΡΙΣΜΑ ΤΟΝ BUYER TOY SHOPPINGCART
	{
		for (int i=0; i<orderList.size(); i++ )
		{
			System.out.println("Itemorder number: "+ i+1);
			System.out.println('\n');
			System.out.println(orderList.get(i).getItem().toString());
			System.out.println('\n'+'\n');
		}
		System.out.println('\n');
		System.out.println("Your Net value is: "+ calculateNet());
		System.out.println("Your courier cost is: "+ caluclateCourierCost(buyer));
		System.out.println("Your Net value is: "+ calculateNet()+caluclateCourierCost(buyer));
	}
	
 public void checkout(Buyer buyer)
 
  {
	double fullcost=0;
	showCart(buyer);
	System.out.println('\n'+"Press 1 to continue on with the transaction");
	Scanner scan = new Scanner(System.in);
    int flag = scan.nextInt();
    scan.close();
    if (flag==1)
    {
    	int times =orderList.size(); // ΠΡΟΣΟΧΗΗΗ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   	 for(int i=times; i<0; i--) // εδω δε ξερω αν πρεπει να παει απο times ή απο times-1 πρεπει να ελεγχθει
    	{
    		fullcost=fullcost+orderList.get(i).getItem().getprice()*orderList.get(i).getquantity();
    		orderList.remove(i);
    	}
   	 buyer.awardBonus(fullcost);
    }
    else 
    {																//ΠΡΟΣΟΧΗ !!!!! ΣΦΗΚΑ ΧΤΙΣΤΗ ΤΟΥ ΜΕΝΟΥ
    	System.out.println("You did not complete the transaction");//ΕΔΩ ΠΡΕΠΕΙ ΝΑ ΠΗΓΑΙΝΕΙ ΕΝΑ ΒΗΜΑ ΠΙΣΩ
    }
   
  }

}
