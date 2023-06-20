import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3002);
            Socket socket = serverSocket.accept();
            System.out.println("HI");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message ="";
            String reply = "";

            while (!message.equals("Finish")){
                reply=bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
                System.out.println(reply);

                message=dataInputStream.readUTF();
                System.out.println(message);
            }
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}