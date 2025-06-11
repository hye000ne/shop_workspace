package com.sinse.networkapp.echo;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

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
	Socket socket; // 대화용 소켓 이 객체를 메모리에 올릴 때 젒속이 발생함, 또한 접속이 성공되면 그 시점부터 연결이 이루어진 것이므로 스트림을 통해 데이터를 주고 받을 수 있음
	
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
		
		setBounds(100, 100, 300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void connect() {
		String ip = (String)box_ip.getSelectedItem();
		
		try {
			socket = new Socket(ip, Integer.parseInt(t_port.getText()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createIp() {
		for(int i=15;i<=30;i++) {
			box_ip.addItem("192.168.60."+i);
		}
	}
	public static void main(String[] args) {
		new EchoClient();
	}

}