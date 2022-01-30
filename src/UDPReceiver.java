import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {
	public static void main(String[] args) throws InterruptedException {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(5001); //���ε��� ��Ʈ ��ȣ �Է�
			
			Thread th = new Thread() {
				public void run() {
					System.out.println("���� ����");
					
					while(true) {
						try {
							DatagramPacket packet = new DatagramPacket(new byte[100], 100); //��Ŷ�� ������ ������ ��Ŷ ��ü
							datagramSocket.receive(packet); //��Ĺ�� ���� ��Ŷ�� ����. ���⼭ ��� ���°� ��
							
							//receive�� ��� ���°� Ǯ���� ��Ŷ�� ��� �����͸� �����ͼ� String ��ü�� �Ű������� ����
							String data = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
							System.out.println("[���� ���� : "+ packet.getSocketAddress()+"] " + data);
						} catch (IOException e) { 
							System.out.println("���� ����");
						}
					}
				};
			};
			
			th.start();
			Thread.sleep(10000);
			datagramSocket.close(); //����
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
