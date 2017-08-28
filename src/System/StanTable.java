package System;

import java.awt.Cursor;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;

public class StanTable extends Table{
	String[] coluname={"编号","规范名称","作者" };
	StanTable(Vector vs, Users user, int modelSet, int col) {
		super(vs, user, modelSet, col);
		// TODO Auto-generated constructor stub
	}
	@Override
	void add(Vector vs) {
		// TODO Auto-generated method stub
		Vector <Standard> stans=(Vector <Standard>) vs;
		Vector v;
		for(Standard stan:stans)
		{
			v=new Vector();
			v.add(stan.getID());
			v.add(stan.getName());
			v.add(stan.getAuthor());
			this.getmodel().addRow(v);
		}
	}
	@Override
	void mouseClickAction(int columnIndex, int rowIndex) {
		// TODO Auto-generated method stub
		  if(columnIndex==col)
		  {
			 
			  

					  int ID=(int) table.getValueAt(rowIndex, col-1);              						  
					  try {
						JFrame sta = new StaView(Standard.getStandard(ID));
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
