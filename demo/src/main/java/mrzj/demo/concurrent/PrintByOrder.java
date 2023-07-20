package mrzj.demo.concurrent;


public class PrintByOrder{

    public static void main(String[] args) throws InterruptedException {
        PrintByOrder printByOrder = new PrintByOrder();
        printByOrder.first(() -> {
            System.out.println("first");
        });
    }

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        printThird.run();
    }

}
