import java.net.DatagramSocket;

public class Main {
    public static void main(String[] args) {
UdpClient udpClient = new UdpClient();
udpClient.sendAndReceiveMessage();
    }
}