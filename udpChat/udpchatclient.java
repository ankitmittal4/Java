import java.io.*;
import java.net.*;

public class udpchatclient {
    public static int clientport = 8040, serverport = 8050;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket CliSoc = new DatagramSocket(serverport);

        InetAddress IPAddr;
        if (args.length == 0)
            IPAddr = InetAddress.getLocalHost();
        else
            IPAddr = InetAddress.getByName(args[0]);

        byte[] SData;
        System.out.println("Press Enter without text to quit");

        while (true) {
            System.out.print("\nEnter text for server: ");
            String Text = br.readLine();
            SData = Text.getBytes();

            DatagramPacket SPack = new DatagramPacket(SData, SData.length, IPAddr, clientport);
            CliSoc.send(SPack);

            if (Text.trim().length() == 0)
                break;

            byte[] RData = new byte[1024];
            DatagramPacket RPack = new DatagramPacket(RData, RData.length);
            CliSoc.receive(RPack);

            String Echo = new String(RPack.getData(), 0, RPack.getLength()).trim();
            System.out.println("From Server <<< " + Echo);
        }

        CliSoc.close();
    }
}
