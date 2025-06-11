package chat.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//개발자가 네트워크에 대한 지식이 없어도, 네트워크 연동 프로그램을 작성할 수 있도록 지원해주는 객체 => Socket
//개발자는 네트워크에 대한 직접 연동을 하지 않고, Socket을 통해서 스트림을 얻어와 결국 스트림 제어만 하면 됨
//ip: 192.168.60.41
//1) 에코서버와 클라이언트 모델
//2) 유니캐스팅 모델
//3) 멀티캐스팅 모델
public class EchoGUIServer extends JFrame implements Runnable{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	ServerSocket server; //대화용 소켓이 아니라 접속자를 감지하고 접속이 감지되면 대화용 소켓을 반환
	Thread thread; //Runnable은 쓰레드가 아니므로 Runnalbe을 구현한다고 하여, 이 객체가 쓰레드형이라고 오해하면 안됨 따라서 별도의 Thread 객체를 사용해야 함 
	
	
	//클라이언트와 대화를 위한 스트림 준비
	BufferedReader buffr; // 듣기용
	BufferedWriter buffw; // 말하기용
	
	public EchoGUIServer() {
		p_north = new JPanel();
		t_port = new JTextField(8);
		bt = new JButton("서버 가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		area.setBackground(Color.YELLOW);
		
		// 버튼에 리스너 연결
		bt.addActionListener(e->{
			thread = new Thread(EchoGUIServer.this);
			thread.start();
		});
		
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
	
		setBounds(100, 100, 300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void run() {
		startServer();
	}
	
	public void startServer() {
		try {
			server = new ServerSocket(Integer.parseInt(t_port.getText()));
			area.append("서버 객체 생성 및 사용자 접속 청취 중...\n");
			
			Socket socket = server.accept();
			String ip = socket.getInetAddress().getHostAddress();
			area.append(ip + "님 접속\n");
			
			// 얻어진 소켓으로부터 스트림 두 개 뽑자
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// 클라이언트가 보낸 메시지 듣기
			while(true) {
				String msg = buffr.readLine();
				area.append(msg+"\n"); //server에 로그 남기기
				buffw.write(msg+"\n"); // buffer 기반이라서 \n이 없으면 끝을 몰라서 무한대기됨
				buffw.flush();
			}
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 우리가 알고있던 실행부는 프로그램 운영 쓰레드 -> 역할 : 이벤트 감지, GUI 구성, 관리
	 */
	public static void main(String[] args) {
		new EchoGUIServer();
	}
	
}
