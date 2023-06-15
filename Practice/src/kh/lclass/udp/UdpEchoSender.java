package kh.lclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpEchoSender {

	public static void main(String[] args) {
		new UdpEchoSender().senderUdp();
	}

	public void senderUdp() {
		//1.내 포트번호정하기
		int myPort = 5001;
		int destPort = 6001;
		DatagramSocket DS = null;
		String destName = "localhost";
		
		//2. DatagramSocket 객체 생성
		try {
			DS = new DatagramSocket(myPort);
			
			
			InetAddress destIp = null;
			try {
			//3.연결한 Client ip주소를 가진 InetAddress 객체생성
			destIp = InetAddress.getByName(destName)
			}catch(UnknownHostException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			//4.전송할 메시지를 byte로 바꿈
			byte[] byteMsg = new byte[1000];
			
			//5. 전송할 메시지를 DatagramPacket 객체에 담음
			DatagramPacket receivedData = new DatagramPacket(byteMsg, byteMsg.length);
			
			//6. 소켓 레퍼런스를 사용하여 메시지 전송
			DS.receive(receivedData);
			System.out.println(byteMsg.length);
			
		} catch (SocketException e) {
			e.printStackTrace();
		}finally {
			//소켓닫음
			if(DS != null) DS.close();
		}
		
	}
















}
