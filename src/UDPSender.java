import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPSender {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(); //내 소캣
			System.out.println("발신 시작");
			
			for(int i=1;i<3;i++) {
				String data = "메세지" + i;
				byte[] byteArr = data.getBytes("UTF-8");
				
				//데이터와 수신자 정보를 담고 있는 패킷 생성
				DatagramPacket packet = new DatagramPacket(byteArr, byteArr.length, new InetSocketAddress("localhost", 5001));
				
				datagramSocket.send(packet); //수신자에게 데이터 전달
				System.out.println("보낸 바이트 수 : "+ byteArr.length + "bytes");
			}
			
			System.out.println("발신 종료");
			
			datagramSocket.close();
		} catch (SocketException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
