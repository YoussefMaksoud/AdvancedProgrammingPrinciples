package EXE2;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * class communicates with a server to request information about the date and time
 */
class DateClient {

    /**
     *
     * member variables manage the socket and input/ output of the socket
     */
    private Socket aSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;
    private BufferedReader stdIn;

    /**
     *
     * constructor creates new socket, buffered readers(input), and
     * PrintWriter(output)
     * @param serverName is the name of the server
     * @param port the number of the port
     */
    public DateClient(String serverName, int port){

        try {

            aSocket = new Socket(serverName, port);
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            socketOut = new PrintWriter(aSocket.getOutputStream(), true);

        }catch(IOException e){

            e.printStackTrace();

        }
    }

    /**
     *
     * method reads and writes data from/ to the socket
     * (communicates with the server)
     */
    public void communicate() {

        String line = "";
        String response = "";
        boolean running = true;

        while(running){
            try{
                System.out.println("Please select an option (DATE/TIME)");
                line = stdIn.readLine();
                if(!line.toLowerCase().equals("quit")) {
                    socketOut.println(line);
                    response = socketIn.readLine();
                    System.out.println(line + " is: " + "\n" + response);
                }else{
                    System.out.println("Good Bye!");
                    break;
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        try{
            socketIn.close();
            socketOut.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * creates a new client and calls the communicate method
     * @param args is the variable storing command line arguments
     * @throws IOException throws exception if there was an error reading or writing from/ to the socket
     */
    public static void main(String[] args) throws IOException {
        DateClient aClient = new DateClient("localhost", 9090);
        aClient.communicate();
    }

}
