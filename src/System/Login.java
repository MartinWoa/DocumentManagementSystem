package System;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;  


public class Login {
	private JScrollPane taSearchScroll;
	private JScrollPane taSearchScroll2;
    private Users user;
    private JFrame frame;
    private CardLayout cl_panel_main;
    private JTextField textField_yh;
    private JTextField textField_name;
    private JTextField textField_sex;
    private JTextField textField_birth;
    private JTextField textField_address;
    private JTextField textField_phone;
    private JTextField textField_who;
    protected int check=0;
    private JLabel loginWarning ;
    private JMenu writing;
    private JMenuItem accountSet;
    private JMenuItem gfSearch;
    private JMenuItem taEdit;
    private JMenuItem gfEdit;
    private JMenuItem taSearch;
    private JMenu control;
    private JMenuItem IdentityManagement;
    private JMenu taCheck;
    private JMenuItem check1;
    private JMenuItem check2;
    private JMenuItem check3;
    private JMenuItem BeginMission;
    private JMenu accounter;
    private JMenuItem cancel;
    public static void main(String[] args) {  
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Login() {
        initialize();
    }
    private JTextField textField_yh2;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
   private JPanel panel_main;
   private JTextField taTitle;
   private JTextField taSearchFiled;
   private JTextField asName;
   private JTextField asSex;
   private JTextField asPhone;
   private JTextField asBirthDay;
   private JPasswordField passwordField_2;
   private JTextField asAdress;
    private JLabel accountLabel;
    private void initialize() {
    	
        frame = new JFrame("能力规范文稿管理系统");//主界面
        frame.setBounds(100, 100, 717, 715);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        panel_main = new JPanel();//登录界面
        panel_main.setBounds(0, 0, 691, 609);
        frame.getContentPane().add(panel_main);
        cl_panel_main= new CardLayout(0, 0);
        panel_main.setLayout(cl_panel_main);

        JPanel panel_denglu = new JPanel();       //登录子界面
        panel_main.add(panel_denglu, "denglu");
        panel_denglu.setLayout(null);

        JLabel label_yh = new JLabel("用户名");//提示信息
        label_yh.setBounds(14, 13, 72, 18);
        panel_denglu.add(label_yh);

        JLabel label_mi = new JLabel("密码");//提示信息
        label_mi.setBounds(219, 13, 51, 18);
        panel_denglu.add(label_mi);

        textField_yh = new JTextField();//用户输入框
        textField_yh.setBounds(79, 10, 86, 24);
        panel_denglu.add(textField_yh);
        textField_yh.setColumns(10);

        JButton button_login = new JButton("登录");//登录子界面登录按钮
        button_login.setForeground(Color.WHITE);
        button_login.setBackground(Color.GRAY);
        button_login.setBounds(403, 9, 72, 27);
        panel_denglu.add(button_login);

        JButton button_reg = new JButton("注册");//登录子界面注册按钮
        button_reg.setForeground(Color.WHITE);
        button_reg.setBackground(Color.GRAY);
        button_reg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl_panel_main.show(panel_main,"regis");//注册后转到入会申请界面
            }
        });
        button_reg.setBounds(494, 9, 72, 27);
        panel_denglu.add(button_reg);
        
        
        
        passwordField_1 = new JPasswordField();
    
        passwordField_1.setColumns(10);
        passwordField_1.setBounds(252, 10, 104, 24);
        panel_denglu.add(passwordField_1);
        
        loginWarning = new JLabel("");
        loginWarning.setForeground(Color.RED);
        loginWarning.setBounds(10, 66, 260, 18);
        panel_denglu.add(loginWarning);
        
        
        
        /*
         * 
         * 注册
         * 
         */
        JPanel panel_regis = new JPanel();//入会申请界面
        panel_regis.setToolTipText("");
        panel_main.add(panel_regis, "regis");
        panel_regis.setLayout(null);

        JLabel label_yh2 = new JLabel("用户名");//信息
        label_yh2.setBounds(121, 51, 72, 18);
        panel_regis.add(label_yh2);

        JLabel label_mi2 = new JLabel("密码");
        label_mi2.setBounds(121, 82, 72, 18);
        panel_regis.add(label_mi2);

        JLabel label_name = new JLabel("姓名");
        label_name.setBounds(121, 113, 72, 18);
        panel_regis.add(label_name);

        JLabel label_sex = new JLabel("性别");
        label_sex.setBounds(121, 144, 72, 18);
        panel_regis.add(label_sex);

        JLabel label_birth = new JLabel("出生日期");
        label_birth.setBounds(121, 175, 72, 18);
        panel_regis.add(label_birth);

        JLabel label_address = new JLabel("家庭住址");
        label_address.setBounds(121, 206, 72, 18);
        panel_regis.add(label_address);

        JLabel label_phone = new JLabel("联系方式");
        label_phone.setBounds(121, 237, 72, 18);
        panel_regis.add(label_phone);

        JLabel label_who = new JLabel("推荐人");
        label_who.setBounds(121, 268, 72, 18);
        panel_regis.add(label_who);

        JLabel label_part1 = new JLabel("行业分会");
        label_part1.setBounds(121, 299, 72, 18);
        panel_regis.add(label_part1);

        JLabel label_part2 = new JLabel("专委会");
        label_part2.setBounds(121, 329, 72, 18);
        panel_regis.add(label_part2);

        textField_yh2 = new JTextField();//入会申请 用户输入框
       
        textField_yh2.setBounds(284, 44, 190, 24);
        panel_regis.add(textField_yh2);
        textField_yh2.setColumns(10);

        passwordField = new JPasswordField();//入会申请 密码输入框

        passwordField.setBounds(284, 79, 190, 24);
        panel_regis.add(passwordField);

        textField_name = new JTextField();//入会申请 姓名输入框

        textField_name.setBounds(284, 107, 190, 24);
        panel_regis.add(textField_name);
        textField_name.setColumns(10);

        textField_sex = new JTextField();//入会申请 性别输入框
        textField_sex.setBounds(284, 138, 190, 24);
        panel_regis.add(textField_sex);
        textField_sex.setColumns(10);

        textField_birth = new JTextField();//入会申请 生日输入框
         
        textField_birth.setBounds(284, 169, 190, 24);
        panel_regis.add(textField_birth);
        textField_birth.setColumns(10);

        textField_address = new JTextField();//入会申请 住址输入框
        textField_address.setBounds(284, 200, 190, 24);
        panel_regis.add(textField_address);
        textField_address.setColumns(10);

        textField_phone = new JTextField();//入会申请 电话输入框
  
        textField_phone.setBounds(284, 231, 190, 24);
        panel_regis.add(textField_phone);
        textField_phone.setColumns(10);
        
        textField_who = new JTextField();//入会申请 推荐人输入框
        textField_who.setBounds(284, 262, 190, 24);
        panel_regis.add(textField_who);
        textField_who.setColumns(10);
         
        JButton Button_tijiao = new JButton("提交");//入会申请 提交按钮
        Button_tijiao.setForeground(Color.WHITE);
        Button_tijiao.setBackground(Color.GRAY);
        Button_tijiao.setBounds(59, 430, 113, 27);
        panel_regis.add(Button_tijiao);

        JButton Button_quxiao = new JButton("取消");//入会申请 取消按钮
        Button_quxiao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl_panel_main.show(panel_main,"denglu");//取消事件
                check=0;
            }
        });
        Button_quxiao.setBackground(Color.GRAY);
        Button_quxiao.setForeground(Color.WHITE);
        Button_quxiao.setBounds(250, 430, 113, 27);
        panel_regis.add(Button_quxiao);

        JButton Button_qingkong = new JButton("清空");//入会申请 清空按钮
        Button_qingkong.setForeground(Color.WHITE);
        Button_qingkong.setBackground(Color.GRAY);
        Button_qingkong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //清空事件
                textField_name.setText(null);
                textField_sex.setText(null);
                textField_birth.setText(null);
                textField_address.setText(null);
                textField_phone.setText(null);
                textField_who.setText(null);
                passwordField.setText(null);
                textField_yh2.setText(null);


            }
        });
        Button_qingkong.setBounds(417, 430, 113, 27);
        panel_regis.add(Button_qingkong);

        JPanel panel_shenqing = new JPanel();//标题背景
        panel_shenqing.setForeground(new Color(0, 0, 0));
        panel_shenqing.setToolTipText("aaaaa");
        panel_shenqing.setBackground(new Color(255, 250, 205));
        panel_shenqing.setBounds(0, 0, 691, 31);
        panel_regis.add(panel_shenqing);

        JLabel label_shenqing = new JLabel("入会申请");//标题
        label_shenqing.setForeground(new Color(0, 0, 0));
        panel_shenqing.add(label_shenqing);
        
        JLabel yhWarn = new JLabel("");
        yhWarn.setForeground(Color.RED);
        yhWarn.setBounds(484, 42, 183, 24);
        panel_regis.add(yhWarn);
        
        JLabel birthWarn = new JLabel("");
        birthWarn.setForeground(Color.RED);
        birthWarn.setBounds(484, 169, 183, 37);
        panel_regis.add(birthWarn);
        
        JLabel label = new JLabel("研究会");
        label.setBounds(121, 365, 54, 15);
        panel_regis.add(label);
        
        JLabel miWarn = new JLabel("");
        miWarn.setForeground(Color.RED);
        miWarn.setBounds(484, 79, 183, 24);
        panel_regis.add(miWarn);
        
        JLabel nameWarn = new JLabel("");
        nameWarn.setForeground(Color.RED);
        nameWarn.setBounds(484, 107, 183, 24);
        panel_regis.add(nameWarn);
        
        JLabel sexWarn = new JLabel("");
        sexWarn.setForeground(Color.RED);
        sexWarn.setBounds(484, 138, 183, 24);
        panel_regis.add(sexWarn);
        
        JLabel phoneWarn = new JLabel("");
        phoneWarn.setForeground(Color.RED);
        phoneWarn.setBounds(484, 231, 183, 24);
        panel_regis.add(phoneWarn);
        
        JRadioButton IndustryBranch = new JRadioButton("");
        IndustryBranch.setBounds(284, 297, 121, 23);
        panel_regis.add(IndustryBranch);
        
        JRadioButton Specialcommittee = new JRadioButton("");
        Specialcommittee.setBounds(284, 327, 121, 23);
        panel_regis.add(Specialcommittee);
        
        JRadioButton seminar = new JRadioButton("");
        seminar.setBounds(284, 361, 121, 23);
        panel_regis.add(seminar);

        JPanel panel_logined = new JPanel();//登陆后界面
        panel_main.add(panel_logined, "logined1");
        CardLayout clLogined=   new CardLayout(0, 0);
        
     
        panel_logined.setLayout(clLogined);
        
        JPanel panel_nothing = new JPanel();
        panel_logined.add(panel_nothing, "nothing");
         
		Vector v;
		try {
			v = proposal.getProposalByAccount("admin");
    			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        /*
         * 
         * 提案搜索
         */
        JPanel panel_Search = new JPanel();
        panel_logined.add(panel_Search, "taSearcher");
        panel_Search.setLayout(null);        
        taSearchFiled = new JTextField();
        taSearchFiled.setBounds(129, 43, 300, 26);
        panel_Search.add(taSearchFiled);
        taSearchFiled.setColumns(10);
        //提案搜索事件
        JButton taSearchButton = new JButton("搜索");
        taSearchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Vector<proposal> v=new Vector<proposal>();
        		if(taSearchFiled.getText().equals("")) {JOptionPane.showMessageDialog(null, "请输入编号或者账号", "警告", JOptionPane.ERROR_MESSAGE);return; }
        		try {
        		if(isNumeric(taSearchFiled.getText()))
        		{
					v.add(proposal.getProposalById(Integer.parseInt(taSearchFiled.getText())));
				    
        		}
        		else
        		{   
        			v=proposal.getProposalByAccount(taSearchFiled.getText());
        			
        		}
        		if(v.isEmpty()) {JOptionPane.showMessageDialog(null, "未找到结果", "警告", JOptionPane.ERROR_MESSAGE);return;}
        		if(v.get(0).getID()==0) {JOptionPane.showMessageDialog(null, "未找到结果", "警告", JOptionPane.ERROR_MESSAGE);return;}
        		JTable proTable = new ProTable(v,null,null,user,0,1);
                taSearchScroll2 = new JScrollPane(proTable); 
                
                taSearchScroll2.setLocation(48, 153);
                taSearchScroll2.setSize(615, 456);
                panel_Search.add(taSearchScroll2);
        		} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        taSearchButton.setBounds(474, 44, 93, 23);
        panel_Search.add(taSearchButton);
        
        JLabel label_2 = new JLabel("请输入提案编号或者提案作者账号");
        label_2.setForeground(Color.LIGHT_GRAY);
        label_2.setBounds(129, 79, 300, 26);
        panel_Search.add(label_2);
		/*
		 * 
		 * 
		 * 信息维护
		 */
        
        
        
        JPanel panel_accountSet = new JPanel();
        panel_logined.add(panel_accountSet, "accountSet");
        panel_accountSet.setLayout(null);
        
        accountLabel = new JLabel("");
        accountLabel.setBounds(157, 37, 162, 15);
        panel_accountSet.add(accountLabel);
        
        asName = new JTextField();

        asName.setColumns(10);
        asName.setBounds(157, 95, 190, 24);
        panel_accountSet.add(asName);
        
        asSex = new JTextField();

        asSex.setColumns(10);
        asSex.setBounds(157, 129, 190, 24);
        panel_accountSet.add(asSex);
        
        asPhone = new JTextField();

        asPhone.setColumns(10);
        asPhone.setBounds(157, 163, 190, 24);
        panel_accountSet.add(asPhone);
        
        asBirthDay = new JTextField();

        asBirthDay.setColumns(10);
        asBirthDay.setBounds(157, 197, 190, 24);
        panel_accountSet.add(asBirthDay);
        
        passwordField_2 = new JPasswordField();
        passwordField_2.setBounds(157, 61, 190, 24);
        panel_accountSet.add(passwordField_2);
        
        asAdress = new JTextField();
        asAdress.setColumns(10);
        asAdress.setBounds(157, 231, 190, 24);
        panel_accountSet.add(asAdress);
        
        JButton asCancel = new JButton("取消");
        asCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		check=0;
        		passwordField_2.setText("");
        		clLogined.show(panel_logined,"nothing");
        	}
        });
        asCancel.setBounds(157, 295, 93, 23);
        panel_accountSet.add(asCancel);
        
        JButton asConfirm = new JButton("确定");

        asConfirm.setBounds(254, 295, 93, 23);
        panel_accountSet.add(asConfirm);
        
        JLabel asNameWarn = new JLabel("");
        asNameWarn.setForeground(Color.RED);
        asNameWarn.setBounds(357, 99, 278, 20);
        panel_accountSet.add(asNameWarn);
        
        JLabel asSexWarn = new JLabel("");
        asSexWarn.setForeground(Color.RED);
        asSexWarn.setBounds(357, 133, 278, 20);
        panel_accountSet.add(asSexWarn);
        
        JLabel asPhoneWarn = new JLabel("");
        asPhoneWarn.setForeground(Color.RED);
        asPhoneWarn.setBounds(357, 167, 278, 20);
        panel_accountSet.add(asPhoneWarn);
        
        JLabel asBirthWarn = new JLabel("");
        asBirthWarn.setForeground(Color.RED);
        asBirthWarn.setBounds(357, 201, 278, 20);
        panel_accountSet.add(asBirthWarn);
        
        JLabel label_3 = new JLabel("地址");
        label_3.setBounds(63, 235, 54, 20);
        panel_accountSet.add(label_3);
        
        JLabel label_4 = new JLabel("生日");
        label_4.setBounds(63, 201, 54, 20);
        panel_accountSet.add(label_4);
        
        JLabel label_5 = new JLabel("联系方式");
        label_5.setBounds(63, 167, 54, 20);
        panel_accountSet.add(label_5);
        
        JLabel label_6 = new JLabel("性别");
        label_6.setBounds(63, 133, 54, 20);
        panel_accountSet.add(label_6);
        
        JLabel label_7 = new JLabel("姓名");
        label_7.setBounds(63, 95, 54, 20);
        panel_accountSet.add(label_7);
        
        JLabel label_8 = new JLabel("密码");
        label_8.setBounds(63, 65, 54, 20);
        panel_accountSet.add(label_8);
        
        /*
         * 
         * 
         * 提案编辑
         */
        

        
        JPanel panel_taEdit = new JPanel();
        panel_logined.add(panel_taEdit, "taEdit");
        panel_taEdit.setLayout(null);
        JTextArea taInput = new JTextArea();
        taInput.setWrapStyleWord(true);
        taInput.setLineWrap(true);
        taInput.setText(" ");
        JScrollPane scrollPane = new JScrollPane(taInput);
        scrollPane.setSize(624, 397);
        scrollPane.setLocation(48, 79);
        panel_taEdit.add(scrollPane);
        taSearchScroll = new JScrollPane(); 
        
        taSearchScroll.setLocation(48, 519);
        taSearchScroll.setSize(615, 90);
        panel_taEdit.add(taSearchScroll);
        
          
        taTitle = new JTextField();
        taTitle.setBounds(48, 36, 213, 21);
        panel_taEdit.add(taTitle);
        taTitle.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("提案名称：");
        lblNewLabel.setBounds(48, 10, 91, 15);
        panel_taEdit.add(lblNewLabel);
        
        JLabel label_1 = new JLabel("提案内容：");
        label_1.setBounds(48, 57, 91, 15);
        panel_taEdit.add(label_1);
        
        JButton btnNewButton = new JButton("打印");
        btnNewButton.setBounds(373, 486, 93, 23);
        panel_taEdit.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("保存");
        btnNewButton_1.setBounds(476, 486, 93, 23);
        panel_taEdit.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("提交");
    
        btnNewButton_2.setBounds(579, 486, 93, 23);
        panel_taEdit.add(btnNewButton_2);
        
        JRadioButton taIsRead = new JRadioButton("我已阅读");
        taIsRead.setBounds(48, 486, 91, 23);
        panel_taEdit.add(taIsRead);
        
        JLabel lblNewLabel_1 = new JLabel("提案建议要求");
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setBounds(141, 490, 120, 15);
        panel_taEdit.add(lblNewLabel_1);
        
        JLabel taWarn = new JLabel("");
        taWarn.setForeground(Color.RED);
        taWarn.setBounds(282, 39, 287, 15);
        panel_taEdit.add(taWarn);
        
        
        //提案编辑事件
        
        btnNewButton_2.addActionListener(new ActionListener() {  //TODO:这里还没有做完超出三个未审核的就不能提交
        	public void actionPerformed(ActionEvent arg0)
        	{
        		if(taTitle.getText().equals("")||taInput.getText().equals("")||!taIsRead.isSelected())
        		{
        			taWarn.setText("标题和正文不可留空,且确定已阅读提案建议要求");
        			return;
        		}
        		proposal pro=new proposal();
        		pro.setAuthor(user.getAccount());
        		pro.setName(taTitle.getText());
        		pro.setText(taInput.getText());
        		pro.setState(0);
        		Date d=new Date();
        		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
                int year = c.get(Calendar.YEAR); 
        		int month = c.get(Calendar.MONTH); 
        		int date = c.get(Calendar.DATE)+5; 
        		
        		String time=year+"/"+month+"/"+date;
        		try {
					pro.setDate(dateFormat.parse(time));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		proposal.creatNewPro(pro);
        		JOptionPane.showMessageDialog(null, "提交成功请等待审核", "提交成功", JOptionPane.INFORMATION_MESSAGE); 
        		clLogined.show(panel_logined,"nothing");	
        		
        	}
        });
       
        
        /*
         * 
         * 
         * 菜单
         */
         JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        accounter = new JMenu("账户");
        menuBar.add(accounter);
        
        cancel = new JMenuItem("注销");
        cancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		cancel();
        	}
        });
       
        
        writing = new JMenu("写者");
        menuBar.add(writing);
        
        accountSet = new JMenuItem("信息维护");
        accountSet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		accountLabel.setText(user.getAccount());
        		asName.setText(user.getName());
        		asPhone.setText(String.valueOf(user.getContact()));
        		asSex.setText(user.getSexInString());
        		asAdress.setText(user.getAdress());
        		asBirthDay.setText(user.getbirthday().toString());
        		clLogined.show(panel_logined,"accountSet");
        		check=1;
        	}
        });
        
        
        gfSearch = new JMenuItem("规范查询");
        gfSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        
        taEdit = new JMenuItem("提案编制");
        taEdit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Vector v;
				try {
					v = proposal.getProposalByAccount(user.getAccount());
					ProTable table=new ProTable(v,null, null, user, 0, 1);
					table.setVisible(true);
	        		taSearchScroll.setViewportView(table);
	        		clLogined.show(panel_logined,"taEdit");	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		
        	}
        });
        
        
        gfEdit = new JMenuItem("规范编辑");
        gfEdit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	}
        });
        
        
        taSearch = new JMenuItem("提案查询");
        taSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		clLogined.show(panel_logined,"taSearcher");
        	}
        });
        
        

        control = new JMenu("管理");
        menuBar.add(control);
        
        IdentityManagement = new JMenuItem("身份管理");
        IdentityManagement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        
       taCheck = new JMenu("提案审批");
        
        
        check1 = new JMenuItem("推荐（专委会）");
        check1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        
        check2 = new JMenuItem("备案（行业分会）");
        check2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        
        check3 = new JMenuItem("立案（研究会）");
        check3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        
        BeginMission = new JMenuItem("启动任务");
        BeginMission.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        
        JMenu set = new JMenu("设置");
        menuBar.add(set);
        
        JMenuItem SQLSet = new JMenuItem("服务器设置");
        set.add(SQLSet);
        /*
         * 信息维护检查
         * 
         * 
         */
        asName.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent arg0) 
        	{
        		if(asName.getText().equals(""))
            	{
            		check=0;
            		asNameWarn.setText("名字不能为空");
            	}
            	else
            	{
            		if(!asNameWarn.getText().equals("")&&check==0) {check=1;}
            		asNameWarn.setText("");
            	}	
        	}
        });
        asSex.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) 
        	{
        		if(asSex.getText().equals("男")||asSex.getText().equals("女"))
            	{
            		if(!asSexWarn.getText().equals("")&&check==0)
            		{
            			check=1;
            		}
            		asSexWarn.setText("");
            	}
            	else
            	{
            		check=0;
            		asSexWarn.setText("请输入男或女");
            	}
        		
        		
        	}
        });
        asPhone.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if(!isNumeric(asPhone.getText()))
             	{
             		check=0;
             		asPhoneWarn.setText("请正确输入联系号码");
             	}
             	else
             	{   if(!asPhoneWarn.getText().equals("")&&check==0) {check=1;}
             	    asPhoneWarn.setText("");
             	}
        	}
        });
        
        asBirthDay.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		 SimpleDateFormat formatter1=new SimpleDateFormat("yyyyHHdd");
 				Date date = null;
 				try {
 					date = formatter1.parse( asBirthDay.getText() );
 					
 				} catch (ParseException e1) {
 					check=0;
 					asBirthWarn.setText("<html>生日输入错误，<br>请按照格式yyyyHHdd输入<html>");
 					return;
 				}
 				if(!asBirthWarn.getText().equals("")&&check==0) 
 				{
 					check=1;
 				}
 				asBirthWarn.setText("");
        	}
        });
        
        
        asConfirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		 if(check==0)
                 {
                	 JOptionPane.showMessageDialog(null, "请完善信息", "警告", JOptionPane.ERROR_MESSAGE); 
                	 return;
                 }
                
                 
                if(passwordField_2.getPassword().length!=0) {user.setpassword(passwordField_2.getPassword());}
                 
                 user.setName(asName.getText());
                 user.setAdress(asAdress.getText());
                 if(asSex.getText().equals("男"))
                	 {
                	     user.setSex(true) ;
                	 }
                	 else
                	 {
                		  user.setSex(false);
                	 }
         
    				try 
    				{
    			        SimpleDateFormat formatter1=new SimpleDateFormat("yyyyHHdd");
    					Date date = null;
    					date = formatter1.parse( asBirthDay.getText() );
    					user.setbirthday(date);
    				}
    				catch (ParseException e2) 
    				{	
    				}
    	
    				user.setContact(Integer.parseInt(asPhone.getText()));

                    Users.updateuser(user);
                    JOptionPane.showMessageDialog(null, "信息更新成功", "成功", JOptionPane.INFORMATION_MESSAGE); 
                    check=1;
    			    
        	}
        });
        /*
         * 
         * 
         * 注册检测
         * 
         * 
         * 
         * 
         */
        button_login.addActionListener(new ActionListener() {  //登陆检查
            public void actionPerformed(ActionEvent arg0) {
            	logincheck();
            }
        });
        passwordField_1.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) 
        	{
        	 if(e.getKeyCode()==10)
        	 {
        		 logincheck();
        	 }
        	}
        });
        textField_yh2.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent arg0) {
        		if(textField_yh2.getText().equals(""))
            	{
            	yhWarn.setText("账号不能为空");
            	check=0;
            	return;
            	}
            	else
            	{
            		if(!yhWarn.getText().equals("")&&check==0) 
    				{
    					check=1;
    				}
            		yhWarn.setText("");
            	}
        	try {
				if(Users.isexist(textField_yh2.getText())) {yhWarn.setText("账户已存在，请重新输入");check=0;}
				else
				{
					if(!yhWarn.getText().equals("")&&check==0)
					{   yhWarn.setText("");
						check=1;
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}  
        	}
        });
        textField_name.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e)
        	{
        	if(textField_name.getText().equals(""))
        	{
        		check=0;
        		nameWarn.setText("名字不能为空");
        	}
        	else
        	{
        		if(!nameWarn.getText().equals("")&&check==0) {check=1;}
        		nameWarn.setText("");
        	}
        	}
        });
        textField_birth.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent arg0) {
        		 SimpleDateFormat formatter1=new SimpleDateFormat("yyyyHHdd");
				Date date = null;
				try {
					date = formatter1.parse( textField_birth.getText() );
					
				} catch (ParseException e) {
					check=0;
					birthWarn.setText("<html>生日输入错误，<br>请按照格式yyyyHHdd输入<html>");
					return;
				}
				if(!birthWarn.getText().equals("")&&check==0) 
				{
					check=1;
				}
				birthWarn.setText("");
        	}
        });
        textField_phone.addFocusListener(new FocusAdapter() {
        	public void focusLost(FocusEvent e) 
        	{    if(!isNumeric(textField_phone.getText()))
        	{
        		check=0;
        		phoneWarn.setText("请正确输入联系号码");
        	}
        	else
        	{   if(!phoneWarn.getText().equals("")&&check==0) {check=1;}
        		phoneWarn.setText("");
        		if(phoneWarn.getText().equals("")&&miWarn.getText().equals("")&&yhWarn.getText().equals("")&&nameWarn.getText().equals("")&&sexWarn.getText().equals(""))
        		{
        			check=1;
        		}
        	}
        	}
        });
        passwordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) 
        	{
       
        	if(passwordField.getPassword().length==0)
        	{
        	miWarn.setText("密码不能为空");
        	check=0;
        	}
        	else
        	{
        		if(!miWarn.getText().equals("")&&check==0) 
				{
					check=1;
				}
        		miWarn.setText("");
        	}
        	}
        });
        
        textField_sex.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent arg0) 
        	{
        	if(textField_sex.getText().equals("男")||textField_sex.getText().equals("女"))
        	{
        		if(!sexWarn.getText().equals("")&&check==0)
        		{
        			check=1;
        		}
        		sexWarn.setText("");
        	}
        	else
        	{
        		check=0;
        		sexWarn.setText("请输入男或女");
        	}
        	}
        });
        
      //用户注册提交申请
         
        Button_tijiao.addActionListener(new ActionListener() {  
        	 
			public void actionPerformed(ActionEvent e) 
			{//判定提交事件
             if(check==0)
             {
            	 JOptionPane.showMessageDialog(null, "账号注册未完成", "警告", JOptionPane.ERROR_MESSAGE); 
            	 return;
             }
             Writer rigonUser =new Writer();
             rigonUser.setAccount(textField_yh2.getText());
             rigonUser.setadmin(false);
             rigonUser.setpassword(passwordField.getPassword());
             rigonUser.setName(textField_name.getText());
             rigonUser.setAdress(textField_address.getText());
             if(textField_sex.getText().equals("男"))
            	 {
            	     rigonUser.setSex(true) ;
            	 }
            	 else
            	 {
            		  rigonUser.setSex(false);
            	 }
     
				try 
				{
			        SimpleDateFormat formatter1=new SimpleDateFormat("yyyyHHdd");
					Date date = null;
					date = formatter1.parse( textField_birth.getText() );
					rigonUser.setbirthday(date);
				}
				catch (ParseException e2) 
				{	
				}
				rigonUser.setReferees(textField_who.getText());
				rigonUser.setContact(Integer.parseInt(textField_phone.getText()));
                rigonUser.setIndustryBranch(IndustryBranch.isSelected());
                rigonUser.setseminar(seminar.isSelected());
                rigonUser.setSpecialcommittee(Specialcommittee.isSelected());
                rigonUser.setstate(false);
                Users.rigon(rigonUser);
                cl_panel_main.show(panel_main,"denglu");
                JOptionPane.showMessageDialog(null, "注册成功请等待审核", "注册成功", JOptionPane.INFORMATION_MESSAGE); 
                check=0;
			}
        });
    
				
    }
    
    private void logincheck()
    {
    	 try {
				user=Users.getImformation(textField_yh.getText(), passwordField_1.getPassword());
				if(user==null){loginWarning.setText("账号不存在或者密码错误"); return;}
				if(!user.getstate()) {loginWarning.setText("账号正在审核 请等待审核结束"); return;}
				menuChange();
				frame.setTitle("能力规范文稿管理系统       欢迎您，"+user.getName());
			    cl_panel_main.show(panel_main,"logined1");//转入主界面
			    loginWarning.setText("");
			    textField_yh.setText("");
			    passwordField_1.setText("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    
    private void cancel()
    {     accounter.removeAll();
          writing.removeAll();
          control.removeAll();
          
    	  cl_panel_main.show(panel_main,"denglu");//注销事件
          frame.setTitle("能力规范文稿管理系统 ");
    }
    
    private void menuChange()
    { 
    	 accounter.add(cancel);
    	 accounter.add(accountSet);
         writing.add(gfSearch);
         writing.add(taEdit);
         writing.add(gfEdit);
        writing.add(taSearch);
    	if(user.getadmin()) {control.add(IdentityManagement);}
    	if(user.getseminar()) {taCheck.add(check3);}
    	if(user.getIndustryBranch()) {taCheck.add(check2);}
    	if(user.getSpecialcommittee()) {taCheck.add(check1);}
    	control.add(BeginMission);
    }
    
    
    public boolean isNumeric(String str){
    	  if(str.length()==0) {return false;}
    	  for (int i = 0; i < str.length(); i++){
    	   if (!Character.isDigit(str.charAt(i))){
    	    return false;
    	   }
    	  }
    	  return true;
    	 }
}


