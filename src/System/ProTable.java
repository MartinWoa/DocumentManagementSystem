package System;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ProTable extends JTable{
	private DefaultTableModel model;
    JTable table=this;
    int isAll=0;
	ProTable(Vector<proposal> pros)
	{
;
	String[] coluname={"全选","编号","提案名称","作者","截至日期","状态","赞成数","反对数"};


	TableColumnModel cM=table.getColumnModel();
		model=new DefaultTableModel(null,coluname){   //设置表格模式

			public boolean isCellEditable(int rowIndex, int columnIndex)  
			{  
			    if (columnIndex==0)  
			        return true;  
			    else  
			        return false;  
			}  

		};
		
		table.setModel(model);
		cM.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		//添加标格监听事件

      table.getTableHeader().addMouseListener
      (
    		  new MouseAdapter() {
    		  public void mouseClicked(MouseEvent e){
    			  int columnIndex = table.columnAtPoint(e.getPoint()); //获取点击的列
		          if(columnIndex==0)
		          {
		        	  if(isAll==0)
	            		{
	            			for(int i=0;i<table.getRowCount();i++)
	            			{
	            				table.setValueAt(true, i, 0);
	            			}
	            			isAll=1;
	            		}
	            		else
	            		{
	            			for(int i=0;i<table.getRowCount();i++)
	            			{
	            				table.setValueAt(false, i, 0);
	            			}
	            			isAll=0;
	            		}
		          }
    			  }
    		  }
      );
   
	for(proposal pro :pros)
	{   
		add(pro);
	}
	
	}
	
	Vector getChecked()
	{   Vector v=new Vector();
		for(int i=0;i<table.getRowCount();i++)
		{
			if((boolean) table.getValueAt(i, 0)==true)
			{
				v.add(table.getValueAt(i, 1));
			}
		}
		return v;	
	}
	void add(proposal pro)
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
	 model.addRow(v);
	}
	
	
	
}
