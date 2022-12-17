package ru.netology.javacore;

import java.util.*;

public class Todos {
    private static final int CAPACITY = 7;  // ограничение по условию задачи
    Command command;
    DataForTodos dataForTodos;
    List<String> tasks = new ArrayList<>(CAPACITY);//таски.
    List<String> commandsTypeLog = new ArrayList<>(); //команды
    List<String> deletedTasks = new ArrayList<>(); //удалённые таски

    public void addTask(String task) {
        if (tasks.size() < CAPACITY) {
            tasks.add(task);
            commandsTypeLog.add(Command.COMMAND_ADD);
        }
    }

    // изменить модификаторы доступа у методов управления тасками???
    public void removeTask(String task) {
        tasks.remove(task);
        commandsTypeLog.add(Command.COMMAND_REMOVE);
        deletedTasks.add(task);
    }

    public String getAllTasks() {
        Object[] sortedTask = tasks.stream().sorted().toArray();
        String result = "";
        for (Object s : sortedTask) {
            result += " " + s;
        }
        return result.trim();
    }

    public void restoreTask() {
        if (commandsTypeLog.get(commandsTypeLog.size() - 1).equals(Command.COMMAND_ADD)) {
            tasks.remove(tasks.size() - 1);
            commandsTypeLog.remove(commandsTypeLog.size() - 1);
        }
        if (commandsTypeLog.get(commandsTypeLog.size() - 1).equals(Command.COMMAND_REMOVE)) {
            tasks.add(deletedTasks.get(deletedTasks.size() - 1));
            commandsTypeLog.remove(commandsTypeLog.size() - 1);
        }
    }

    public void manageCommandsForTodos(Command command) {
        if (command.type.equals(Command.COMMAND_ADD)) {
            this.addTask(command.task);
        }
        if (command.type.equals(Command.COMMAND_REMOVE)) {
            this.removeTask(command.task);
        }
        if (command.type.equals(Command.COMMAND_RESTORE)) {
            this.restoreTask();
        }
    }
}
