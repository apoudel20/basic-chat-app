// Exceptions
import java.io.IOException;

// Byte Stream Management
import java.io.PrintWriter;
import java.util.Scanner;

// Socket variables
import java.net.ServerSocket;
import java.net.Socket;

// Threading services
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CapitalizeServer {
    /**
     * TCP Server that spawns threads. Upon spawning the thread that handles the
     * request, then the server goes back to listening. Thread count is limited by a
     * thread pool.
     * 
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        try(ServerSocket listener = new ServerSocket(59898)){
            System.out.println("The capitalization server is running...");
            ExecutorService pool = Executors.newFixedThreadPool(20);
            while(true){
                pool.execute(new Capitalizer(listener.accept()));
            }
        }
    }


    private static class Capitalizer implements Runnable{
        private Socket clientSocket;

        Capitalizer(Socket clientSocket) {
            this.clientSocket =clientSocket;
        }

        @Override
        public void run() {
            System.out.println("Connected: " + clientSocket);
            try{
                Scanner in = new Scanner(clientSocket.getInputStream());
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                while(in.hasNextLine()){
                    out.println(in.nextLine().toUpperCase());
                }
            } catch (Exception e) {
                System.err.println("Error: ");
            } finally {
                try{
                    clientSocket.close();
                }catch(IOException e){

                }
                System.out.println("Closed: " + clientSocket);
            }
        }

    }
}