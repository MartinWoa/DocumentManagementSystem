package System;

import java.awt.Cursor;
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



public abstract class Table extends JTable {
	
	private DefaultTableModel model;
    JTable table=this;
    int isAll=0;
    boolean isClick;
    int modelSet;
    int col;
    Users user;
    String[] coluname;
    String[] coluname0={"全选","编号","提案名称","作者","截至日期","状态","赞成数","反对数"};
    String[] coluname1= {"评论人","评论内容","评论时间","赞成"};
    String[] coluname2= {"全选","账号","姓名" };
    String[] coluname3= {"编号","规范名称","作者" };
	Table(Vector vs,Users user,int modelSet,int col)
	{  String[] coluname = null;
		this.modelSet=modelSet;
		this.col=col;
     this.user=user;
 	switch(modelSet)
 	{
 	case 0:coluname=coluname0;break;
 	case 1:coluname=coluname1;break;
 	case 2:coluname=coluname2;break;
 	case 3:coluname=coluname3;break;
 	}

	
	model=new DefaultTableModel(null,coluname){   //设置表格模式

		public boolean isCellEditable(int rowIndex, int columnIndex)  
		{  

		        return false;  
		}  

	     };
     
		table.setModel(model);
		
		//添加标格监听事件
		if(coluname[0].equals("全选")) 
		{

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
			TableColumnModel cM=table.getColumnModel();
			cM.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
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
		}
        if(col!=-1)
        {   //点击查询
            table.addMouseListener(
          		  new MouseAdapter()
                        {
              		  public void mouseClicked(MouseEvent e)
              		  {
              			  int columnIndex = table.columnAtPoint(e.getPoint());
              			  int rowIndex = table.rowAtPoint(e.getPoint());
                          mouseClickAction(columnIndex,rowIndex);
              		  }
              		  }
 
          		  );
            
            
            //光标设置
            table.addMouseMotionListener(   //光标设置
          		  new MouseMotionAdapter() {
          			    
          			  public void mouseMoved(MouseEvent e) {
          	        		int columnIndex = table.columnAtPoint(e.getPoint()); //获取点击的列
          	        		mouseMoveAction(columnIndex);
          	        	}
          	    

          		  }
          		  );

        }
    add(vs);
 
 
	
	}
	
	abstract void add(Vector vs);
	/*
	 * 
	 * 不同的类添加不同的数据
	 * 
	 * 
	 * 
	 */
	
	void standard(Users user,Vector<Standard> stans)
	{
		Vector v;
		for(Standard stan:stans)
		{
			v=new Vector();
			v.add(stan.getID());
			v.add(stan.getName());
			v.add(stan.getAuthor());
			model.addRow(v);
		}
	}
	void user(Users user,Vector<Users> users)
	{	  Vector v;
	     
	    	  for(Users u:users)
	    	 {   v=new Vector();
	    		 v.add(false);
	    		 System.out.println(u.getAccount());
	    		 v.add(u.getAccount());
	    		 v.add(u.getName());
	    		 model.addRow(v);
	    	 }
	      
		
	}
	void comment(Vector<Comment> coms)
	{  
		 Vector v;
		for(Comment com:coms)
		{   v= new Vector();
			v.add(com.getCommenter());
			v.add(com.getComment());
			v.add(com.getTime().toString());
			v.add(com.getSupport());
			model.addRow(v);
			
		}
	}
	void pro(Vector<proposal> pros)
	{
		for(proposal pro :pros)
		{   
			addpro(pro);
		}
	}
	
	
	
	
	
	
	
	
	Vector getChecked(int colnum)
	{   Vector v=new Vector();
		for(int i=0;i<table.getRowCount();i++)
		{
			if((boolean) table.getValueAt(i, 0)==true)
			{
				v.add(table.getValueAt(i, colnum));
			}
		}
		return v;	
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
	 model.addRow(v);
	}
	
abstract	void mouseClickAction(int columnIndex,int rowIndex);

abstract	void mouseMoveAction(int columnIndex);
     
DefaultTableModel getmodel()
{
	return this.model;}

}
