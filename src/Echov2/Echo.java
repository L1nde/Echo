package Echov2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Echo implements Runnable {
    private Socket socket;

    public Echo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            int len = dis.readInt();
            for (int i = 0; i < len; i++) {
                    String message = dis.readUTF();
                    dos.writeUTF(message);
            }
            socket.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
