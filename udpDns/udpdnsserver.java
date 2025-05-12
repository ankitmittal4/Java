import java.io.*;
import java.net.*;

public class udpdnsserver {
    private static int indexOf(String[] array, String str) {
        str = str.trim();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        String[] hosts = {"yahoo.com", "gmail.com", "cricinfo.com", "facebook.com"};
        String[] ip = {"68.180.206.184", "209.85.148.19", "80.168.92.140", "69.63.189.16"};
        DatagramSocket serversocket = new DatagramSocket(1362);
        System.out.println("DNS Server is running on port 1362...");

        byte[] receiveData = new byte[1024];
        byte[] sendData;

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serversocket.receive(receivePacket);
            String domain = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();

            System.out.println("Received request for host: " + domain);
            String response;
            int index = indexOf(hosts, domain);
            if (index != -1) {
                response = ip[index];
            } else {
                response = "Host Not Found";
            }

            sendData = response.getBytes();
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serversocket.send(sendPacket);
        }
    }
}
