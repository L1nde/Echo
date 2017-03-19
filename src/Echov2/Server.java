package Echov2;

import Echov2.Echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        try(ServerSocket serverSocket = new ServerSocket(1337)){
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new Echo(socket)).start();
            }
        }
    }
}
