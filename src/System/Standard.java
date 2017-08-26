package System;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Standard {
	private int ID;
	private String name;
	private String text;
	private String author;
	void setAuthor(String author) {this.author=author;}
	void setID(int id) {this.ID=id;}
	void setName(String name) {this.name=name;}
	void setText(String text) {this.text=text;}
	int getID() {return ID;}
	String getName() {return name;}
	String getText() {return text;}
	String getAuthor() {return author;}
	
	static Vector getStandard() throws SQLException
	{   
		 CreatConnect con=new CreatConnect();
		 Statement sta=con.getConnection().createStatement();
		 try(ResultSet res=sta.executeQuery("SELECT ID,staname,statext,author FROM standard ")) 
		 {   
			 Vector<Standard> v= new Vector<Standard>() ;
			 while(res.next())
			 {
				 Standard stan=new Standard();
				 stan.setID(res.getInt(1));
				 stan.setName(res.getString(2));
				 stan.setText(res.getString(3));
				 stan.setAuthor(res.getString(4));
				 v.add(stan);
			 }
			 return v;
		 }
		
	}
	static Standard getStandard(int ID) throws SQLException
	{   
		 CreatConnect con=new CreatConnect();
		 Statement sta=con.getConnection().createStatement();
		 try(ResultSet res=sta.executeQuery("SELECT ID,staname,statext,author FROM standard WHERE ID="+ID+"")) 
		 {   

			 while(res.next())
			 {
				 Standard stan=new Standard();
				 stan.setID(res.getInt(1));
				 stan.setName(res.getString(2));
				 stan.setText(res.getString(3));
				 stan.setAuthor(res.getString(4));
				 return stan;
			 }
			
		 }
		return null;
		
	}
	static void creatStandard (Standard stan)
	{
		 CreatConnect con=new CreatConnect();
		 String sql = "Insert into standard "+ "(staname,statext,author)values(?,?,?)";
	   		try {
				PreparedStatement ps=con.getConnection().prepareStatement(sql);
				ps.setString(1, stan.getName());
				ps.setString(2, stan.getText());
				ps.setString(3, stan.getAuthor());
				ps.executeUpdate();
		    	ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
