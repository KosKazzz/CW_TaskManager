package ru.netology.javacore;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String fromClient = in.readLine(); // jsonstring, come from client
                    todos.manageCommandsForTodos(fromClient);
                    out.write(todos.getAllTasks());
                    out.flush();

                }
            }
        } catch (IOException e) {
            System.out.println("Can't start server!");
            e.printStackTrace();
        }
    }
}
