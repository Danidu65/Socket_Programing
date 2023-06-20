import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 3002);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String message ="";
        String reply = "";

        while (!message.equals("Finish")){
            message=dataInputStream.readUTF();
            System.out.println(message);

            reply=bufferedReader.readLine();
            dataOutputStream.writeUTF(reply);

            dataOutputStream.flush();
            System.out.println(reply);
        }
        socket.close();

    }
}