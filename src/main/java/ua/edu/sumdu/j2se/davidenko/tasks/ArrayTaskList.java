package ua.edu.sumdu.j2se.davidenko.tasks;

import java.util.Arrays;

public class ArrayTaskList {

    private int size;

    private Task[] tasks;

    public ArrayTaskList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        } else {
            tasks = new Task[capacity];
        }
    }

    public ArrayTaskList() {
        int DEFAULT_CAPACITY = 10;
        tasks = new Task[DEFAULT_CAPACITY];
    }

    public void add(Task task) {
        if (tasks.length == size) {
            Task[] newTasks = new Task[tasks.length * 3];
            System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
            tasks = newTasks;
        }
        tasks[size] = task;
        size++;
    }

    public boolean remove(Task task) {
        for (int i = 0; i < size; i++) {
            if (tasks[i].equals(task)) {
                System.arraycopy(tasks, i + 1, tasks, i, tasks.length - 1 - i);
                size--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Task getTask(int index) {
        return tasks[index];
    }

    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList returnTask = new ArrayTaskList(size);
        for (int i = 0; i < size(); i++) {
            if (tasks[i].getTime() < from && tasks[i].getTime() > to) {
                returnTask.add(tasks[i]);
            }
        }
        return returnTask;
    }

}
