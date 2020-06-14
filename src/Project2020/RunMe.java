package Project2020;



public class RunMe {

	public static void main(String[] args) {
		
		boolean flag = true;
		
		
		Buyer teo = new Buyer("teo","teo@ceid.upatras.gr");
		Buyer alex = new Buyer("alex","alex@ceid.upatras.gr");
		Owner piou = new Owner("piou","piou@ceid.upatras.gr");
		Eshop eshop = new Eshop(piou,"ardin");
		
		Pen pen0 = new Pen("pen0","blue pen",200,5,2.0,"blue",0.5);
		Pen penA = new Pen("penA","red pen",100,5,2.0,"red",0.5);
		Pen penB = new Pen("penB","green pen",101,3,2.0,"green",0.5);
		Pen penC = new Pen("penC","yellow pen",102,5,2.0,"yellow",0.5);
		Pencil pencilA = new Pencil("pencilA","first pencil",103,70,1.0,0.7,"B");
		Pencil pencilB = new Pencil("pencilB","second pencil",132,30,1.0,0.7,"HB");
		Pencil pencilC = new Pencil("pencilC","third pencil",104,30,1.0,0.7,"H");
		Notebook notebookA = new Notebook("notebookA","4-subject",105,5,6.0,4);
		Notebook notebookB = new Notebook("notebookB","5-subject",106,5,6.0,5);
		Notebook notebookC = new Notebook("notebookC","6-subject",107,5,6.0,6);
		Paper paperA = new Paper("paperA","soft paper",108,100,0.1,1,5);
		Paper paperB = new Paper("paperB","medium paper",109,100,0.1,2,7);
		Paper paperC = new Paper("paperC","hard paper",110,100,0.1,3,10);
		
		eshop.itemsList.add(penA);
		eshop.itemsList.add(penB);
		eshop.itemsList.add(penC);
		
		eshop.itemsList.add(pencilA);
		eshop.itemsList.add(pencilB);
		eshop.itemsList.add(pencilC);
		
		eshop.itemsList.add(notebookA);
		eshop.itemsList.add(notebookB);
		eshop.itemsList.add(notebookC);
		
		eshop.itemsList.add(paperA);
		eshop.itemsList.add(paperB);
		eshop.itemsList.add(paperC);
	
		eshop.itemsList.add(pen0);
		
		try {
			teo.getShoppingCart().addItemOrdered(new ItemOrdered(penA,2));
			teo.getShoppingCart().addItemOrdered(new ItemOrdered(penB,2));
			teo.getShoppingCart().addItemOrdered(new ItemOrdered(notebookC,1));
			teo.getShoppingCart().addItemOrdered(new ItemOrdered(paperA,30));
			alex.getShoppingCart().addItemOrdered(new ItemOrdered(penC,2));
			alex.getShoppingCart().addItemOrdered(new ItemOrdered(pencilB,15));
			alex.getShoppingCart().addItemOrdered(new ItemOrdered(notebookB,1));
			alex.getShoppingCart().addItemOrdered(new ItemOrdered(paperC,30));
			} 
		catch (NotEnoughStockException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (NegativeOrderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
			eshop.addBuyer(teo);
			eshop.addBuyer(alex);
		}
		catch (BuyerAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
				Menuu mm=new Menuu(eshop);
				do{
				switch(mm.returnIndex()) {
				
				case -1:
					flag=false;
					break;
				
				case 0: 
					mm.login();
					break;
					
				case 1:
					mm.ownerMenu();
					break;
				case 2:
					mm.buyerMenu();
					break;
				case 3:
					mm.browseStoreMenu();
					break;
				case 4:
					mm.viewCartMenu();
					break;
				case 5:
					mm.pensMenu();
					break;
				case 6:
					mm.pencilsMenu();
					break;
				case 7:
					mm.notebooksMenu();
					break;
				case 8:
					mm.paperMenu();
					break;
				case 9:
					mm.viewCartAMenu();
					break;
				case 10:
					mm.ownerBrowseStoreMenu();
					break;
				case 11:
					mm.ownerCheckStatusMenu();;
					break;
				case 12:
					mm.ownerPensMenu();;
					break;
				case 13:
					mm.ownerPencilMenu();;
					break;
				case 14:
					mm.ownerNotebooksMenu();
					break;
				case 15:
					mm.ownerPaperMenu();
					break;
				default: 
					break;
				
				
					} 
				}		
				while(flag);
	}
	
}		



		
			
		
		
		
	
		

	
/*		
	System.out.println(alex.getbonus()+" "+ alex.getBuyerCategory());	
	
			
	Pen stylo = new Pen("Parker","this is a good pen",10000,52,1001.0,"blue",0.7);
	
	alex.placeOrder(stylo);
	
	
	alex.getShoppingCart().checkout(alex);
	alex.getShoppingCart().showCart(alex);
	
	
	System.out.println(alex.getbonus()+" "+ alex.getBuyerCategory());
}
*/
