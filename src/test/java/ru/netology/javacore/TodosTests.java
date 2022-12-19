package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {
    Todos testTodos = new Todos();

/*    @Test
    void addTaskTest() {
        String expectedTask = "qwerty";
        testTodos.addTask("qwerty");
        String actualTask = testTodos.tasks.get(0);
        Assertions.assertEquals(expectedTask, actualTask);
    }*/

    @Test
    void getAllTaskTest() {
        String expected = "aaa bbb ccc";
        testTodos.addTask("ccc");
        testTodos.addTask("aaa");
        testTodos.addTask("bbb");
        String actual = testTodos.getAllTasks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeTaskTest() {
        String expected = "aaa bbb ccc";
        testTodos.addTask("ccc");
        testTodos.addTask("aaa");
        testTodos.addTask("bbb");
        testTodos.addTask("ddd");
        testTodos.removeTask("ddd");
        String actual = testTodos.getAllTasks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeLastTask() { //бесполезный тест
        String expected = "";
        testTodos.removeTask("ccc");
        String actual = testTodos.getAllTasks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTaskCapacityTest() {
        String expected = "1 2 3 4 5 6 7";
        testTodos.addTask("1");
        testTodos.addTask("2");
        testTodos.addTask("3");
        testTodos.addTask("4");
        testTodos.addTask("5");
        testTodos.addTask("6");
        testTodos.addTask("7");
        testTodos.addTask("8");
        String actual = testTodos.getAllTasks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void parseCommandTest() {
        String expected = "command_type Task_text";
        String jsonString = "{ \"type\": \"command_type\", \"task\": \"Task_text\" }";
        Assertions.assertEquals(expected, DataForTodos.parseJsonToCommand(jsonString).toString());
    }

    @Test
    void parseCommandRestoreTest() {
        String expected = "command_type";
        String jsonString = "{ \"type\": \"command_type\"}";
        Assertions.assertEquals(expected, DataForTodos.parseJsonToCommand(jsonString).toString());
    }

    @Test
    void restoreTaskTest() {
        testTodos.addTask("Первая");
        testTodos.addTask("Вторая");
        testTodos.removeTask("Первая");
        testTodos.addTask("Третья");
        String expected = "Вторая Первая";
        testTodos.restoreTask();
        testTodos.restoreTask();
        String actual = testTodos.getAllTasks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void parseClientCommandToJsonTest() {
        String expected = "{ \"type\":\"ADD\", \"task\": \"gotojobmfc\" }";
        String type = "ADD";
        String task = "gotojobmfc";
        String actual = DataForTodos.parseClientCommandToJson(type, task);
        Assertions.assertEquals(expected, actual);
    }
}
