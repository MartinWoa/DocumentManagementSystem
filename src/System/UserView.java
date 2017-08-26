package System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class UserView extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UserView(Users user) {
		this.setVisible(true);
        this.setTitle(user.getName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 892, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("申请人：");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(10, 10, 60, 27);
		contentPane.add(label);
		
		JLabel name = new JLabel("");
		name.setFont(new Font("宋体", Font.PLAIN, 15));
		name.setBounds(80, 10, 243, 27);
		contentPane.add(name);
		
		JLabel account = new JLabel("");
		account.setFont(new Font("宋体", Font.PLAIN, 15));
		account.setBounds(80, 47, 243, 27);
		contentPane.add(account);
		
		JLabel label_3 = new JLabel("账号");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(10, 47, 60, 27);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("性别");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(10, 84, 60, 27);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("出生日期");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(10, 121, 60, 27);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("联系方式");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(10, 158, 60, 27);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("家庭住址");
		label_7.setFont(new Font("宋体", Font.PLAIN, 15));
		label_7.setBounds(10, 195, 60, 27);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("专委会");
		label_8.setFont(new Font("宋体", Font.PLAIN, 15));
		label_8.setBounds(10, 269, 60, 27);
		contentPane.add(label_8);
		
		JLabel label_10 = new JLabel("行业分会");
		label_10.setFont(new Font("宋体", Font.PLAIN, 15));
		label_10.setBounds(10, 232, 60, 27);
		contentPane.add(label_10);
		
		JLabel sex = new JLabel("");
		sex.setFont(new Font("宋体", Font.PLAIN, 15));
		sex.setBounds(80, 90, 243, 27);
		contentPane.add(sex);
		
		JLabel birth = new JLabel("");
		birth.setFont(new Font("宋体", Font.PLAIN, 15));
		birth.setBounds(80, 127, 243, 27);
		contentPane.add(birth);
		
		JLabel phone = new JLabel("");
		phone.setFont(new Font("宋体", Font.PLAIN, 15));
		phone.setBounds(80, 164, 243, 27);
		contentPane.add(phone);
		
		JLabel address = new JLabel("");
		address.setFont(new Font("宋体", Font.PLAIN, 15));
		address.setBounds(80, 201, 243, 27);
		contentPane.add(address);
		
		JLabel label_15 = new JLabel("推荐人");
		label_15.setFont(new Font("宋体", Font.PLAIN, 15));
		label_15.setBounds(569, 16, 60, 27);
		contentPane.add(label_15);
		
		JLabel tName = new JLabel("");
		tName.setFont(new Font("宋体", Font.PLAIN, 15));
		tName.setBounds(633, 16, 243, 27);
		contentPane.add(tName);
		
		JLabel label_17 = new JLabel("账号");
		label_17.setFont(new Font("宋体", Font.PLAIN, 15));
		label_17.setBounds(569, 47, 60, 27);
		contentPane.add(label_17);
		
		JLabel tAccount = new JLabel("");
		tAccount.setFont(new Font("宋体", Font.PLAIN, 15));
		tAccount.setBounds(633, 47, 243, 27);
		contentPane.add(tAccount);
		
		JLabel label_19 = new JLabel("性别");
		label_19.setFont(new Font("宋体", Font.PLAIN, 15));
		label_19.setBounds(569, 90, 60, 27);
		contentPane.add(label_19);
		
		JLabel tSex = new JLabel("");
		tSex.setFont(new Font("宋体", Font.PLAIN, 15));
		tSex.setBounds(633, 90, 243, 27);
		contentPane.add(tSex);
		
		JLabel label_21 = new JLabel("出生日期");
		label_21.setFont(new Font("宋体", Font.PLAIN, 15));
		label_21.setBounds(569, 127, 60, 27);
		contentPane.add(label_21);
		
		JLabel tBirth = new JLabel("");
		tBirth.setFont(new Font("宋体", Font.PLAIN, 15));
		tBirth.setBounds(633, 127, 243, 27);
		contentPane.add(tBirth);
		
		JLabel label_23 = new JLabel("联系方式");
		label_23.setFont(new Font("宋体", Font.PLAIN, 15));
		label_23.setBounds(569, 158, 60, 27);
		contentPane.add(label_23);
		
		JLabel tPhone = new JLabel("");
		tPhone.setFont(new Font("宋体", Font.PLAIN, 15));
		tPhone.setBounds(633, 164, 243, 27);
		contentPane.add(tPhone);
		
		JLabel label_25 = new JLabel("推荐原因");
		label_25.setFont(new Font("宋体", Font.PLAIN, 15));
		label_25.setBounds(569, 201, 60, 27);
		contentPane.add(label_25);
		
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setSize(236, 284);
        scrollPane.setLocation(630, 201);
        contentPane.add(scrollPane);
        
        JTextArea reasonText = new JTextArea();
        reasonText.setEditable(false);
        scrollPane.setViewportView(reasonText);
        
        name.setText(user.getName());
        sex.setText(user.getSexInString());
        account.setText(user.getAccount());
        birth.setText(user.getbirthday().toString());
        phone.setText(String.valueOf(user.getContact()));
        address.setText(user.getAdress());
        
        JLabel SI = new JLabel((String) null);
        SI.setFont(new Font("宋体", Font.PLAIN, 15));
        SI.setBounds(80, 269, 243, 27);
        contentPane.add(SI);
        SI.setText(user.getSpecialcommittee());
        JLabel IB = new JLabel((String) null);
        IB.setFont(new Font("宋体", Font.PLAIN, 15));
        IB.setBounds(80, 232, 243, 27);
        IB.setText(user.getIndustryBranch());
        contentPane.add(IB);
        if(!user.getReferees().equals(""))
        {
        	try {
				Users referees=Users.getImformation(user.getReferees());
				String reason=user.checkreferees();
				if(referees!=null&&reason!=null)
				{   
					tName.setText(referees.getName());
					tSex.setText(referees.getSexInString());
					tAccount.setText(referees.getAccount());
					tPhone.setText(String.valueOf(referees.getContact()));
					reasonText.setText(reason);
					tBirth.setText(referees.getbirthday().toString());
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        
        
	}
}
