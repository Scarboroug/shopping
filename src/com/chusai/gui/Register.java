package com.chusai.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;






import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

//import com.sun.xml.internal.bind.v2.runtime.Name;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/***************************
 *@classname  Register.java
 *@author     
 *@date       2018年8月17日-下午3:37:04
 *@version     V1.0
 *@description

 ****************************/

public class Register {

	 JFrame frame;
	 private JTextField textField_1;
	 private JPasswordField passwordField;
	 private JPasswordField passwordField_1;
	 private JTextField textField_2;
	 private JTextField textField_3;
	
	
	 
	 

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws IOException, DocumentException {
		
		File file =new File("./people.xml");
		if(!file.exists()){
			file.createNewFile();
			FileWriter fileWriter=new FileWriter(file);
			fileWriter.write("<?xml version=\"1.1\"?>");
			fileWriter.write("<root/>");
			fileWriter.close();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(68, 74, 72, 18);
		panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(68, 105, 72, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("确认密码：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(68, 136, 82, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("手机号：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(68, 167, 72, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("邮箱：");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(68, 198, 72, 18);
		panel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 71, 132, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		final String m=textField_1.getText().trim();//账号
		
		passwordField = new JPasswordField();
		passwordField.setBounds(219, 102, 132, 24);
		panel.add(passwordField);
		final String n=new String(passwordField.getPassword());
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(219, 133, 132, 24);
		panel.add(passwordField_1);
		final String n1=new String(passwordField_1.getPassword());
		
		textField_2 = new JTextField();
		textField_2.setBounds(219, 164, 132, 24);
		panel.add(textField_2);
		textField_2.setColumns(10);
		final String m1=textField_2.getText().trim();
		
		textField_3 = new JTextField();
		textField_3.setBounds(219, 195, 132, 24);
		panel.add(textField_3);
		textField_3.setColumns(10);
		final String m2=textField_3.getText().trim();
		System.out.println(m2);
		
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				Element newRow=root.addElement("row");
				newRow.addAttribute("number", textField_1.getText().trim());
				newRow.addAttribute("pasword", new String(passwordField.getPassword()));
				newRow.addAttribute("pasword2", new String(passwordField_1.getPassword()));
				newRow.addAttribute("phone", textField_2.getText().trim());
				newRow.addAttribute("mailbox", textField_3.getText().trim());
				OutputFormat format = OutputFormat.createPrettyPrint();
				format.setEncoding("UTF-8");
				FileWriter writer;
				try {
					writer = new FileWriter(file);
					XMLWriter xmlwriter=new XMLWriter(writer, format);
					xmlwriter.write(document);
					xmlwriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}if (textField_1.getText().trim().equals("")||textField_2.getText().trim().equals("")||textField_3.getText().trim().equals("")) {
				}else {
					if (new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))) {
						Login Login=new Login();
						Login.frame.setVisible(true);
						frame.setVisible(false);
					}
				}
				  
			}
		});
		btnNewButton.setBounds(301, 243, 113, 27);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login Login=new Login();
				Login.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		btnNewButton_1.setBounds(86, 243, 113, 27);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("出塞系统让你生活无忧");
		lblNewLabel_5.setFont(new Font("华文中宋", Font.PLAIN, 28));
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(85, 13, 309, 40);
		panel.add(lblNewLabel_5);
	}
	
}
