package mrzj.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureDemo {
    public static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return 520;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task1 = new Task();
        FutureTask<Integer> task2 = new FutureTask<>(new Task());
        log.info("开始执行");
        Future<Integer> result = executorService.submit(task1);
        executorService.submit(task2);
        log.info(String.format("task1: %d", result.get()));
        log.info(String.format("task2: %d", task2.get()));
        log.info("结束执行");
    }
}
