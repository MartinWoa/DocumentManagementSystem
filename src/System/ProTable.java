package System;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ProTable extends Table{
	String[] coluname={"全选","编号","提案名称","作者","截至日期","状态","赞成数","反对数"};
	ProTable(Vector vs, Users user, int modelSet, int col) {
		super(vs, user, modelSet, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	void add(Vector vs) {
		// TODO Auto-generated method stub
		
		Vector<proposal> pros= (Vector<proposal>) vs;
		
		for(proposal pro :pros)
		{   
			addpro(pro);
		}
	}
	
	void addpro(proposal pro)
	{
	 Vector v= new Vector();
	 v.add(false);
	 v.add(pro.getID());
	 v.add(pro.getName());
	 v.add(pro.getAuthor());
	 v.add(pro.getDate());
	 v.add(pro.translationstate());
	 pro.setAgaAndSup();
	 v.add(pro.getSupport());
	 v.add(pro.getAgainst());
	 this.getmodel().addRow(v);
	}

	@Override
	void mouseClickAction(int columnIndex, int rowIndex) {
		// TODO Auto-generated method stub
		
		  if(columnIndex==col)
		  {
			 
			  
			  try {
				  switch(modelSet)
				  {
				  case 0:
					   int id=(int) table.getValueAt(rowIndex, col);
						proposal pro=proposal.getProposalById(id);
						JFrame textView=new ProTextView(user,pro);
						textView.setVisible(true);
						textView.setTitle(pro.getName());
						break;
	
					  
					  
				  }

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
