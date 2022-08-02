package EXE4;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TicTacServer {

    /**
     *
     * variables include a threadpool and a server socket
     */
    private ServerSocket serverSocket;
    private Socket aSocket;
    private ExecutorService pool;

    /**
     *
     * initializes the thread pool and server socket
     * @param port
     */
    public TicTacServer(int port){
        try{
            serverSocket = new ServerSocket(port);
            pool = Executors.newCachedThreadPool();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //communicates with the clients, creates a game on a new thread and starts the game
    public void communicateWithClient() throws IOException{
        try{
            while(true){

                Player xPlayer = new Player(serverSocket.accept(), 'X');
                System.out.println("Connection established");
                Player oPlayer = new Player(serverSocket.accept(), 'O');
                System.out.println("Connection established");

                Referee theRef = new Referee();

                theRef.setxPlayer(xPlayer);
                theRef.setoPlayer(oPlayer);

                Game theGame = new Game();
                theGame.appointReferee(theRef);

                System.out.println("Game started");

                pool.execute(theGame);

            }
        }catch(Exception e){
            e.printStackTrace();
            pool.shutdown();
        }

    }

    /**
     *
     * creates a server object and calls the communicate method
     * @param args are command line arguments
     * @throws IOException thrown if there is an error reading or writing to the socket
     */
    public static void main(String args[]) throws IOException {
        TicTacServer server = new TicTacServer(8099);
        System.out.println("Server is now running");
        server.communicateWithClient();
    }

}
