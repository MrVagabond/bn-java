package mrzj.demo.threadlocal;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        int x0 = 520;
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                ThreadLocal<Integer> x = new ThreadLocal<>();
                x.set(x0);

            }, "thread-" + i).start();
        }

    }
}
