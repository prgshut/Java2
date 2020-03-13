package lesson6.HW1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
   static Socket clientSockt = null;
    static ServerSocket serverSocket =null;
    static Scanner scan = new Scanner(System.in);
    static DataInputStream inClient= null;
    static DataOutputStream outClient =null;
    public static void main(String[] args) throws IOException {

        try {
            serverSocket= new ServerSocket(8581);
            System.out.println("Сервер подключен");
            clientSockt=serverSocket.accept();
            System.out.println("Клиент подключился");
             inClient = new DataInputStream(clientSockt.getInputStream());
             outClient = new DataOutputStream(clientSockt.getOutputStream());
         Thread readThr=   new Thread(Server::readMes);

            Thread writeThr = new Thread(Server::writeMes);
            readThr.start();
            writeThr.start();
            readThr.join();
            writeThr.join();

        }catch (IOException e){
            System.out.println("Сервер не поднялся"+ e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null) serverSocket.close();
            if (clientSockt!=null) clientSockt.close();
        }


    }

    private static void writeMes() {
        while (true) {
            try {
                System.out.println("Отправьте сообщение слиенту: ");
                String str=scan.nextLine().trim();
                if (str!=null) outClient.writeUTF(str);
            } catch (IOException e) {
                System.out.println("Проблема с отправкой от сервера");
            }
        }
    }

    private static void readMes() {
        while (true) {

                try {

                    String massengerClient = inClient.readUTF();
                    System.out.println("Client massenger: " + massengerClient);
                } catch (IOException e) {
                    System.out.println("Проблемы с сообщением от пользователя");
                    e.printStackTrace();
                }


        }
    }
}
