package mrzj.prototype.matchsystem;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

@Slf4j
public class MatchSystem {

    /*
     * 我觉得这个匹配系统可以这么设计：
     * 请求不停被转发，根据数字1-5，发送给不同的等待队列
     * 线程池中的5个线程分别进行段位为1-5的匹配
     * 第i个线程负责监控第i个队列，如果该队列中包含了10个玩家，则抽出来打包成TaskResult发给结果队列
     * 客户端代码只需要不停地submit任务和不停地getResult即可
     * 线程池中关键的不是线程，而是正在执行的任务，所以应该是向线程池提交5个任务，每个任务对应一个等待队列
     * */

    private ExecutorService executor;
    private List<LinkedBlockingDeque<MatchTask>> taskQueueList;
    private LinkedBlockingDeque<MatchResult> resultQueue;

    private static final int DEFAULT_TASKQUEUE_NUM = 5;
    private static final int DEFAULT_TASKQUEUE_CAPACITY = 128;
    private static final int DEFAULT_RESULTQUEUE_CAPACITY = 64;
//    private static Comparator<MatchTask> matchTaskComparator = new MatchTask.MatchTaskComparator();

    MatchSystem() {
        taskQueueList = new ArrayList<>(DEFAULT_TASKQUEUE_NUM);
        for(int i = 0; i < DEFAULT_TASKQUEUE_NUM; i ++) {
            taskQueueList.add(new LinkedBlockingDeque<>(DEFAULT_TASKQUEUE_CAPACITY));
        }
        resultQueue = new LinkedBlockingDeque<>(DEFAULT_RESULTQUEUE_CAPACITY);
        executor = Executors.newFixedThreadPool(DEFAULT_TASKQUEUE_NUM);
        for(int i = 0; i < DEFAULT_TASKQUEUE_NUM; i ++) {
            final int index = i;
            executor.submit(() -> {
                while(true) {
                    LinkedBlockingDeque<MatchTask> taskQueue = taskQueueList.get(index);
                    if(taskQueue.size() >= 2) {
                        List<Integer> result = new ArrayList<>();
                        for(int j = 0; j < 2; j ++) {
                            result.add(taskQueue.poll().getId());
                        }
                        MatchResult matchResult = new MatchResult(result, true);
                        resultQueue.offer(matchResult);
                    }
                }
            });
        }
    }

    public void submit(MatchTask task) {
        // 多个线程都会调用该方法
        log.info(String.format("id=%d, level=%d", task.getId(), task.getLevel()));
        taskQueueList.get(task.getLevel() - 1).offer(task);
    }

    public MatchResult getResult() {
        return resultQueue.poll();
    }

}

