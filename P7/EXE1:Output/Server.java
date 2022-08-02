package EXE1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * class communicates with the client to produce the desired output
 */
class Server {

    /**
     *
     * contains a socket, server socket, and variables responsible for io
     */
    private Socket aSocket;
    private ServerSocket serverSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;

    /**
     *
     * constructor creates a new server socket
     * @param port is the port number of the server socket
     */
    public Server(int port){

        try{
            serverSocket = new ServerSocket(port);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * communicates with the client and performs actons on the string read from the socket
     */
    public void communicate(){

        String line = "";
        boolean pal = false;

        while(true){

            try{
                line = socketIn.readLine();

                pal = isPalindrome(line);
                if(pal == true) {
                    socketOut.println("The word " + line + " is a palindrome");
                }
                else {
                    socketOut.println("The word " + line + " is not a palindrome");
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * method checks if a string is a palindrome
     * @param word is the word being checked
     * @return true or false depending on if word is a palindrome
     */
    public boolean isPalindrome(String word){
        String wordRev = "";

        for(int i = word.length() - 1; i > -1; i--){
            wordRev += word.charAt(i);
        }

        return wordRev.equals(word);
    }

    /**
     *
     * creates the io components of the socket, calls the communicate method
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException{
        try{
            Server myServer = new Server(8099);
            myServer.aSocket = myServer.serverSocket.accept();
            System.out.println("Connection Established");
            myServer.socketIn = new BufferedReader(new InputStreamReader(myServer.aSocket.getInputStream()));
            myServer.socketOut = new PrintWriter(myServer.aSocket.getOutputStream(), true);
            myServer.communicate();
            myServer.socketIn.close();
            myServer.socketOut.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
