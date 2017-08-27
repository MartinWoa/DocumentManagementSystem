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
import java.awt.Component;  


public class Login {
	private JComboBox SIBox;
	private JComboBox IBBox;
	private JScrollPane scrollPane_4 ;
	private JPanel panel_logined;
	private ProTable usertable;
	private JScrollPane taSearchScroll;
	private JScrollPane taSearchScroll2;
    private Users user;
    private JFrame frame;
    private CardLayout cl_panel_main;
    private JTextField textField_yh;
    private JTextField textField_name;
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
    private  JScrollPane scrollPane_1;
    private JMenuItem recommend;
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
   private JTextField asPhone;
   private JPasswordField passwordField_2;
   private JTextField asAdress;
    private JLabel accountLabel;
    private JTextField IMSearchFIeld;
    private JPanel panel_IM;
    private CardLayout clLogined;
    private JTextField reName;
    private JTextField staName;
    private String[] IBString={"步兵", "骑兵"};
    private String[] ISString1= {"东京步兵","海盗"};
    private String[] ISString2= {"北斗","都灵"};

    
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
            	rigonClear();
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
             rigonClear();


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
        
        IBBox = new JComboBox();
        IBBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(String.valueOf(IBBox.getSelectedItem()).equals("步兵")) { SIBox.setModel(new DefaultComboBoxModel(ISString1)); }
        		if(String.valueOf(IBBox.getSelectedItem()).equals("骑兵")) {  SIBox.setModel(new DefaultComboBoxModel(ISString2));}
        	}
        });
        IBBox.setModel(new DefaultComboBoxModel(IBString));
        IBBox.setBounds(281, 298, 193, 24);
        panel_regis.add(IBBox);
        
        SIBox = new JComboBox();
        SIBox.setModel(new DefaultComboBoxModel(ISString1));
        SIBox.setBounds(281, 328, 193, 24);
        panel_regis.add(SIBox);
        
        JComboBox sexBox = new JComboBox();
        sexBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
        sexBox.setBounds(284, 141, 193, 24);
        panel_regis.add(sexBox);
        
        JComboBox birthYearBox = new JComboBox();
        birthYearBox.setModel(new DefaultComboBoxModel(new String[] {"1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029"}));
        birthYearBox.setBounds(284, 174, 72, 21);
        panel_regis.add(birthYearBox);
        
        JComboBox birthMonthBox = new JComboBox();
        birthMonthBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
        birthMonthBox.setBounds(366, 174, 43, 21);
        panel_regis.add(birthMonthBox);
        
        JComboBox birthDateBox = new JComboBox();
        birthDateBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        birthDateBox.setBounds(417, 174, 57, 21);
        panel_regis.add(birthDateBox);

        panel_logined = new JPanel();//登陆后界面
        panel_main.add(panel_logined, "logined1");
        clLogined=   new CardLayout(0, 0);
        
     
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
		 * 规范编辑
		 * 
		 * 
		 */
        JPanel panel_Standard = new JPanel();
        panel_logined.add(panel_Standard, "standard");
        panel_Standard.setLayout(null);
        
        staName = new JTextField();
        staName.setBounds(34, 41, 246, 21);
        panel_Standard.add(staName);
        staName.setColumns(10);
        
        
        
        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(34, 84, 615, 371);
        panel_Standard.add(scrollPane_3);
        
        JTextArea staText = new JTextArea();
        scrollPane_3.setViewportView(staText);
        
        JLabel label_10 = new JLabel("规范名称");
        label_10.setBounds(34, 16, 54, 15);
        panel_Standard.add(label_10);
        
        JLabel label_11 = new JLabel("规范内容");
        label_11.setBounds(34, 60, 54, 15);
        panel_Standard.add(label_11);
        
        JButton staSend = new JButton("确定");
        staSend.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		if(staName.getText().equals("")||staText.getText().equals("")) {JOptionPane.showMessageDialog(null, "请输入规范名称和规范内容", "警告", JOptionPane.ERROR_MESSAGE);return;}
        	   Standard stan=new Standard();
        	   stan.setAuthor(user.getAccount());
        	   stan.setName(staName.getText());
        	   stan.setText(staText.getText());
        	   Standard.creatStandard(stan);
        	   JOptionPane.showMessageDialog(null, "规范上传成功", "成功", JOptionPane.INFORMATION_MESSAGE);
               staName.setText("");
               staText.setText("");
               clLogined.show(panel_logined, "nothing");
        			   	   
        	}
        });
        staSend.setBounds(556, 465, 93, 23);
        panel_Standard.add(staSend);
        
        JButton staCancel = new JButton("取消");
        staCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    staName.setText("");
                staText.setText("");
                clLogined.show(panel_logined, "nothing");
        	}
        });
        staCancel.setBounds(453, 465, 93, 23);
        panel_Standard.add(staCancel);
        
		
		
		
		
		
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
        		JTable proTable = new ProTable(v,null,null,null,user,0,1);
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
        
        asPhone = new JTextField();

        asPhone.setColumns(10);
        asPhone.setBounds(157, 163, 190, 24);
        panel_accountSet.add(asPhone);
        
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
        
        JComboBox asSexBox = new JComboBox();
        asSexBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
        asSexBox.setBounds(157, 129, 193, 24);
        panel_accountSet.add(asSexBox);
        
        JComboBox asDate = new JComboBox();
        asDate.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        asDate.setBounds(290, 200, 57, 21);
        panel_accountSet.add(asDate);
        
        JComboBox asYear = new JComboBox();
        asYear.setModel(new DefaultComboBoxModel(new String[] {"1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029"}));
        asYear.setBounds(157, 200, 72, 21);
        panel_accountSet.add(asYear);
        
        JComboBox asMonth = new JComboBox();
        asMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        asMonth.setBounds(239, 200, 43, 21);
        panel_accountSet.add(asMonth);
        
        

        
        
        
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
        * 会员推荐
        * 
        */

        JPanel panel_recommend = new JPanel();
        panel_logined.add(panel_recommend, "recommend");
        panel_recommend.setLayout(null);
        
        reName = new JTextField();
        reName.setBounds(73, 57, 149, 21);
        panel_recommend.add(reName);
        reName.setColumns(10);
        
        JTextArea reText = new JTextArea();
        reText.setWrapStyleWord(true);
        reText.setText(" ");
        reText.setLineWrap(true);
        reText.setBounds(0, 0, 622, 395);

        
        JScrollPane scrollPane_2 = new JScrollPane(reText);
        scrollPane_2.setBounds(73, 103, 548, 371);
        panel_recommend.add(scrollPane_2);
        
        JLabel reLabel = new JLabel("被推荐人即将使用账号：");
        reLabel.setBounds(73, 32, 204, 15);
        panel_recommend.add(reLabel);
        
        JLabel label_9 = new JLabel("推荐原因：");
        label_9.setBounds(73, 88, 204, 15);
        panel_recommend.add(label_9);
        
        JButton reSend = new JButton("提交");
        reSend.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		if(reName.getText().equals("")||reText.getText().equals("")) {  JOptionPane.showMessageDialog(null, "请填写被推荐人账号以及推荐原因", "信息不完整", JOptionPane.ERROR_MESSAGE); return;}
        	    Users.insertRecommend(reName.getText(), user.getName(), reText.getText());
        	    JOptionPane.showMessageDialog(null, "请通知被推荐人注册", "推荐成功", JOptionPane.INFORMATION_MESSAGE); 
        	    reName.setText("");
        	    reText.setText("");
        	}
        });
        
        reSend.setBounds(528, 495, 93, 23);
        panel_recommend.add(reSend);
        
        JButton reCancel = new JButton("取消");
        reCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		clLogined.show(panel_logined, "nothing");
        	}
        });
        reCancel.setBounds(425, 495, 93, 23);
        panel_recommend.add(reCancel);
        
        
        /*
         * 身份管理
         * 
         * 
         */
        
        
        panel_IM = new JPanel();
        panel_logined.add(panel_IM, "IM");
        panel_IM.setLayout(null);
        
        IMSearchFIeld = new JTextField();
        IMSearchFIeld.setBounds(44, 77, 252, 21);
        panel_IM.add(IMSearchFIeld);
        IMSearchFIeld.setColumns(10);
        
        JButton IMSearch = new JButton("搜索账号");

        IMSearch.setBounds(318, 76, 93, 23);
        panel_IM.add(IMSearch);
        
        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(44, 108, 624, 334);
		scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(44, 108, 624, 334);
        panel_IM.add(scrollPane_1);
        
        JButton IMAccept = new JButton("同意");

        IMAccept.setBounds(575, 452, 93, 23);
        panel_IM.add(IMAccept);
        
        IMAccept.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		Vector<String> checked=usertable.getChecked(1);
        		for(String account:checked)
        		{
        			
						Users u=Users.getImformation(account);
						u.setstate(true);
						u.updateuser(u);
					
        		}
        		getCheckAccount();
        		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        JButton IMRefuse = new JButton("拒绝");
        IMRefuse.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		try {
            		Vector<String> checked=usertable.getChecked(1);
            		for(String account:checked)
            		{
            			
    						Users u=Users.getImformation(account);
    						u.deleteUser(u);
    					
            		}
            		getCheckAccount();
            		} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
        		
        	}
        });
        IMRefuse.setBounds(454, 452, 93, 23);
        panel_IM.add(IMRefuse);
        
        IMSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(IMSearchFIeld.getText().equals(""))
        		{
        			getCheckAccount();
        			return;
        		}
        		try 
        		{
					Users u= Users.getImformation(IMSearchFIeld.getText());
					if(u!=null)
					{
						Vector v=new Vector();
						v.add(u);
						usertable = new ProTable(null,null,v,null,user,2,1);
						usertable.setVisible(true);
			            scrollPane_1.setViewportView(usertable);
						
					}
				} catch (SQLException e1) 
        		{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        /*
         * 
         * 
         * 
         * 
         * 规范搜索
         * 
         * 
         */
        JPanel panel_staSearch = new JPanel();
        panel_logined.add(panel_staSearch, "staSearch");
        panel_staSearch.setLayout(null);
        
        scrollPane_4 = new JScrollPane();
        scrollPane_4.setBounds(29, 93, 624, 334);
        panel_staSearch.add(scrollPane_4);
        /*
         * 
         * 
         * 菜单
         */
         JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        accounter = new JMenu("账户");
        menuBar.add(accounter);
        
       recommend = new JMenuItem("会员推荐");
        recommend.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clLogined.show(panel_logined,"recommend");
        	}
        });
        
        
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
        		if(user.getSex()) {asSexBox.setSelectedIndex(0);}else {asSexBox.setSelectedIndex(1);}
        		asAdress.setText(user.getAdress());
        		
        		  Calendar c = Calendar.getInstance();
        		  c.setTime(user.getbirthday());
        		  asYear.setSelectedIndex(c.get(Calendar.YEAR)-1949);
        		  asMonth.setSelectedIndex(c.get(Calendar.MONTH));
        		  asDate.setSelectedIndex(c.get(Calendar.DATE)-1);
        		clLogined.show(panel_logined,"accountSet");
        		check=1;
        	}
        });
        
        
        gfSearch = new JMenuItem("规范查询");
        gfSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProTable staTable;
        		clLogined.show(panel_logined,"staSearch");	
				try {
					staTable = new ProTable(null,null,null,Standard.getStandard(),user,3,1);
					staTable.setVisible(true);
					scrollPane_4.setViewportView(staTable);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        
        
        taEdit = new JMenuItem("提案编制");
        taEdit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Vector v;
        		try {
        			v = proposal.getProposalByAccount(user.getAccount());
        			ProTable table=new ProTable(v,null, null,null, user, 0, 1);
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
        		clLogined.show(panel_logined,"standard");

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
        		clLogined.show(panel_logined,"IM");     
                getCheckAccount();
        		
                
        	}
        });
        
        
       taCheck = new JMenu("提案审批");
        
        
        check1 = new JMenuItem("推荐（专委会）");
        check1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProCheckView pcv=new ProCheckView(user,0);
        		pcv.setVisible(true);
        	}
        });
        
        
        check2 = new JMenuItem("备案（行业分会）");
        check2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProCheckView pcv=new ProCheckView(user,1);
        		pcv.setVisible(true);
        	}
        });
        
        
        check3 = new JMenuItem("立案（研究会）");
        check3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProCheckView pcv=new ProCheckView(user,2);
        		pcv.setVisible(true);
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
                 if(String.valueOf(asSexBox.getSelectedItem()).equals("男"))
                	 {
                	     user.setSex(true) ;
                	 }
                	 else
                	 {
                		  user.setSex(false);
                	 }
         
    				try 
    				{       SimpleDateFormat formatter1=new SimpleDateFormat("yyyy/MM/dd");
					Date date = null;
					formatter1.setLenient(false);
					String d=String.valueOf(asYear.getSelectedItem())+"/"+String.valueOf(asMonth.getSelectedItem()+"/"+String.valueOf(asDate.getSelectedItem()));
					date = formatter1.parse( d );

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
             if(String.valueOf(sexBox.getSelectedItem()).equals("男"))
            	 {
            	     rigonUser.setSex(true) ;
            	 }
            	 else
            	 {
            		  rigonUser.setSex(false);
            	 }
               
				try 
				{
			        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy/MM/dd");
					Date date = null;
					String d=String.valueOf(birthYearBox.getSelectedItem())+"/"+String.valueOf(birthMonthBox.getSelectedItem())+"/"+String.valueOf(birthDateBox.getSelectedItem());
					date = formatter1.parse( d );
					rigonUser.setbirthday(date);
				}
				catch (ParseException e2) 
				{	
				}
				rigonUser.setReferees(textField_who.getText());
				rigonUser.setContact(Integer.parseInt(textField_phone.getText()));
                rigonUser.setIndustryBranch(String.valueOf(IBBox.getSelectedItem()));
                rigonUser.setseminar(false);
                rigonUser.setSpecialcommittee(String.valueOf(SIBox.getSelectedItem()));
                rigonUser.setstate(false);
                Users.rigon(rigonUser);
                rigonClear();
                cl_panel_main.show(panel_main,"denglu");
                JOptionPane.showMessageDialog(null, "注册成功请等待审核", "注册成功", JOptionPane.INFORMATION_MESSAGE); 
                check=0;
			}
        });
    
				
    }
    
    private void logincheck()
    {
    	 try {
				user=Users.getImformation(textField_yh.getText());
		
				if(user==null){loginWarning.setText("账号不存在或审核未通过"); return;}
				if(!user.getPassword().equals( String.valueOf(passwordField_1.getPassword()))) {loginWarning.setText("密码错误");return;}
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
          clLogined.show(panel_logined,"nothing");
    	  cl_panel_main.show(panel_main,"denglu");//注销事件
          frame.setTitle("能力规范文稿管理系统 ");
    }
    
    private void menuChange()
    {    accounter.add(recommend);
    	 accounter.add(cancel);
    	 accounter.add(accountSet);
         writing.add(gfSearch);
         writing.add(taEdit);
         writing.add(gfEdit);
        writing.add(taSearch);
        control.add(taCheck);
    	if(user.getadmin()) {control.add(IdentityManagement);}
    	if(user.getseminar()) {taCheck.add(check3);}
        taCheck.add(check2);
        taCheck.add(check1);
    	control.add(BeginMission);
    }
    void rigonClear()
    {
        textField_name.setText(null);
        textField_address.setText(null);
        textField_phone.setText(null);
        textField_who.setText(null);
        passwordField.setText(null);
        textField_yh2.setText(null);
    	
    	
    }
    void getCheckAccount()
    {
		try {
			Admin admin=(Admin) user;
			
			usertable = new ProTable(null,null,admin.getUserByCheck(),null,user,2,1);
			usertable.setVisible(true);
            scrollPane_1.setViewportView(usertable);
            
            
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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


