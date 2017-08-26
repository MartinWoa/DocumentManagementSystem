package System;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

public class proposal {
    private String Text;  //文本内容
    private Date Date;  //截止日期
    private int ID;   //编号
    private String Author;  //作者
    private String Name;  //提案名称
    private int state=0;
    private int support=0;
    private int against=0;

    void setText(String t){Text=t;}
    void setDate(Date d){Date=d;}
    void setID(int ID){this.ID=ID;}
    void setAuthor(String a){Author=a;}  
    void setName(String na){Name=na;}   
    void setState(int state){this.state=state;}
    String getText(){return Text;}
    Date getDate(){return Date;}
    int getID(){return  ID;}
    String getAuthor(){return Author;}
    String getName(){return Name;}
    int getstate(){return state;}
    int getAgainst() {return against;}
    int getSupport() {return support;}
    

    Vector getComment() throws SQLException
    {
    CreatConnect con=new CreatConnect();
    Vector<Comment> com=new Vector<Comment>();
    Statement sta=con.getConnection().createStatement();
    try(ResultSet res=sta.executeQuery("SELECT ID,proid,issupport,comment,commenter,commenttime FROM comment WHERE proid= "+ID+""))
    {
    	while(res.next())
    	{
    		Comment c=new Comment();
    		c.setproid(ID);
    		c.setsupport(res.getBoolean(3));
    		c.setcomment(res.getString(4));
    		c.setCommenter(res.getString(5));
    		c.setTime(res.getDate(6));
    		com.add(c);
    	}
    }
    sta.close();
    return com;
    }

   static Vector getProposalByAccount(String account) throws SQLException
    {       CreatConnect con=new CreatConnect();
    	Vector<proposal> pros =new Vector<proposal>() ;
    	Statement sta=con.getConnection().createStatement();
    	try(ResultSet res=sta.executeQuery("SELECT ID,proname,author,lasttime,protext,state FROM proposal WHERE author= '"+account+"'"))
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
   String translationstate()
   {
	   switch (state)
	   {
		   case 0:
			  return "审核中";
		   case 1:return "推荐";
		   case 2: return "备案";
		   case 3:return "立案";
		   
	   }
	   return null;
   }
   static proposal getProposalById(int id) throws SQLException
    {   
        CreatConnect con=new CreatConnect();
        proposal pro=new proposal();
        Vector<proposal> pros =new Vector<proposal>() ;
    	Statement sta=con.getConnection().createStatement();
    	try(ResultSet res=sta.executeQuery("SELECT ID,proname,author,lasttime,protext,state FROM proposal WHERE ID= "+id+""))
    	{
    	  while(res.next())
    	  {
    		 
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
    	return pro;	
    }
    void setAgaAndSup()
    {
    	try {
			Vector<Comment>coms=this.getComment();
			for( Comment com :coms)
			{
			if(com.getSupport())
			{this.support+=1;}
			else
			{this.against+=1;}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    static void creatNewPro(proposal pro)
    {
    	 CreatConnect con=new CreatConnect();
    	 try 
    	 { 
    		 String sql = "Insert into proposal "+ "(proname,author,lasttime,protext,state)values(?,?,?,?,?)"; 
			Statement sta=con.getConnection().createStatement();
	 		PreparedStatement ps=con.getConnection().prepareStatement(sql);
	 		ps.setString(1, pro.getName());
	 		ps.setString(2, pro.getAuthor());
	 		java.sql.Date sd =new java.sql.Date(pro.getDate().getTime());
	 		ps.setDate(3, sd);
	 		ps.setString(4, pro.getText());
	 		ps.setInt(5, pro.getstate());
	 		ps.executeUpdate();
	 		ps.close();
		}  
    	 catch (SQLException e) 
    	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
