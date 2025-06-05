package com.sinse.threadApp.ani;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 사각형을 이동시켜보자(지우고 그리고 지우고 그리고)
public class RectMove extends JFrame{
	JButton bt;
	JPanel p_north;
	JPanel p_center;
	int x = 0;
	int y = 0;
	Thread thread;
	
	public RectMove() {
		bt = new JButton("동작");
		p_north = new JPanel();
		p_center = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				g.setColor(Color.BLUE);
				g.fillRect(x, y, 50, 50);
			}
		};
		
		thread = new Thread() {
			// 개발자는 쓰레드로 구현하고 싶은 코드를 run 메서드 안에 넣어두어야한다.
			public void run() {
				while(true) {
					move();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		
		setSize(800,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move() {
		x++;
		y++;
		
		p_center.repaint();
	}
	
	public static void main(String[] args) {
		new RectMove();
	}

}
