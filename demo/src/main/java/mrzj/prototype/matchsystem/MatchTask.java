package mrzj.prototype.matchsystem;

import java.util.Comparator;

public class MatchTask {

//    public static class MatchTaskComparator implements Comparator<MatchTask> {
//        @Override
//        public int compare(MatchTask t1, MatchTask t2) {
//            return t1.level - t2.level;
//        }
//    }

    private int level;
    private int id;

    public MatchTask(int id, int level) {
        this.id = id;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

