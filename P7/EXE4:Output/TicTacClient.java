package EXE4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;

public class TicTacClient {

    /**
     *
     * member variables manage the socket
     */
    private Socket aSocket;
    private BufferedReader socketInput;
    private PrintWriter socketOutput;
    private BufferedReader stdIn;

    /**
     *
     * creates new variables to read and write from/ to the socket
     * @param serverName
     * @param port
     */
    public TicTacClient(String serverName, int port){
        try{
            aSocket = new Socket(serverName, port);
            socketInput = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            socketOutput = new PrintWriter(aSocket.getOutputStream(), true);
            stdIn = new BufferedReader(new InputStreamReader(System.in));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * communicates with the server through the socket
     */
    public void communicateWithServer(){
        try{
            while(true){
                String line = "";
                while(true){

                    line = socketInput.readLine();

                    if(line.contains("\0")){
                        line.replace("\0"," ");
                        System.out.println(line);
                        break;
                    }

                    if(line.toLowerCase().equals("quit")){
                        return;
                    }

                    System.out.println(line);
                }

                line = stdIn.readLine();
                socketOutput.println(line);
                socketOutput.flush();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * creates a new client and calls the communicate method
     * @param args
     */
    public static void main(String args[]){
        TicTacClient client = new TicTacClient("localhost", 8099);
        client.communicateWithServer();
    }
}
