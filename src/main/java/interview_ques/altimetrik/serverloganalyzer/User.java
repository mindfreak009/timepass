package interview_ques.altimetrik.serverloganalyzer;

class User {
    private final String userId;
    private long totalTimeSpent;

    public User(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public long getTotalTimeSpent() {
        return totalTimeSpent;
    }

    public void addTime(long duration) {
        totalTimeSpent += duration;
    }

    @Override
    public String toString() {
        return userId + " : " + totalTimeSpent;
    }
}
