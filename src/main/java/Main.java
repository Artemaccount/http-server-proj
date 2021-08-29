import java.io.*;
public class Main {
    public static void main(String[] args) {
      try {
        new Server(9999).startServer();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}


