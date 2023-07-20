package mrzj.demo.concurrent;

public class Example1 {
    private boolean flag = false;

    public static void main(String[] args) {

        Example1 example1 = new Example1();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                example1.method1();
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                example1.method2();
            }).start();
        }
    }


    public synchronized void method1() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method1");
        flag = true;
        notify();
    }

    public synchronized void method2() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method2");
        flag = false;
        notify();
    }

}
