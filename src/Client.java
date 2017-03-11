import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1337);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(args[0]);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String message = dis.readUTF();
        System.out.println(message);
        dis.close();
        dos.close();
        socket.close();
    }
}
