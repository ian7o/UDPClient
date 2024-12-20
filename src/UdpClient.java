import java.io.IOException;
import java.net.*;

public class UdpClient {
    public void sendAndReceiveMessage() {
        try {
            // abri um socket
            DatagramSocket clientSocket = new DatagramSocket();
            //Fiz uma mensagem e transfomei em bytes para o computador ler
            String message = "Bom dia";
            byte[] mensageToBuffer = message.getBytes();
            // agora estou fazendo o meu pacote para poder enviar

            DatagramPacket sendPacket = new DatagramPacket(
                    mensageToBuffer,
                    mensageToBuffer.length,
                    InetAddress.getByName("127.0.0.1"), 9987);
            //enviei a mensagem
            clientSocket.send(sendPacket);

            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            while (true) {
                clientSocket.receive(receivePacket);
                // converti o pacote recebido em string para poder ler
                String messageReceived = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(messageReceived);
                // tentei fechar o pacote
                break;
            }
            clientSocket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}