package kh.lclass.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoReceiver {

	public static void main(String[] args) {
		new UdpEchoReceiver().receiverUdp();
	}
	public void receiverUdp() {
		//1. 서버가 보낸 메시지를 받을 byte[] 준비
		// - 포트넘버
		int myPort = 6001;
		
		//2.DatagramSocket 객체 생성
		DatagramSocket DS = null;
		try {
			DS = new DatagramSocket(myPort);
			//3. 메시지 받을 DatagramPacket 객체 준비
			byte[] byteMsg = new byte[1000];
			DatagramPacket receiveData = new DatagramPacket(byteMsg, myPort, null);
	
			//4. byte[]로 받은 메시지를 String으로 바꾸어 출력	
			String receiveStr = new String(receiveData.getData());
			
			
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

}
