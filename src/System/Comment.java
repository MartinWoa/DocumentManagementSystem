package System;
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



}
