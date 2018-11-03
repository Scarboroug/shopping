package com.chusai.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import java.util.Set;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.omg.CORBA.PUBLIC_MEMBER;


/***************************
 *@classname  Login.java
 *@author     
 *@date       2018年8月17日-上午10:46:33
 *@version     V1.0
 *@description

 ****************************/

public class Login {

	static JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	 String[] name={"123","456","789"};
	 String[] passeord={"123","456","789"};
	 
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("登陆");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 255);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账户：");
		lblNewLabel.setBounds(63, 86, 72, 29);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		
		
		
		JLabel label = new JLabel("密码：");
		label.setBounds(63, 128, 72, 29);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		panel.add(label);
		
		
		textField = new JTextField();
		textField.setBounds(149, 89, 189, 24);
		panel.add(textField);
		textField.setColumns(10);
		final String m=textField.getText().trim();
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 131, 189, 24);
		panel.add(passwordField);
		 final String n=new String(passwordField.getPassword());
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.setBounds(75, 196, 113, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register Register=new Register();
				Register.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登陆");
		btnNewButton_1.setBounds(235, 196, 113, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().trim().equals("")||new String(passwordField.getPassword()).equals("")) {
					
				}else {
					File file =new File("./people.xml");
					 SAXReader reader = new SAXReader();
						
						Document document = null;
						try {
							document = reader.read(file);
						} catch (DocumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						Element root = document.getRootElement();
						List<Element> rows = root.elements();
					for (Element row : rows) {
						Attribute attribute1 = row.attribute("number");
						Attribute attribute2 = row.attribute("pasword");
						String a=attribute1.getText();
						String b=attribute2.getText();
						if (textField.getText().trim().equals(a)&&new String(passwordField.getPassword()).equals(b)) {
							Client client=new Client();
							client.frame.setVisible(true);
							frame.setVisible(false);
						}
					}
				}
				
				
			}
		});
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("购物对比器");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 38));
		lblNewLabel_1.setBounds(115, 13, 210, 47);
		panel.add(lblNewLabel_1);
		
	}
	
}
