package System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProTextView extends JFrame {

	private JPanel contentPane;
     private Users user;
     private proposal pro;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
     private  JScrollPane scrollPane3;
	public ProTextView(Users user,proposal pro) {
		this.user=user;
		this.pro=pro;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 993, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("提案ID");
		lblid.setBounds(10, 10, 54, 15);
		contentPane.add(lblid);
		
		JLabel label = new JLabel("提案作者");
		label.setBounds(10, 36, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("提案名称");
		label_1.setBounds(395, 10, 54, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("截止日期");
		lblNewLabel.setBounds(395, 36, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel taID = new JLabel(String.valueOf(pro.getID()));
		taID.setBounds(74, 10, 289, 15);
		contentPane.add(taID);
		
		JLabel taathour = new JLabel(pro.getAuthor());
		taathour.setBounds(74, 36, 275, 15);
		contentPane.add(taathour);
		
		JLabel taName = new JLabel(pro.getName());
		taName.setBounds(459, 10, 245, 15);
		contentPane.add(taName);
		
		JLabel taDate = new JLabel(pro.getDate().toString());
		taDate.setBounds(459, 36, 245, 15);
		contentPane.add(taDate);
		
		JLabel lblNewLabel_5 = new JLabel("提案内容");
		lblNewLabel_5.setBounds(10, 82, 54, 15);
		contentPane.add(lblNewLabel_5);
		
        JTextArea taInput = new JTextArea();
      
        taInput.setEditable(false);
        taInput.setWrapStyleWord(true);
        taInput.setLineWrap(true);
        taInput.setText(pro.getText());
        JScrollPane scrollPane = new JScrollPane(taInput);
        scrollPane.setSize(847, 292);
        scrollPane.setLocation(74, 82);
        contentPane.add(scrollPane);
        
        JTextArea taInput2 = new JTextArea();
        taInput2.setWrapStyleWord(true);
        taInput2.setLineWrap(true);
        JScrollPane scrollPane2 = new JScrollPane(taInput2);
        scrollPane2.setSize(847, 89);
        scrollPane2.setLocation(74, 423);
        contentPane.add(scrollPane2);
        
        JLabel label_2 = new JLabel("评论");
        label_2.setBounds(10, 428, 54, 15);
        contentPane.add(label_2);
        
        //加载评价
        
        try {
			Vector<Comment> coms=pro.getComment();
			JTable com=new CommentTable(coms,user, 1,-1);
			
	       scrollPane3 = new JScrollPane();
	       scrollPane3.setViewportView(com);
	        scrollPane3.setSize(847, 121);
	        scrollPane3.setLocation(74, 551);
	        contentPane.add(scrollPane3);
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        

        ButtonGroup radionGroup=new ButtonGroup();
        
        JRadioButton support = new JRadioButton("赞成");
        support.setBounds(74, 394, 121, 23);
        contentPane.add(support);
        
        JRadioButton against = new JRadioButton("反对");
        against.setBounds(198, 394, 121, 23);
        contentPane.add(against);
        radionGroup.add(against);
        radionGroup.add(support);
        
        JButton commentSend = new JButton("提交");
        commentSend.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		if(!support.isSelected()&&!against.isSelected()&&taInput2.getText().equals(""))
        		{
            		JOptionPane.showMessageDialog(null, "请选择态度以及输入评论内容", "错误", JOptionPane.ERROR_MESSAGE); 
            		return;
        		}
        		Comment com=new Comment();
        		com.setproid(pro.getID());
        		com.setcomment(taInput2.getText());
        		com.setCommenter(user.getAccount());
        		com.setsupport(support.isSelected());
        		Date date=new Date();
        		com.setTime(date);
        		Comment.CreatComment(com);
                try {
        			Vector<Comment> coms=pro.getComment();
        			JTable comss=new CommentTable(coms,user, 1,-1);
        			scrollPane3.setViewportView(comss);
        	    
        		} catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	
        	}
        });
        commentSend.setBounds(836, 518, 93, 23);
        contentPane.add(commentSend);
	}
	
	
}
