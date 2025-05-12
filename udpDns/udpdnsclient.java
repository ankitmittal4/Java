import java.io.*;
import java.net.*;

public class udpdnsclient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress serverAddress;
        if (args.length == 0) {
            serverAddress = InetAddress.getLocalHost();  // assume server on same machine
        } else {
            serverAddress = InetAddress.getByName(args[0]);
        }

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        System.out.print("Enter the hostname: ");
        String hostname = br.readLine();
        sendData = hostname.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 1362);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String response = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
        System.out.println("IP Address: " + response);

        clientSocket.close();
    }
}
