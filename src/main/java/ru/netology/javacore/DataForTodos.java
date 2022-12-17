package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class DataForTodos {
    public static Command parseJsonToCommand(String jsonString) { //может статик?
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(jsonString, Command.class);
    }

    public static String parseClientCommandToJson(String type, String task) {
        Gson gson = new Gson();
        return "{ \"type\":" + gson.toJson(type).toUpperCase() + ", \"task\": " + gson.toJson(task) + " }";
        // Зачем тут Gson?...
    }

}
