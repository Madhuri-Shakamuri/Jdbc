package dao;
import java.sql.*;
import connectionmanager.ConnectionManager;
import model.login;

public class LoginDao 
{
public boolean checkCredential(login l) throws ClassNotFoundException, SQLException
{
	//1.get the details from login.java file
	String username=l.getUsername();
	String password=l.getPasswoed();
	//2. jdbc connrection
	ConnectionManager cm =new  ConnectionManager();
    Connection con=cm.establishConnection();
    
    //3.create a statement
    Statement st=con.createStatement();
    //4.write and execute query
    ResultSet rt= st.executeQuery("select  *from login");
    //5.check username and password
    while(rt.next())
    {
    	if(username.equals(rt.getString("username")) &&  password.equals(rt.getString("passwoed"))) 
    	{
    		return true;
    	}
    }
    cm.closeconnection();
    return false;
    
    
	}

}
