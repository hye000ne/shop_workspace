package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamStudy {
	String path = "C:/public/data.txt";
	
	// 바이트 기반의 스트림으로 읽기, 1byte씩 처리하는 스트림
	public void readByte() {
		FileInputStream fis = null;
		// 바이트 기반 스트림을 이용하여, 문서 파일을 읽고 그 내용을 출력(영문 O / 한글 깨짐)ㄴ
		try {
			fis = new FileInputStream(path);
			
			while(true) {
				int data = -1;
				data = fis.read(); //1byte 읽기
				if(data == -1) break;
				
				System.out.print((char)data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// 문자 기반의 스트림으로 읽기
	public void readReader() {
		FileInputStream fis = null;
		InputStreamReader reader = null;
		
		try {
			fis = new FileInputStream(path);
			reader = new InputStreamReader(fis);
			
			//주의) 문자기반 스트림은 데이터를 읽어들일 때 1byte씩 문자를 읽어들임
			//한글이 깨지지 않는다고 해서 2byte씩 읽어들이는게 아니라 2byte씩 묶어서 문자로 해석할 수 있는 것.
			int data = 0;
			data = reader.read();System.out.println((char)data);
			data = reader.read();System.out.println((char)data);
			data = reader.read();System.out.println((char)data);
			data = reader.read();System.out.println((char)data);
			data = reader.read();System.out.println((char)data);
			data = reader.read();System.out.println((char)data);
			/*
			 * while(true) { int data = reader.read(); }
			 */
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// 버퍼 기반의 스트림으로 읽기
	public void readBuffer() {
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader buffr = null; // 한글이 깾지 않으면서 줄바꿈 문자 만날때까지 읽지 않고 버퍼에 문자를 저장
		String data = null;
		try {
			fis = new FileInputStream(path);
			reader = new InputStreamReader(fis);
			buffr = new BufferedReader(reader);
			while(true) {
				data = buffr.readLine();
				if(data == null) break;
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(buffr != null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		StreamStudy ss = new StreamStudy();
		//ss.readByte();
		//ss.readReader();
		ss.readBuffer();
	}
}
