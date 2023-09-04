package cotroller;
import java.sql.SQLException;
import java.util.Scanner;

import dao.LoginDao;
import dao.ProductDao;
import model.login;
import model.product;
public class Main 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		
		int choice;
		login l=new login();
		LoginDao ldao=new LoginDao();
	    product p=new product();
	    ProductDao pdao=new ProductDao();
		do {
			System.out.println("1.Admin \n2.Agent \n 3.Exit \n***********************************************************************************************\nEnter your choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("1. Admin login");
				
				System.out.println("Enter username for admin login:");
				String username1=sc.next();
				System.out.println("Enter password:");
				String password1=sc.next();// difference between next and nextln
				l.setUsername(username1);
				l.setPasswoed(password1);
				if(ldao.checkCredential(l))
				{
					System.out.println("login Successfull");
					int option ;
					do {
						System.out.println("1.Add products \n2.Display products\n 3.Update \n 4.delete \n5.Log out \n***********************************************************************************************\nEnter your option:");
						option=sc.nextInt();
						switch(option) {
						case 1:
							System.out.println("Add product");
							System.out.println("Enter the product id:");
							int product_id=sc.nextInt();
							System.out.println("Enter the product name:");
							String product_name=sc.next();
							System.out.println("Enter the product minisell quantity:");
							int min_quantity=sc.nextInt();
							System.out.println("Enter the  price");
							int price=sc.nextInt();
							System.out.println("Enter the quantity");
							int quantity=sc.nextInt();
							System.out.println("Product added Successfully");
							p.setProductid(product_id);
							p.setProductname(product_name);
							p.setMinquantity(quantity);
							p.setPrice(price);
							p.setQuantity(quantity);
							pdao.addproduct(p);
							break;
							
						case 2:
							System.out.println("Display product");
							
							pdao.display();
							break;
						case 3:
							System.out.println("Update product");
							System.out.println("Add product");
							System.out.println("Enter the product id:");
							int product_id1=sc.nextInt();
							System.out.println("Enter the product name:");
							String product_name1=sc.next();
							System.out.println("Enter the product minisell quantity:");
							int min_quantity1=sc.nextInt();
							System.out.println("Enter the  price");
							int price1=sc.nextInt();
							System.out.println("Enter the quantity");
							int quantity1=sc.nextInt();
							System.out.println("Product added Successfully");
							p.setProductid(product_id1);
							p.setProductname(product_name1);
							p.setMinquantity(quantity1);
							p.setPrice(price1);
							p.setQuantity(quantity1);
							pdao.update(p);
							System.out.println("Updated successfully");
							break;
						case 4:
							System.out.println("delete product");
							int product_id2=sc.nextInt();
							p.setProductid(product_id2);
							pdao.delete(p);
							System.out.println("deleted successfully");
							break;
						case 5:
							System.out.println("Logout");
	
							break;
							
							
						}
					}while(option!=5);
				}
				else 
				{
					System.out.println("Incorrect username or password");
				}
				break;
			case 2:
				System.out.println("1. Agent login");
				System.out.println("Enter username for Agent login:");
				String username2=sc.next();
				System.out.println("Enter password:");
				String password2=sc.next();
				l.setUsername(username2);
				l.setPasswoed(password2);
				
				if(ldao.checkCredential(l))
				{
					System.out.println("login Successfull");
					int option ;
					do {
						System.out.println("1.Display products \n 2.Log out \n***********************************************************************************************\nEnter your option:");
						option=sc.nextInt();
						switch(option)
						{
						
						case 1:
							System.out.println("Display product");
							pdao.display();
							break;
						case 2:
							System.out.println("Logout");
							break;
							
							
						}
					}while(option!=2);
				}
				else 
				{
					System.out.println("Incorrect username or password");
				}
				}
			break;
			
			
		}while(choice!=3);
		 
		sc.close();
		
		
		
	}
	
	
	

}
