package com.sinse.networkapp.echo.bak;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoClient extends JFrame{
	JPanel p_north;
	JComboBox box_ip;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	
	public EchoClient() {
		p_north = new JPanel();
		box_ip = new JComboBox();
		t_port = new JTextField("9999",8);
		bt = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField();
		
		createIp();
		
		
		p_north.add(box_ip);
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		add(t_input, BorderLayout.SOUTH);
		
		setBounds(2000, 100, 300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void createIp() {
		for(int i=15;i<=30;i++) {
			box_ip.addItem("192.168.60"+i);
		}
	}
	public static void main(String[] args) {
		new EchoClient();
	}

}