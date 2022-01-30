import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {
	public static void main(String[] args) throws InterruptedException {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(5001); //바인딩할 포트 번호 입력
			
			Thread th = new Thread() {
				public void run() {
					System.out.println("수신 시작");
					
					while(true) {
						try {
							DatagramPacket packet = new DatagramPacket(new byte[100], 100); //패킷의 내용을 저장할 패킷 객체
							datagramSocket.receive(packet); //소캣을 통해 패킷을 받음. 여기서 블록 상태가 됨
							
							//receive의 블록 상태가 풀리면 패킷에 담긴 데이터를 가져와서 String 객체에 매개값으로 넣음
							String data = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
							System.out.println("[받은 내용 : "+ packet.getSocketAddress()+"] " + data);
						} catch (IOException e) { 
							System.out.println("수신 종료");
						}
					}
				};
			};
			
			th.start();
			Thread.sleep(10000);
			datagramSocket.close(); //닫음
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
