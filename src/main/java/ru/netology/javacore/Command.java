package ru.netology.javacore;

public class Command {
    static final String COMMAND_ADD = "ADD";
    static final String COMMAND_REMOVE = "REMOVE";
    static final String COMMAND_RESTORE = "RESTORE";
    public String type;
    public String task;

    @Override
    public String toString() {
        if (type == null) {
            this.type = "";
        }
        if (task == null) {
            this.task = "";
        }
        return (type + " " + task).trim();
    }
}
