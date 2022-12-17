package ru.netology.javacore;

import java.io.*;
import java.net.Socket;

public class TodosClient {

    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("localhost", 8989);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println("Manage you tasks!");
            System.out.println("What do you want : add or remove or restore ?");
            String toServerType = reader.readLine();
            System.out.println("What do you wont to " + toServerType + "? If you wont to restore - just press \"Enter\"");
            String toServerTask = reader.readLine();
            String toServer = DataForTodos.parseClientCommandToJson(toServerType,toServerTask);
            out.println(toServer);
            //out.println("{ \"type\": \"ADD\", \"task\": \"Just do something\" }");
            System.out.println(in.readLine());
        }
    }
}
