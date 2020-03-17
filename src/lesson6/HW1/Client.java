package lesson6.HW1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    private Socket socket = null;
    private String ADRES_SERVER = "localhost";
    private int SOCKET_SERVER = 8581;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scan =new Scanner(System.in);

    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
    }

    private void connect() {
        try {
            socket = new Socket(ADRES_SERVER, SOCKET_SERVER);
            System.out.println("Подключились");
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            start();
        } catch (IOException  e) {
            System.out.println("Неудалось подключиться");
            System.exit(-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void start() throws InterruptedException {
        Thread writeM = new Thread(this::writeMeseng);
        Thread readM = new Thread(this::readMeseng);
        writeM.start();
        readM.start();
        writeM.join();
        readM.join();


    }

    private void writeMeseng() {
        while (true) {
            try {
                System.out.println("Напишите серверу: ");
                String str =scan.nextLine().trim();
                if (!str.isEmpty()) out.writeUTF(str);
            } catch (IOException e) {
                System.out.println("Проблемы с вводом");
            }
        }
    }

    private void readMeseng() {
        while (true) {
            try {
                String inStr = in.readUTF();
                System.out.println("Сервер пишет: " + inStr);
            } catch (IOException e) {
                System.out.println("Проблемы с выводом");
                e.printStackTrace();
            }
        }
    }

}

