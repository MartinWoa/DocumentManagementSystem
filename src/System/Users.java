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
    private String Specialcommittee;  //涓撳浼?
    private boolean seminar ;//鐮旂┒浼?
    private String IndustryBranch;//鍒嗗浼?
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
    String getSpecialcommittee(){return Specialcommittee;}
    void setAccount(String rep){Account=rep;}
    void setpassword(char[] rep){password=new String(rep);}
    void setName(String rep){Name=rep;}
    void setSex(boolean rep){Sex=rep;}
    void setContact(int rep){Contact=rep;}
    void setSpecialcommittee(String rep){Specialcommittee=rep;}
    void setstate(boolean state) {this.state=state;}
    void setIndustryBranch(String IndustryBranch) {this.IndustryBranch=IndustryBranch;}
    void setseminar(boolean seminar) {this.seminar=seminar;}
    boolean getseminar() {return seminar;}
    String getIndustryBranch() {return IndustryBranch;}
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
	    this.setSpecialcommittee(res.getString(8));
	    this.setIndustryBranch(res.getString(9));
	    this.setbirthday(res.getDate(10));
	    this.setAdress(res.getString(11));
	    this.setReferees(res.getString(12));
	    this.setstate(res.getBoolean(13));
	    
    }
    static Users getImformation(String account) throws SQLException
    {   String pa;
    	Users user;
    	
    	Statement sta=CreatConnect.getConnect().createStatement();
    	try(ResultSet res=sta.executeQuery("SELECT admin,Account,password,username,sex,contact,seminar,Specialcommittee,IndustryBranch,birthday,adress,referees,state FROM user WHERE Account='"+account+"'"))
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
    			    sta.close();
    			    return user;
    			
    		}
    	}
        sta.close();
    	return null;
    }
    String getSexInString()
    {
    	if(this.Sex)
    	{return "男";}
    	else
    	{return "女";}
    }
    static boolean isexist(String account) throws SQLException
    {
    	
    	Statement sta=CreatConnect.getConnect().createStatement();
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
    String checkreferees() throws SQLException
    {    if(this.getReferees().equals(""))
         {
    	    return null;
         }
         
	     Statement sta=CreatConnect.getConnect().createStatement();
	    try(ResultSet res=sta.executeQuery("SELECT reason FROM referees WHERE Referees='"+this.getReferees()+"' And Recommended ='"+this.getAccount()+"'"))
	    {
	    	while(res.next())
	    	{
	    		return res.getString(1);
	    	}
	    }
         
		return null;
    	
    }
    static void deleteUser(Users user)
    {
    	
	    String sql="DELETE FROM user WHERE Account  = '"+user.Account+"' ";
	    PreparedStatement ps;
		try {
			ps = CreatConnect.getConnect().prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    
    }
    
    static void updateuser(Users user)
    {  
	    java.sql.Date sd =new java.sql.Date(user.getbirthday().getTime());
	    System.out.println(sd);
    	String sql="UPDATE user SET password ='"+user.getPassword()+"'  ,username='"+user.getName()+"' ,sex="+user.getSex()+" ,contact="+user.getContact()+" ,seminar="+user.getseminar()+" ,Specialcommittee='"+user.getSpecialcommittee()+"' ,IndustryBranch='"+user.IndustryBranch+"' ,birthday='"+sd+"' ,adress='"+user.getAdress()+"' ,referees='"+user.getReferees()+"' ,state="+user.getstate()+" ,admin="+user.admin+"  WHERE Account ='"+user.getAccount()+"' ";
    	try {
			PreparedStatement ps=CreatConnect.getConnect().prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    static void insertRecommend(String recommended,String referees,String reason)
    {
    	
    	try 
    	{
   		 String sql = "Insert into referees "+ "(Referees,Recommended,reason)values(?,?,?)";
   		PreparedStatement ps=CreatConnect.getConnect().prepareStatement(sql);
   		ps.setString(1, referees);
   		ps.setString(2, recommended);
   		ps.setString(3, reason);
   		ps.executeUpdate();
    	ps.close();
    	}
    	catch (SQLException e) {
    		// TODO 自动生成的 catch 块
    		System.out.println("SQL Exception: " + e.toString());
    		e.printStackTrace();
    	}
    	}
    static void rigon(Users user)
    {  
    	try {
   		 String sql = "Insert into user "+ "(Account,password,username,sex,contact,seminar,Specialcommittee,IndustryBranch,birthday,adress,referees,state,admin)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
   		PreparedStatement ps=CreatConnect.getConnect().prepareStatement(sql);
    	ps.setString(1, user.getAccount());
    	ps.setString(2, user.getPassword());
    	ps.setString(3, user.getName());
    	ps.setBoolean(4, user.getSex());
    	ps.setInt(5, user.getContact());
    	ps.setBoolean(6, user.getseminar());
    	ps.setString(7, user.getSpecialcommittee());
    	ps.setString(8, user.getIndustryBranch());
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

