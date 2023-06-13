import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Client : "+message);

            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}