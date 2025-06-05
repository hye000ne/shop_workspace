package com.sinse.threadApp.ani;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameAni extends JFrame {
	JPanel p_center;
	Image imgArray[] = new Image[18];
	int idx = 0;
	Thread thread;
	
	public FrameAni() {
		createImage();
		
		p_center = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgArray[idx], 100, 100, 200, 213, p_center);
			}
		};
		
		thread = new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
						idx++;
						if(idx>=imgArray.length) idx = 1;
						p_center.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		thread.start(); //jvm에게 runnable 상태로의 진입을 부탁 -> jvm은 os에게 native 쓰레드 생성을 요청
		
		add(p_center);
		setSize(500,500);
		setVisible(true);
	}
	
	public void createImage() {
		for(int i=1;i<=18;i++) { 
			URL url = this.getClass().getClassLoader().getResource("images/hero/image"+i+".png");
			try {
				BufferedImage buffrImg = ImageIO.read(url);
				Image img = buffrImg.getScaledInstance(200, 213, Image.SCALE_SMOOTH);
				imgArray[i-1] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new FrameAni();
	}

}
