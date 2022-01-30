import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPSender {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(); //�� ��Ĺ
			System.out.println("�߽� ����");
			
			for(int i=1;i<3;i++) {
				String data = "�޼���" + i;
				byte[] byteArr = data.getBytes("UTF-8");
				
				//�����Ϳ� ������ ������ ��� �ִ� ��Ŷ ����
				DatagramPacket packet = new DatagramPacket(byteArr, byteArr.length, new InetSocketAddress("localhost", 5001));
				
				datagramSocket.send(packet); //�����ڿ��� ������ ����
				System.out.println("���� ����Ʈ �� : "+ byteArr.length + "bytes");
			}
			
			System.out.println("�߽� ����");
			
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
