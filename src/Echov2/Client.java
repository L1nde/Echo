package Echov2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 1337);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream())){
            dos.writeInt(args.length);
            for (String arg : args) {
                dos.writeUTF(arg);
                String message = dis.readUTF();
                System.out.println(message);
            }
        }
    }
}
