package Project2020;

public class ItemOrdered {
	private Item item;
	private int quantity;
//Δύο constractor αναλόγως με το πόσα variables θα δώσει ο buyer.
 public ItemOrdered(Item item, int quantity) 
 {
	 this.item=item;
	 this.quantity=quantity;
 }
 
 public ItemOrdered(Item item) 
 {
	 this.item=item;
	 this.quantity=1;
 }
 
 public Item getItem () {
	 return this.item;
 }
 public int getquantity() {
	return this.quantity;
}
 
public void setquantity(int a)
	{
		this.quantity=a;
	}

}
