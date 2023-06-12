package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public void testTcpServer(int port) {
		ServerSocket ss = null;
		Socket sc = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter wr = null;
		try {
			ss = new ServerSocket(port);
			
			
			while(true) {
				System.out.println("접속 대기 중......");
				sc = ss.accept();
				System.out.println("접속됨:"+sc.getPort());
				
				in = sc.getInputStream();
				out = sc.getOutputStream();
				br = new BufferedReader(new InputStreamReader(in));
				wr = new BufferedWriter(new OutputStreamWriter(out));
				
				String receivedMsg = null;
				while((receivedMsg = br.readLine()) != null ) {
					System.out.println("받은메시지: "+ receivedMsg);
					wr.write(receivedMsg+":메시지 받음.\n");
					wr.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(wr!=null) wr.close();
				if(br!=null) br.close();
				if(out!=null) out.close();
				if(in!=null) in.close();
				if(sc!=null) sc.close();
				if(ss!=null) ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
