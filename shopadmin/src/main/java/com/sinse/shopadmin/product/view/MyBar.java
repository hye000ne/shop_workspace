package com.sinse.shopadmin.product.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

// API 자체적으로 지원해주는 진행바는 너무 단순하므로, 우리가 원하는 스타일의 바로 커스텀
// Runnable 인터페이스란 run() 추상메서드를 보유한 인터페이스
public class MyBar extends JProgressBar implements Runnable {
	
	FileInputStream fis; //파일을 대상으로 한 바이트 기반의 입력스트림
	FileOutputStream fos; //파일을 대상으로 한 바이트 기반의 출력스트림
	File origin;
	File dest;
	
	int n = 0;
	
	public MyBar(File origin, File dest) {
		this.origin = origin;
		this.dest = dest;
		
		try {
			fis = new FileInputStream(origin); // 원본 파일을 대상으로 스트림 생성
			fos = new FileOutputStream(dest); //파일이 복사될 대상에 출력 스트림 생성
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		setPreferredSize(new Dimension(680,50));
		setBorder(new TitledBorder("지난해 단합대회.png ----> 124832.png"));
		
		//진행바 중앙에 텍스트 띄우기
		setStringPainted(true);
		setFont(new Font("Verdana", Font.BOLD, 17));
		setForeground(Color.BLUE); // 바 색상
	}
	// 진행율을 표시하는 메서드
	public void showRate(int v) {
		// 읽어들인 양 / 총용량 *100
		n+=v;
		this.setValue((int)(n*100/origin.length()));
	}

	public void copySlow() {
		int data = -1;
		while(true) {
			try {
				data = fis.read(); //1byte 읽기
				if(data == -1) break;
				showRate(++n);
				fos.write(data); //1byte 쓰기
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public void copyFast() {
		byte[] buff = new byte[1024];
		int read = 0;
		try {
			// 버퍼가 1024의 용량을 갖더라도 컴퓨터 상황(네트워크,os상황, 디스크 등등)
			// 이유로 인해 반드시 1024개를 다 모이지 않을 경우도 있으므로, 
			while(true) {
				read = fis.read(buff);
				if(read == -1) break;
				fos.write(buff, 0, read);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				showRate(read);
			}
			release();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 파일에 생성된 스트림을 읽고 출력
	public void run() {
		copySlow();
		//copyFast();
		release();
	}
	
	public void release() {
		if(fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(fis != null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}