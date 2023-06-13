import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 6666);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("Hello Server");
        dataOutputStream.flush();
        dataOutputStream.close();
        socket.close();
    }
}