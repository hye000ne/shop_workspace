package com.sinse.threadApp.ani;

import javax.swing.JProgressBar;

public class ThreadP extends Thread{
	int speed = 0;
	boolean flag = true;
	JProgressBar bar;
	
	public ThreadP(JProgressBar bar, int speed) {
		this.bar = bar;
		this.speed = speed;
	}
	
	public void run() {
		while(flag) {
			try {
				speed+=1;
				bar.setValue(speed);
				Thread.sleep(100);
				
				if(speed > 100) flag = !flag;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
