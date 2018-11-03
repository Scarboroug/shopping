package com.chusai.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.chusai.analy.Information;
import com.chusai.analy.Test;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Label;


/***************************
 *@classname  Client.java
 *@author     
 *@date       2018年8月17日-下午12:44:32
 *@version     V1.0
 *@description

 ****************************/

public class Client {

	 static JFrame frame;
	 private JTextField textField;
	 static String url=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
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
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("用户界面");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(600, 600, 900,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1.手机", "2.电脑", "3.电视","4.相机"}));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setBounds(392, 94, 284, 34);
		frame.getContentPane().add(comboBox);
		//String m=(String) comboBox.getSelectedItem();
		//final int n=comboBox.getSelectedIndex();
		//System.out.println(n);
		
		final TextArea textArea = new TextArea();
		textArea.setBounds(82, 174, 726, 267);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch (comboBox.getSelectedIndex()+1) {
				case 1:	
					try {
						url = "./phone/Data.xml";
						ArrayList<Information> list = Test.InputPhone(url);
						Iterator<Information> iterator = list.iterator();
						int i = 0;
						while (iterator.hasNext()) {
							
						textArea.append(i+":"+iterator.next().getTitle()+"\n");
						i++;
						}
						
					} catch (Exception e1) {	
					}
					break;
                case 2:
                 
					try {
						url= "./computer/Data.xml";
						ArrayList<Information> list = Test.InputPhone(url);
						Iterator<Information> iterator = list.iterator();
						int i = 0;
						while (iterator.hasNext()) {
							
						textArea.append(i+":"+iterator.next().getTitle()+"\n");
						i++;
						}
						
					} catch (Exception e1) {
						
					}
					
					break;
                case 3:
					try { 
						url= "./TV/Data.xml";
						ArrayList<Information> list = Test.InputPhone(url);
						Iterator<Information> iterator = list.iterator();
						int i = 0;
						while (iterator.hasNext()) {
							
						textArea.append(i+":"+iterator.next().getTitle()+"\n");
						i++;
						}
						
					} catch (Exception e1) {
				
					}
					
					break;

                case 4:     
					try {
						url= "./camera/Data.xml";
						ArrayList<Information> list = Test.InputPhone(url);
						Iterator<Information> iterator = list.iterator();
						int i = 0;
						while (iterator.hasNext()) {		
						textArea.append(i+":"+iterator.next().getTitle()+"\n");
						i++;
						}
						
					} catch (Exception e1) {
						
					}
					break;
				}
			
			}
		});
		btnNewButton.setBounds(737, 95, 72, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("欢迎使用XXX比价系统");
		lblNewJgoodiesLabel.setFont(new Font("华文琥珀", Font.PLAIN, 32));
		lblNewJgoodiesLabel.setForeground(Color.RED);
		lblNewJgoodiesLabel.setBounds(288, 13, 394, 57);
		frame.getContentPane().add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("请选择你要查询的类型：");
		lblNewJgoodiesLabel_1.setFont(new Font("隶书", Font.PLAIN, 22));
		lblNewJgoodiesLabel_1.setForeground(new Color(0, 0, 0));
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewJgoodiesLabel_1.setBounds(46, 93, 284, 34);
		frame.getContentPane().add(lblNewJgoodiesLabel_1);
		
		textField = new JTextField();
		textField.setBounds(368, 499, 107, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//String m=textField.getText().trim();
		
		final JButton btnNewButton_1 = new JButton("查询");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n = Integer.parseInt(textField.getText());
				try {
					
					ArrayList list = Test.Search(n, url);
					Iterator<Information> iterator = list.iterator();
					textArea.append("\n");
					textArea.append("\n");
					textArea.append("\n");
					while (iterator.hasNext()) {	
					
					textArea.append(iterator.next()+"\n");
					}
				} catch (Exception e1) {				
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton_1.setBounds(520, 500, 83, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JLabel lblNewLabel = new JLabel("请输入你要查询的编号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(96, 502, 208, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(658, 381, 72, 18);
		frame.getContentPane().add(label);
		
		
		
	}
}
