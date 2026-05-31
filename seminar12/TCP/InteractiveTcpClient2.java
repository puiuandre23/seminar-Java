package seminar12.TCP;

import java.io.*;
import java.net.*;

public class InteractiveTcpClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001);
        System.out.println("Conectat ca Client 2. Asteapta Client 1\n");

        BufferedReader serverIn  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter    serverOut = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        // thread - afiseaza mesajele primite de la server
        new Thread(() -> {
            try {
                String mesaj;
                while ((mesaj = serverIn.readLine()) != null) {
                    System.out.println("\n" + mesaj);
                    System.out.print("Tu: ");
                }
            } catch (IOException e) {
                System.out.println("Conexiunea s-a inchis.");
            }
        }).start();

        // thread principal - trimite mesaje
        String mesaj;
        while (true) {
            System.out.print("Tu: ");
            mesaj = userInput.readLine();
            if (mesaj.equalsIgnoreCase("exit")) break;
            serverOut.println(mesaj);
        }

        socket.close();
    }
}
