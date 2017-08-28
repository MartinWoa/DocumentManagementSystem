package System;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProCheckView extends JFrame implements Receiver{
	ProCheckView p=this;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private int checkModel;
    private ProTable protable;
    Admin admin;
    Users user;
	/**
	 * Create the frame.
	 */
	public ProCheckView(Users user,int checkModel) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ProBC.remove(p);
			}
		});
		ProBC.regist(p);
		this.user=user;
		this.checkModel=checkModel;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1006, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	       contentPane.setLayout(null);
		   admin=new Admin();
		   
		   try {
			    protable=new ProTable(admin.getProposalByCheck(checkModel),user,0,1);
		        scrollPane = new JScrollPane();
		        scrollPane.setViewportView(protable);
		        scrollPane.setSize(980, 272);
		        scrollPane.setLocation(10, 83);
		        contentPane.add(scrollPane);
		        JButton button = new JButton("");
		
		        switch(checkModel)
		        {
		        case 0:button.setText("推荐");break;
		        case 1:button.setText("备案");break;
		        case 2:	button.setText("立案");break;
		        }
		        button.setBounds(10, 365, 93, 23);
		        contentPane.add(button);
		        button.addActionListener(new ActionListener() 
		        {
		        	public void actionPerformed(ActionEvent arg0) 
		        	{
		        		try {
		        		Vector v=protable.getChecked(1);
		        		for(Object i:v)
		        		{
		        			
								proposal p=proposal.getProposalById((int) i);
								switch(checkModel)
								{
								case 0:p.setState(1); break;
								case 1:p.setState(2);break;
								case 2:p.setState(3);break;
								}
								proposal.proUpdate(p);

		        		}
		        		
		        		} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        });
		        
			
		} catch (SQLException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		try {
			protable=new ProTable(admin.getProposalByCheck(checkModel),user,0,1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(protable);
	}
}
