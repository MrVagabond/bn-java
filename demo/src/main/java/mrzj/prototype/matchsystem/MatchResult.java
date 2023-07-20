package mrzj.prototype.matchsystem;

import java.util.List;

public class MatchResult {

    private List<Integer> result;
    private boolean isMatched;

    public MatchResult(List<Integer> result, boolean isMatched) {
        this.result = result;
        this.isMatched = isMatched;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public List<Integer> getResult() {
        return result;
    }
}

