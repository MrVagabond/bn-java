package mrzj.prototype.matchsystem;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MatchSystemTest {

    public static void main(String[] args) {
        MatchSystem matchSystem = new MatchSystem();
        new Thread(() -> {
            while(true) {
                MatchResult matchResult = matchSystem.getResult();
                if(matchResult == null) continue;
                List<Integer> result = matchResult.getResult();
                log.info(String.format("match result: %d %d", result.get(0), result.get(1)));
            }
        }).start();
        for (int i = 0; i < 10; i++) {
            MatchTask task = new MatchTask(i, (i % 5) + 1);
            matchSystem.submit(task);
        }
    }

}

