package dao;
import java.sql.*;

import connectionmanager.ConnectionManager;
import model.product;

public class ProductDao 
{
 public void addproduct(product p) throws ClassNotFoundException, SQLException
 {
	ConnectionManager cm=new ConnectionManager();
	Connection con=cm.establishConnection();
	String que="insert into product(productid,productname,minquantity,price,quantity) values(?,?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(que);
    ps.setInt(1,p.getProductid());
    ps.setString(2,p.getProductname());
    ps.setInt(3,p.getMinquantity());
    ps.setInt(4, p.getPrice());
    ps.setInt(5, p.getQuantity());
    ps.executeUpdate();
    cm.closeconnection();
    	}
 public void display() throws SQLException, ClassNotFoundException
 {
	//1. jdbc connrection
		ConnectionManager cm =new  ConnectionManager();
	    Connection con=cm.establishConnection();
	    
	    //2.create a statement
	    Statement st=con.createStatement();
	    //3.write and execute query
	    ResultSet rt= st.executeQuery("select  *from product");
	    //4.check username and pasword
	    while(rt.next())
	    {
	    	System.out.println(rt.getInt(1)+" | "+rt.getString(2)+" | "+rt.getInt(3)+" | "+rt.getInt(4)+" | "+rt.getInt(5));
	    //System.out.println(rt.getInt(1))+" | "+rt.getString(2)+" | "+rt.getInt(3)+" | "+rt.getInt(4)+" | "+rt.getInt(5));	
	    }
	    cm.closeconnection();
 }
 public void update(product p) throws ClassNotFoundException, SQLException
 {
	 ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="update  product set productname=?,minquantity=?,price=?,quantity=? where productid=?";
		PreparedStatement ps=con.prepareStatement(que);
	    
	    ps.setString(1,p.getProductname());
	    ps.setInt(2,p.getMinquantity());
	    ps.setInt(3, p.getPrice());
	    ps.setInt(4, p.getQuantity());
	    ps.setInt(5, p.getProductid());
	    
	    ps.executeUpdate();
	    cm.closeconnection();
 }
 public void delete(product p) throws ClassNotFoundException, SQLException
 {
	 ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="delete  from product  where productid=?";
		PreparedStatement ps=con.prepareStatement(que);
	    
	   ps.setInt(1, p.getProductid());
	    
	    ps.executeUpdate();
	    cm.closeconnection();
 }

 }


