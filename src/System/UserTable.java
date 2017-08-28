package System;

import java.awt.Cursor;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;

public class UserTable extends Table{
	String[] coluname={"全选","账号","姓名" };
	UserTable(Vector vs, Users user, int modelSet, int col) {
		
		super(vs, user, modelSet, col);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	void add(Vector vs) {
		// TODO Auto-generated method stub
		
		
		Vector<Users> users=(Vector<Users>)vs;
		
		  Vector v;
		     
    	  for(Users u:users)
    	 {   v=new Vector();
    		 v.add(false);
    		 System.out.println(u.getAccount());
    		 v.add(u.getAccount());
    		 v.add(u.getName());
    		 this.getmodel().addRow(v);
    	 }
	}

	@Override
	void mouseClickAction(int columnIndex, int rowIndex) {
		// TODO Auto-generated method stub
		  if(columnIndex==col)
		  {

					   String  account=   (String) table.getValueAt(rowIndex, col);
					   
					   try {
						JFrame userView=new UserView(Users.getImformation(account));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			} 
			  
			  
		  
	}

	@Override
	void mouseMoveAction(int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex==col)
  		{
  			Cursor cu = new Cursor(Cursor.HAND_CURSOR);       
      		table.setCursor(cu);
  		}
  		else
  		{
  			Cursor cu = new Cursor(Cursor.DEFAULT_CURSOR);       
      		table.setCursor(cu);
  		}
	}

}
