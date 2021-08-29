import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class Server {
    int portNumber;

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public void startServer() throws IOException {
        final var serverSocket = new ServerSocket(portNumber);
        final var threadPool = Executors.newFixedThreadPool(64);
        System.out.println("Server started!");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                final var serverThread = new ServerThread(socket);
                threadPool.submit(serverThread);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}