package System;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Admin  extends Users {
	Vector getUserByCheck() throws SQLException
	{   
		
		Users user;
		Vector<Users> users =new Vector<Users>();
		Statement sta=CreatConnect.getConnect().createStatement();
		try(ResultSet res=sta.executeQuery("SELECT admin,Account,password,username,sex,contact,seminar,Specialcommittee,IndustryBranch,birthday,adress,referees,state FROM user WHERE state="+false+""))
		{
			while(res.next())
			{   
				  
				
					if(res.getBoolean(1)==true)
					{
						user=new Admin();
					}
					else
					{
						user=new Writer();
					}
				    user.setInformation(res);
				   users.add(user);
				
			}
		}
		sta.close();
		return users;
	}
	Vector getProposalByCheck() throws SQLException
	{   
	
		Vector<proposal> pros =new Vector<proposal>() ;
		Statement sta=CreatConnect.getConnect().createStatement();
		try(ResultSet res=sta.executeQuery("SELECT ID,proname,author,lasttime,protext,state FROM proposal WHERE state= "+false+""))
		{
		  while(res.next())
		  {
			 proposal pro=new proposal();
			 pro.setID(res.getInt(1));
			 pro.setName(res.getString(2));
			 pro.setAuthor(res.getString(3));
			 pro.setDate(res.getDate(4));
			 pro.setText(res.getString(5));
			 pro.setState(res.getInt(6));
		     pros.add(pro);
		     
		  }
		 
		}
		 sta.close();
		return pros;	
	}
	
}
