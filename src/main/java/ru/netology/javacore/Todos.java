package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private static final int CAPACITY = 7;  // ограничение по условию задачи
    private List<String> tasks = new ArrayList<>(CAPACITY);//таски.
    private List<String> commandsTypeLog = new ArrayList<>(); //команды
    private List<String> deletedTasks = new ArrayList<>(); //удалённые таски


    public void addTask(String task) {
        if (tasks.size() < CAPACITY) {
            tasks.add(task);
            commandsTypeLog.add(Command.COMMAND_ADD);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
        commandsTypeLog.add(Command.COMMAND_REMOVE);
        deletedTasks.add(task);
    }

    public String getAllTasks() {
        return tasks.stream().sorted().collect(Collectors.joining(" "));
    }

    public void restoreTask() {
        switch (commandsTypeLog.get(commandsTypeLog.size() - 1)) {
            case Command.COMMAND_ADD:
                tasks.remove(tasks.size() - 1);
                commandsTypeLog.remove(commandsTypeLog.size() - 1);
                break;
            case Command.COMMAND_REMOVE:
                tasks.add(deletedTasks.get(deletedTasks.size() - 1));
                commandsTypeLog.remove(commandsTypeLog.size() - 1);
                break;
        }
    }

    public void manageCommandsForTodos(Command command) {
        switch (command.type) {
            case Command.COMMAND_ADD:
                this.addTask(command.task);
                break;
            case Command.COMMAND_REMOVE:
                this.removeTask(command.task);
                break;
            case Command.COMMAND_RESTORE:
                this.restoreTask();
                break;
        }
    }
}
