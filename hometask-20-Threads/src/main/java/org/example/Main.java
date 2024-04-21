package org.example;

import org.example.task1.MyRunnable;
import org.example.task4.LogThreeTimeThread;
import org.example.task4.Marker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void task1() throws InterruptedException {
        // Создать поток используя два способа - через наследованное и имплементируя интерфейс Runnable
        // Оба потока должны стартовать, после чего основной поток должен дождать ся их завершения и прекратить работу.

        // Наследование
//        var myThread1 = new MyThread();
//        var myThread2 = new MyThread();

        // имплементируя интерфейс Runnable
        var myRunnable = new MyRunnable();
        var myThread1 = new Thread(myRunnable);
        var myThread2 = new Thread(() -> System.out.println("Hello from " + Thread.currentThread()));


        myThread2.start();
        myThread1.start();

        myThread2.join();
        myThread1.join();
        System.out.println("Main Thread");
    }

    public static List<Integer> getIntList(int count) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add((int) (Math.random() * 100 + 1));
        }
        return result;
    }

    public static void task2() throws InterruptedException {
            /*
            Есть массив целых чисел.
            Необходимо создать два потока - один из которых будет считать максимальное значение,а второй - минимальное.
            Запустить оба потока и дождаться их окончания.
            Вывести на экран результат вычислений.
            */

        var intList = getIntList(20);
        System.out.println(intList);
        AtomicInteger min = new AtomicInteger();
        AtomicInteger max = new AtomicInteger();
        Thread minThread = new Thread(() -> {
            min.set(intList.stream().mapToInt(val -> val).min().getAsInt());
        });
        Thread maxThread = new Thread(() -> {
            max.set(intList.stream().mapToInt(val -> val).max().getAsInt());
        });

        minThread.start();
        maxThread.start();

        maxThread.join();
        minThread.join();

        System.out.println("min: " + min + ", max: " + max);


    }

    public static void task3() {
        var daemon = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                var threadName = Thread.currentThread().getName();
                System.out.println("Thread is executing with name: " + threadName);
            }
        }, "Daemon");
        daemon.setDaemon(true);
        daemon.start();
    }

    public static void task4() {
        /*
        Есть два потока - один выводит в бесконечном цикле 3 раза цифру "1" (3 вызова System.out.println), а второй аналогично - цифру "2". Предусмотреть небольшую задержку.
        Задача - сделать синхронизацию потоков (пока один не закончит вывод трех чисел, второй будет ждать - не будет перемешивания)
        Проверить что в консоли вы получите поочередное выполнение потоков.
         */

        Marker marker = new Marker();
        Thread thread1 = new LogThreeTimeThread("1", marker);
        Thread thread2 = new LogThreeTimeThread("2", marker);

        thread1.start();
        thread2.start();

    }

    public static void main(String[] args) throws InterruptedException {
        task1();
        task2();
//        task3();
        task4();

    }
}