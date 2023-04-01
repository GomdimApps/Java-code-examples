// Aqui está um exemplo de como criar um chat online simples em Java utilizando sockets://

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) throws IOException {
        // Cria o socket do servidor
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("ChatServer rodando na porta 8080");

        while (true) {
            // Aguarda uma conexão de cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clientSocket);

            // Cria os fluxos de entrada e saída
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Envia uma mensagem de boas-vindas para o cliente
            out.println("Bem-vindo ao ChatServer! Digite 'sair' para sair.");

            // Inicia uma thread para lidar com a comunicação com o cliente
            new Thread(new ChatHandler(clientSocket, in, out)).start();
        }
    }
}

class ChatHandler implements Runnable {

    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public ChatHandler(Socket clientSocket, BufferedReader in, PrintWriter out) {
        this.clientSocket = clientSocket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null) {
                // Envia a mensagem para todos os clientes conectados
                out.println(inputLine);
                System.out.println("Mensagem enviada para os clientes: " + inputLine);

                // Se o cliente digitar "sair", fecha a conexão
                if (inputLine.equalsIgnoreCase("sair")) {
                    clientSocket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//Este código cria um servidor de chat que usa sockets para se comunicar com os clientes. Ele cria um socket de servidor na porta 8080 e aguarda conexões de clientes. Quando um cliente se conecta, o servidor cria fluxos de entrada e saída para ler e enviar mensagens. Ele também inicia uma thread para lidar com a comunicação com o cliente.
//Para criar um cliente, você pode usar o seguinte código:


import java.
