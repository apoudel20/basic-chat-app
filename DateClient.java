import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

/**
 * CLI TCP client. Requires the IP of the server.
 */

public class DateClient {
    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.err.println("Pass the server IP as the sole command line argument.");
            return;
        }
        Socket socket = new Socket(args[0], 59090);
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("Server response: " + in.nextLine());
        socket.close();
    }
}