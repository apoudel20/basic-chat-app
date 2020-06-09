import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * TCP server. Sends client current datetime and closes teh connection. Client has to be 
 * completely served before the server can handle another client.
 */

public class DateServer{
    public static void main(String[] args) throws IOException{
        try(ServerSocket listener = new ServerSocket(59090)){
            System.out.println("The Date Server is running...");
            while(true){
                try (Socket socket = listener.accept()){
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                }
            }
        }
    }
}