package model;

public class product
{
	private  int productid;
	private String productname;
	private int minquantity;
	private int price;
	private int quantity;
	
	public int getProductid() 
	{
		return productid;
	}
	public void setProductid(int productid) 
	{
		this.productid = productid;
	}
	
	
	public String getProductname() 
	{
		return productname;
	}
	public void setProductname(String productname)
	{
		this.productname = productname;
	}
	
	
	public int getMinquantity()
	{
		return minquantity;
	}
	public void setMinquantity(int minquantity)
	{
		this.minquantity = minquantity;
	}
	
	
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	
	
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}


}
