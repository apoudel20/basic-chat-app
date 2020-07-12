import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * Starts a thread for each new connection. Allows a new name for each thread and keeps requesting until a unique name is received. 
 * 
 * Could also accept commands like Slack.
 */

public class ChatServer{

    // Store client names.
    private static Set<String> names = new HashSet<String>();

    // Each connection gets its own PrintWriter to broadcast its messages.
    

}
