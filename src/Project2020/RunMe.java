package Project2020;

import java.awt.*;
import javax.swing.*;

public class RunMe 
{

	public static void main(String[] args) 
{
		Buyer teo = new Buyer("teo","teo@ceid.upatras.gr");
		Buyer alex = new Buyer("alex","alex@ceid.upatras.gr");
		Owner piou = new Owner("piou","piou@ceid.upatras.gr");
		Eshop eshop = new Eshop(piou,"LeShop");
		try {
			eshop.addBuyer(teo);
			eshop.addBuyer(alex);
		} catch (BuyerAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

}