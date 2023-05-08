package tasks;

import tasks.task2.Task2;
import tasks.task3.Task3;
import tasks.task4.Task4;
import tasks.task5.Task5;
import tasks.task6.Task6;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        System.out.println("Task2");
        Task2 task2 = new Task2();
        task2.run();

        System.out.println("Task3");
        Task3 task3 = new Task3();
        task3.run();

        System.out.println("Task4");
        Task4 task4 = new Task4();
        task4.run();

        System.out.println("Task5");
        Task5 task5 = new Task5();
        task5.json();
        task5.xml();
        task5.stream();


        System.out.println("Task6");
        Task6 task6 = new Task6();
        task6.run();

    }

}