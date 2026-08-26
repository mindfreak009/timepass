package dsa.heap;

import java.util.*;

class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;

    public Tweet(int time, int tweetId) {
         this.time = time;
         this.tweetId = tweetId;
    }

    public int compareTo(Tweet that) {
        return that.time - this.time;   // decreasing order
    }
}

class User {
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User(int userId) {
        this.userId = userId;
        followers = new HashSet<>();
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet t) {
        tweets.add(0, t);   // insertion at the head
    }
    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }

    public void removeFollower(int followeeId) {
        followers.remove(followeeId);
    }

}

public class Twitter {
    Map<Integer, User> userMap;
    int timeCounter;

    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    // Time Complexity: O(1)
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        // O(1)
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }
        // N*TlogT = (N*10log10) because of the count logic of 10
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        // add self tweets + user tweets
        User user = userMap.get(userId);
        for (int followerId: user.followers) {  // N
            int count = 0;
            count++;
            for (Tweet tweet: userMap.get(followerId).tweets) { // T
                pq.offer(tweet);  // logT
                if(count > 10) {
                    break;
                }
            }
        }
        // 10log10
        for (Tweet tweet: user.tweets) {
            int count = 0;
            count++;
            pq.offer(tweet);
            if(count > 10) {
                break;
            }
        }
        //
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while (!pq.isEmpty() && index < 10){
            Tweet tweet = pq.poll();
            res.add(tweet.tweetId);
            index++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if(!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        User user = userMap.get(followerId);
        user.addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return;
        }
        User user = userMap.get(followerId);
        user.removeFollower(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a tweet
        twitter.postTweet(1, 101);

        // User 1 posts another tweet
        twitter.postTweet(1, 102);

        // User 2 posts a tweet
        twitter.postTweet(2, 201);

        // User 1 follows User 2
        twitter.follow(1, 2);

        // Get news feed for user 1
        List<Integer> feed1 = twitter.getNewsFeed(1);
        System.out.println("User 1 News Feed: " + feed1);

        // User 1 unfollows User 2
        twitter.unfollow(1, 2);

        // Get news feed again
        List<Integer> feed2 = twitter.getNewsFeed(1);
        System.out.println("User 1 News Feed after unfollow: " + feed2);
    }
}
