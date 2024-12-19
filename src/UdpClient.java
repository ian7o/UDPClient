import java.io.IOException;
import java.net.*;

public class UdpClient {
    public void sendAndReceiveMessage() {
        try {
            // abri um socket
            DatagramSocket clientSocket = new DatagramSocket();
            //Fiz uma mensagem e transfomei em bytes para o computador ler

            String message = "fala ze";
            byte[] mensageToBuffer = message.getBytes();
            // agora estou fazendo o meu pacote para poder enviar

            DatagramPacket sendPacket = new DatagramPacket(
                    mensageToBuffer,
                    mensageToBuffer.length,
                    InetAddress.getByName("127.0.0.1"), 9987);
            //enviei a mensagem

            clientSocket.send(sendPacket);
            //e fechei aqui temporariamente enquanto tento enviar uma mensagem depois apago
            clientSocket.close();

            /*
            agora vou receber um buffer que vai ser parecido

             */
//            byte[] reciveBuffer = new byte[1024];
//            DatagramPacket receivedPacket = new DatagramPacket(reciveBuffer,reciveBuffer.length);
//
//            clientSocket.receive(receivedPacket);
//
//            String serverMessage = new String(receivedPacket.getData());
//
//            System.out.println(serverMessage);
////clientSocket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}