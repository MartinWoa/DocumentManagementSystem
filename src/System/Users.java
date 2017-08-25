package System;


import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public abstract class  Users implements Serializable{
    private String Account;   //账号
    private String password;   //瀵嗙爜
    private String Name;     //濮撳悕
    private boolean Sex;       //鎬у埆
    private int Contact;  //鑱旂郴鏂瑰紡
    private boolean Specialcommittee;  //涓撳浼?
    private boolean seminar ;//鐮旂┒浼?
    private boolean IndustryBranch;//鍒嗗浼?
    private Date birthday;    //鐢熸棩
    private String Adress;  //鍦板潃
    private String Referees;  //鎺ㄤ粙浜?
    private boolean state;  //鐘舵??
    private boolean admin;
    boolean getadmin() {return admin;}
    String getAccount(){return Account;}
    String getPassword(){return password;}
    String getName(){return Name;}
  boolean getSex(){return Sex;}
    int getContact(){return Contact;}
    boolean getSpecialcommittee(){return Specialcommittee;}
    void setAccount(String rep){Account=rep;}
    void setpassword(char[] rep){password=new String(rep);}
    void setName(String rep){Name=rep;}
    void setSex(boolean rep){Sex=rep;}
    void setContact(int rep){Contact=rep;}
    void setSpecialcommittee(boolean rep){Specialcommittee=rep;}
    void setstate(boolean state) {this.state=state;}
    void setIndustryBranch(boolean IndustryBranch) {this.IndustryBranch=IndustryBranch;}
    void setseminar(boolean seminar) {this.seminar=seminar;}
    boolean getseminar() {return seminar;}
    boolean getIndustryBranch() {return IndustryBranch;}
    void setadmin(boolean admin) {this.admin=admin;}
    Date getbirthday(){ return birthday;}
    String getAdress(){return Adress;}
    String getReferees(){return Referees;}

   // String getSpecialcommittee(){return Specialcommittee;}
    void setbirthday(Date rep){birthday=rep;}
    void setAdress(String rep){Adress=rep;}
    void setReferees(String rep){ Referees=rep;}
    boolean getstate() {return state;}

    void setInformation(ResultSet res) throws SQLException
    {
		this.setadmin(res.getBoolean(1));
		this.setAccount(res.getString(2));
		this.setpassword(res.getString(3).toCharArray());
	    this.setName(res.getString(4));
	    this.setSex(res.getBoolean(5));
	    this.setContact(res.getInt(6));
	    this.setseminar(res.getBoolean(7));
	    this.setSpecialcommittee(res.getBoolean(8));
	    this.setIndustryBranch(res.getBoolean(9));
	    this.setbirthday(res.getDate(10));
	    this.setAdress(res.getString(11));
	    this.setReferees(res.getString(12));
	    this.setstate(res.getBoolean(13));
	    
    }
    static Users getImformation(String account,char[] password) throws SQLException
    {   String pa;
    	Users user;
    	CreatConnect con=new CreatConnect();
    	Statement sta=con.getConnection().createStatement();
    	try(ResultSet res=sta.executeQuery("SELECT admin,Account,password,username,sex,contact,seminar,Specialcommittee,IndustryBranch,birthday,adress,referees,state FROM user WHERE Account='"+account+"'"))
    	{   
    		while(res.next())
    		{   pa=new String(password);
    			if( res.getString(2).equals(account)&&res.getString(3).equals(pa))
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
    			    sta.close();
    			    return user;
    			}
    		}
    	}
        sta.close();
    	return null;
    }
    
    static boolean isexist(String account) throws SQLException
    {
    	CreatConnect con=new CreatConnect();
    	Statement sta=con.getConnection().createStatement();
    	try(ResultSet res=sta.executeQuery("SELECT Account FROM user WHERE Account='"+account+"'"))
    	{
    		while(res.next())
    		{   sta.close();
    			return true;
    		}
    	}
    	sta.close();
    	return false;
    }
    
    static void rigon(Users user)
    {   CreatConnect con=new CreatConnect();
    	try {
   		 String sql = "Insert into user "+ "(Account,password,username,sex,contact,seminar,Specialcommittee,IndustryBranch,birthday,adress,referees,state,admin)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
   		PreparedStatement ps=con.getConnection().prepareStatement(sql);
    	ps.setString(1, user.getAccount());
    	ps.setString(2, user.getPassword());
    	ps.setString(3, user.getName());
    	ps.setBoolean(4, user.getSex());
    	ps.setInt(5, user.getContact());
    	ps.setBoolean(6, user.getseminar());
    	ps.setBoolean(7, user.getSpecialcommittee());
    	ps.setBoolean(8, user.getIndustryBranch());
    	java.sql.Date sd =new java.sql.Date(user.getbirthday().getTime());
    	ps.setDate(9, sd);
    	ps.setString(10, user.getAdress());
    	ps.setString(11, user.getReferees());
    	ps.setBoolean(12, user.getstate());
    	ps.setBoolean(13, user.getadmin());
    	ps.executeUpdate();
    	ps.close();
    	}
    	catch (SQLException e) {
    		// TODO 自动生成的 catch 块
    		System.out.println("SQL Exception: " + e.toString());
    		e.printStackTrace();
    	}
    }
    
}

