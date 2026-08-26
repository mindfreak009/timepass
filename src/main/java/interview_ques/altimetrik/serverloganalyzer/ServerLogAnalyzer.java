package interview_ques.altimetrik.serverloganalyzer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServerLogAnalyzer  {

    // userId -> login timestamp
    private final Map<String, Long> activeConnections = new HashMap<>();

    // userId -> User
    private final Map<String, User> users = new HashMap<>();

    public void processLog(String userId,
                           String connection,
                           long timestamp) {
        users.putIfAbsent(userId, new User(userId));

        switch (connection) {
            case "CONNECTED":
                activeConnections.put(userId, timestamp);
                break;

            case "DISCONNECTED":
                Long loginTime = activeConnections.remove(userId);
                if (loginTime != null) {
                    long duration = timestamp - loginTime;
                    users.get(userId).addTime(duration);
                }
                break;
        }
    }

    public List<User> getUsersConnected() {
        return activeConnections.keySet()
                .stream()
                .map(users::get)
                .collect(Collectors.toList());
    }

    public List<User> getTop3UsersByTotalTimeSpent() {
        return users.values()
                .stream()
                .sorted(Comparator.comparingLong(User::getTotalTimeSpent)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        ServerLogAnalyzer analyzer = new ServerLogAnalyzer();

        analyzer.processLog("Alice", "CONNECTED", 100);
        analyzer.processLog("Bob", "CONNECTED", 110);

        analyzer.processLog("Bob", "DISCONNECTED", 170);
        analyzer.processLog("Alice", "DISCONNECTED", 250);

        analyzer.processLog("Charlie", "CONNECTED", 300);

        System.out.println(analyzer.getUsersConnected());
        System.out.println(analyzer.getTop3UsersByTotalTimeSpent());
    }
}
