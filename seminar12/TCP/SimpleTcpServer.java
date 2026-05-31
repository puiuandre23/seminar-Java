package seminar12.TCP;

import java.io.*;
import java.net.*;

public class SimpleTcpServer {
    public static void main(String[] args) throws IOException {
        int port = 5001;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server pornit pe portul " + port);

        while (true) {
            System.out.println("Astept Client 1");
            Socket client1 = serverSocket.accept();
            System.out.println("Client 1 conectat!");

            System.out.println("Astept Client 2");
            Socket client2 = serverSocket.accept();
            System.out.println("Client 2 conectat! Chat inceput.\n");

            BufferedReader inC1  = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            BufferedReader inC2  = new BufferedReader(new InputStreamReader(client2.getInputStream()));
            PrintWriter    outC1 = new PrintWriter(client1.getOutputStream(), true);
            PrintWriter    outC2 = new PrintWriter(client2.getOutputStream(), true);

            outC1.println("[Server]: Client 2 s-a conectat. Puteti vorbi!");
            outC2.println("[Server]: Client 1 s-a conectat. Puteti vorbi!");

            // thread - citeste de la Client 1 si trimite la Client 2
            new Thread(() -> {
                try {
                    String mesaj;
                    while ((mesaj = inC1.readLine()) != null) {
                        System.out.println("Client 1 spune: " + mesaj);
                        outC2.println("[Client 1]: " + mesaj);
                    }
                } catch (IOException e) {
                    System.out.println("Client 1 s-a deconectat.");
                }
            }).start();

            // thread - citeste de la Client 2 si trimite la Client 1
            new Thread(() -> {
                try {
                    String mesaj;
                    while ((mesaj = inC2.readLine()) != null) {
                        System.out.println("Client 2 spune: " + mesaj);
                        outC1.println("[Client 2]: " + mesaj);
                    }
                } catch (IOException e) {
                    System.out.println("Client 2 s-a deconectat.");
                }
            }).start();
        }
    }
}
