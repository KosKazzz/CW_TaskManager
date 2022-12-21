package ru.netology.javacore;

import java.util.*;

public class Todos {
    private static final int CAPACITY = 7;  // ограничение по условию задачи
    private TreeSet<String> tasks = new TreeSet<>();//таски.
    private List<String> logList = new ArrayList<>();// Храним все команды


    public void addTask(String task) {
        if (tasks.size() < CAPACITY) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        return String.join(" ", tasks);
    }

    public void restoreTask() {
        Command command = DataForTodos.parseJsonToCommand(logList.get(logList.size() - 1));
        switch (command.type) {
            case Command.COMMAND_ADD:
                tasks.remove(command.task);
                logList.remove(logList.size() - 1);
                break;
            case Command.COMMAND_REMOVE:
                tasks.add(command.task);
                logList.remove(logList.size() - 1);
                break;
        }
    }

    public void manageCommandsForTodos(String fromClient) {
        Command command = DataForTodos.parseJsonToCommand(fromClient);
        switch (command.type) {
            case Command.COMMAND_ADD:
                this.addTask(command.task);
                logList.add(fromClient);
                break;
            case Command.COMMAND_REMOVE:
                this.removeTask(command.task);
                logList.add(fromClient);
                break;
            case Command.COMMAND_RESTORE:
                this.restoreTask();
                break;
        }
    }

    //for tests
    public void setLogList(String str) {
        logList.add(str);
    }

    public String getLogList() {
        return logList.toString();
    }
}
