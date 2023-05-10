package tasks;

import tasks.task10.Task10;
import tasks.task2.Task2;
import tasks.task3.Task3;
import tasks.task4.Task4;
import tasks.task5.Task5;
import tasks.task6.Task6;
import tasks.task7.Task7;
import tasks.task8.Task8;

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

        System.out.println("Task7");
        Task7 task7 = new Task7();
        task7.run();

        System.out.println("Task8");
        Task8 task8 = new Task8();
        task8.run();

        System.out.println("Task10");
        Task10 task10 = new Task10();
        task10.run();
    }

}