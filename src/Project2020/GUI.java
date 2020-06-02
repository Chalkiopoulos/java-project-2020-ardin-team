package Project2020;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUI  implements ActionListener
{
	private Eshop eshop;
	private Buyer loginBuyer= null; // Ο Buyer που κανει login
	private JFrame frame;
	private JPanel loginPanel;
	private JLabel labelName;
	private JLabel labelEmail;
	private JLabel labelLogin;
	private JTextField textfieldName;
	private JTextField textfieldEmail;
	private JButton loginButton;
	
	private JPanel buyerPanel;
	private JLabel buyerLabel;
	private JLabel buyerStatsLabel;
	
public GUI(Eshop eshopTBU)//ehop To Be Used
{
	//Για καθε διαφορετικη φάση του menu θα παω σε αλλο panel
	
	frame = new JFrame();
	loginPanel = new JPanel();
	labelName = new JLabel();
	labelEmail = new JLabel();
	labelLogin = new JLabel();
	textfieldName = new JTextField();
	textfieldEmail = new JTextField();
	loginButton = new JButton();
	this.eshop=eshopTBU;
	
	
	
	
	frame.setSize(500,500);
	frame.add(loginPanel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("this is me playing with GUI");
	frame.setVisible(true);
	
	loginPanel.setLayout(null);
	
	labelName.setText("Username:");
	labelName.setBounds(10,20,100,25);
	loginPanel.add(labelName);
	
	textfieldName.setBounds(100,20,200,25);
	loginPanel.add(textfieldName);
	
	labelEmail.setText("Email:");
	labelEmail.setBounds(10,60,100,25);
	loginPanel.add(labelEmail);
	
	textfieldEmail.setBounds(100,60,200,25);
	loginPanel.add(textfieldEmail);
	
	loginButton.setText("LOGIN");
	loginButton.setBounds(10,100,150,25);
	loginButton.addActionListener(this);
	
	loginPanel.add(loginButton);
	
	labelLogin.setBounds(200,100,300,25);
	labelLogin.setText("");
	loginPanel.add(labelLogin);
	
	
	buyerPanel = new JPanel();
	buyerPanel.setLayout(null);
	
	buyerLabel = new JLabel();
	buyerLabel.setBounds(10, 10, 100, 25);
	buyerStatsLabel= new JLabel();
	buyerStatsLabel.setBounds(10,40,300,25);
	buyerPanel.add(buyerLabel);
	buyerPanel.add(buyerStatsLabel);
	
}


public void actionPerformed(ActionEvent e) 
{
	
	boolean userFound=false;
	boolean userIsOwner=false;
	
	
	
if (e.getSource()==loginButton)	
{	
	// Εδω ελεγχω αν αυτό που εβαλε ο χρηστης ειναι ονομα και mail του owner
	if (this.eshop.getowner().getname().equals(textfieldName.getText()) && this.eshop.getowner().getemail().equals(textfieldEmail.getText()))
	{
		userFound=true;
		userIsOwner=true;
	}
		
	if(!userFound) // εδω ελεγχω αν αυτα που εγραψε ο χρηστης ειναι στοιχεια καποιου buyer
	{
		for(int i=0; i<this.eshop.buyerList.size(); i++)
		{
			
			if( (this.eshop.buyerList.get(i).getname().equals(textfieldName.getText())) && (this.eshop.buyerList.get(i).getemail().equals(textfieldEmail.getText())) )
			{
				userFound=true;
				loginBuyer=this.eshop.buyerList.get(i);
				
			}
		}
	}
	
	
	if (userFound&&!userIsOwner)
	{
		labelLogin.setText("THATS A BUYER");
		
		buyerLabel.setText("Hello "+ loginBuyer.getname());
		buyerStatsLabel.setText(" Name: "+ loginBuyer.getname()+'\t'+" Points: "+loginBuyer.getbonus()+'\t'+" Category: "+ loginBuyer.getBuyerCategory());
		frame.remove(loginPanel);
		frame.add(buyerPanel);
	}
	else if (userFound&&userIsOwner)
	{
		labelLogin.setText("THATS THE OWNER");
	}
	else 
	{
		labelLogin.setText("LOGIN FAILED");
	}
}	

}



}
