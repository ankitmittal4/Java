import java.io.*;
import java.net.*;

public class UDPEchoClient {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket CliSoc = new DatagramSocket();
        InetAddress IPAddr;
        String Text;

        //Add comment
        if (args.length == 0)
            IPAddr = InetAddress.getLocalHost();
        else
            IPAddr = InetAddress.getByName(args[0]);

        byte[] SData = new byte[1024];
        System.out.println("To quit, press enter without text");

        while (true) {
            System.out.print("\nEnter text for Server : ");
            Text = br.readLine();
            SData = Text.getBytes();
            DatagramPacket SPack = new DatagramPacket(SData, SData.length, IPAddr, 7777);
            CliSoc.send(SPack);

            if (Text.trim().length() == 0)
                break;

            byte[] RData = new byte[1024];
            DatagramPacket RPack = new DatagramPacket(RData, RData.length);
            CliSoc.receive(RPack);
            String Echo = new String(RPack.getData()).trim();
            System.out.println("Echo from Server <<< " + Echo);
        }

        CliSoc.close();
    }
}
