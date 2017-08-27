package System;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Comment
{
private int proid;
private boolean support;
private String comment;
private String commenter;
private Date time;
void setproid(int proid) {this.proid=proid;}
void setsupport(boolean s) {this.support=s;}
void setcomment(String comment) {this.comment=comment;}
void setCommenter(String commenter) {this.commenter=commenter;}
void setTime(Date time) {this.time=time;}
int getProid() {return this.proid;}
boolean getSupport() {return this.support;}
String getComment() {return this.comment;}
String getCommenter() {return this.commenter;}
Date getTime() {return this.time;}

static void CreatComment(Comment com)
{
	
	String sql = "Insert into comment "+ "(proid,issupport,comment,commenter,commenttime)values(?,?,?,?,?)";
	try {
		PreparedStatement ps=CreatConnect.getConnect().prepareStatement(sql);
		ps.setInt(1,com.getProid());
		ps.setBoolean(2,com.getSupport());
		ps.setString(3,com.getComment());
		ps.setString(4, com.getCommenter());
		java.sql.Date sd =new java.sql.Date(com.getTime().getTime());
    	ps.setDate(5, sd);
		ps.executeUpdate();
    	ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
