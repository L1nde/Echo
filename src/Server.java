import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException{
        try(ServerSocket serverSocket = new ServerSocket(1337)){
            while (true){
                Socket socket = serverSocket.accept();
                try(DataInputStream dis = new DataInputStream(socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream())){
                    String message = dis.readUTF();
                    dos.writeUTF(message);
                }
            }
        }
    }
}
