package System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class StaView extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane3;

	/**
	 * Create the frame.
	 */
	public StaView(Standard stan) {
		this.setVisible(true);
		this.setTitle(stan.getName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 999, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel staName = new JLabel("");
		staName.setFont(new Font("宋体", Font.PLAIN, 19));

		staName.setBounds(53, 31, 184, 36);
		contentPane.add(staName);
		 staName.setText(stan.getName());
		JLabel staAu = new JLabel("");
		staAu.setBounds(339, 42, 242, 15);
		
		contentPane.add(staAu);
		staAu.setText(stan.getAuthor());
		  
	       scrollPane3 = new JScrollPane();
	        scrollPane3.setSize(794, 336);
	        scrollPane3.setLocation(53, 108);
	        contentPane.add(scrollPane3);
	        
	        JTextArea staText = new JTextArea();
	        staText.setWrapStyleWord(true);
	        staText.setLineWrap(true);
	        staText.setEditable(false);
	        staText.setText(stan.getText());
	        scrollPane3.setViewportView(staText);
	}
}
