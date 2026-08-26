package interview_ques.altimetrik;

/*
We are building a program to manage a gym's membership. The gym has multiple members,
 each with a unique ID, name, and membership status.
 The program allows gym staff to add new members, update members status, and get membership statistics.

Definitions:
* A "member" is an object that represents a gym member. It has properties for the ID, name, and
 membership status.
* A "membership" is a class which is used for managing members in the gym.

To begin with, we present you with two tasks:
1-1) Read through and understand the code below. Please take as much time as necessary, and
feel free to run the code.
1-2) The test for Membership is not passing due to a bug in the code.
Make the necessary changes to Membership to fix the bug.


We are currently updating our system to include information about workouts for our members.
As part of this update, we have introduced the Workout class, which represents a single workout session for a member.
Each object of the Workout class has a unique ID, as well as a start time and end time that
are represented in the number of minutes spent from the start of the day. You can assume that all the Workouts are from the same day.

To implement these changes, we need to add two functions to the Membership class:

2.1) The `addWorkout` function should be used to add a workout session for a member.
If the given member does not exist while calling this function, the workout can be ignored.

2.2) The `getAverageWorkoutDurations` function should calculate the average duration of workouts
for each member in minutes and return the results as a map.

To assist you in testing these new functions, we have provided the testGetAverageWorkoutDurations function.

*/

import java.util.*;
import java.util.stream.Collectors;


enum MembershipStatus {
    /*
        Membership Status is of three types: BRONZE, SILVER and GOLD.
        BRONZE is the default membership a new member gets.
        SILVER and GOLD are paid memberships for the gym.
    */
    BRONZE,
    SILVER,
    GOLD
}

class Workout {
    /**
     * This class represents a single workout session for a member.
     * Each object of the Workout class has a unique ID, as well as
     * a start time and end time that are represented in the number
     * of minutes spent from the start of the day.
     */

    private int id;
    private int startTime;
    private int endTime;

    public Workout(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getDuration() {
        return endTime - startTime;
    }
}

class Member {
    /* Data about a gym member.*/
    public int memberId;
    public String name;
    public MembershipStatus membershipStatus;

    public Member(int memberId, String name, MembershipStatus membershipStatus) {
        this.memberId = memberId;
        this.name = name;
        this.membershipStatus = membershipStatus;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name + ", Membership Status: " + membershipStatus;
    }
}

class Membership {
    /*
        Data for managing a gym membership, and methods which staff can
        use to perform any queries or updates.
    */
    public List<Member> members;
    private Workout workout;
    Map<Integer, List<Workout>> mapWorkOut = new HashMap<>();

    public Membership() {
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void updateMembership(int memberId, MembershipStatus membershipStatus) {
        for (Member member : members) {
            if (member.memberId == memberId) {
                member.membershipStatus = membershipStatus;
                break;
            }
        }
    }

    public void addWorkout(int memberId, Workout workout) {

// ::::: First approach ::::
//        for(Member member : members) {
//            if (member.memberId == memberId) {
//                if (!mapWorkOut.containsKey(memberId)) {
//                    List<Workout> workoutList = new ArrayList<>();
//                    workoutList.add(workout);
//                    mapWorkOut.put(memberId, workoutList);
//                } else {
//                    mapWorkOut.get(memberId).add(workout);
//                }
//            }
//        }

        // Second approach
        for (Member member : members) {
            if (member.memberId == memberId) {
                mapWorkOut.computeIfAbsent(memberId, k -> new ArrayList<>())
                        .add(workout);
                return; // workout added, exit method
            }
        }
        // Member not found -> ignore workout
    }

    public Map<Integer, Double> getAverageWorkoutDurations() {

        return mapWorkOut.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue()
                                .stream()
                                .collect(Collectors.averagingInt(Workout::getDuration))
                ));
    }


// ::::: Second Approach :::::
    
//    public Map<Integer, Double> getAverageWorkoutDurations() {
//        Map<Integer, Double> result = new HashMap<>();
//
//        for (Map.Entry<Integer, List<Workout>> entry : mapWorkOut.entrySet()) {
//            List<Workout> workouts = entry.getValue();
//            double avg = workouts.stream()
//                    .mapToInt(Workout::getDuration)
//                    .average()
//                    .orElse(0.0);
//
//            result.put(entry.getKey(), avg);
//        }
//        return result;
//    }

//    public Map<Integer, Double> getAverageWorkoutDuration() {
//        Map<Integer, Double> avgWrkDur = new HashMap<>();
//        for(Member member : members) {
//            if (member.memberId == memberId) {
//                if(!mapWorkOut.containsKey() ) {
//                    List<Workout> workoutList = new ArrayList<>();
//                    mapWorkOut.put(memberId, workoutList.add(workout));
//                } else {
//                    mapWorkOut.get(memberId).add(workout);
//                }
//
//            }
//        }
//
//        return mapWorkOut.stream()
//                .mapToObj(i -> (Double)i)
//                .map(Workout::getDuration)
//                .collect(Collectiors.toMap())
//
//    }

    public MembershipStatistics getMembershipStatistics() {
        int totalMembers = members.size();
        int totalPaidMembers = 0;
        for (Member member : members) {
            if (member.membershipStatus == MembershipStatus.GOLD ) {
                totalPaidMembers++;
            }
            if (member.membershipStatus == MembershipStatus.SILVER ) {
                totalPaidMembers++;
            }
        }
        double conversionRate = (totalPaidMembers / (double) totalMembers) * 100.0;
        return new MembershipStatistics(totalMembers, totalPaidMembers, conversionRate);
    }

}

class MembershipStatistics {
    /*
        Class for returning the getMembershipStatistics result
    */
    public int totalMembers;
    public int totalPaidMembers;
    public double conversionRate;

    public MembershipStatistics(int totalMembers, int totalPaidMembers, double conversionRate) {
        this.totalMembers = totalMembers;
        this.totalPaidMembers = totalPaidMembers;
        this.conversionRate = conversionRate;
    }
}

public class Solution {
    /*
        This is not a complete test suite, but tests some basic functionality of
        the code and shows how to use it.
    */
    public static void main(String[] args) {
        testMember();
        //addWorkout();
        testGetAverageWorkoutDurations();
        testMembership();
    }

    public static void testMember() {
        System.out.println("Running testMember");
        Member testMember = new Member(1, "John Doe", MembershipStatus.BRONZE);
        PrintAssert.assertEquals(1,testMember.memberId ,
                "Member ID should be 1, was " + testMember.memberId);
        PrintAssert.assertEquals("John Doe",testMember.name,
                "Member name should be \"John Doe\", was \"" + testMember.name + "\"");
        PrintAssert.assertEquals(MembershipStatus.BRONZE,testMember.membershipStatus,
                "Membership status should be BRONZE, was " + testMember.membershipStatus);
    }

    public static void testMembership() {
        System.out.println("Running testMembership");
        Membership testMembership = new Membership();
        Member testMember = new Member(1, "John Doe", MembershipStatus.BRONZE);
        testMembership.addMember(testMember);
        PrintAssert.assertEquals(1,testMembership.members.size(), "Members size should be 1, was " + testMembership.members.size());

        PrintAssert.assertEquals(testMember,testMembership.members.get(0),"First member should equal testMember");

        testMembership.updateMembership(1, MembershipStatus.SILVER);
        PrintAssert.assertEquals(MembershipStatus.SILVER,testMembership.members.get(0).membershipStatus,
                "Membership status should be SILVER, was " + testMembership.members.get(0).membershipStatus);

        Member testMember2 = new Member(2, "Alex C", MembershipStatus.BRONZE);
        testMembership.addMember(testMember2);

        Member testMember3 = new Member(3, "Marie C", MembershipStatus.GOLD);
        testMembership.addMember(testMember3);

        Member testMember4 = new Member(4, "Joe D", MembershipStatus.SILVER);
        testMembership.addMember(testMember4);

        Member testMember5 = new Member(5, "June R", MembershipStatus.BRONZE);
        testMembership.addMember(testMember5);

        Member testMember6 = new Member(6, "Westley D", MembershipStatus.SILVER);
        testMembership.addMember(testMember6);

        MembershipStatistics attendanceStats = testMembership.getMembershipStatistics();
        PrintAssert.assertEquals(6,attendanceStats.totalMembers,
                "Total members should be 6, was " + attendanceStats.totalMembers);
        PrintAssert.assertEquals(4,attendanceStats.totalPaidMembers,
                "Total paid members should be 4, was " + attendanceStats.totalPaidMembers);

    }

    public static void testGetAverageWorkoutDurations() {
        System.out.println("Running testGetAverageWorkoutDurations");
        Membership testMembership = new Membership();
        Member testMember1 = new Member(12, "John Doe", MembershipStatus.SILVER);
        testMembership.addMember(testMember1);

        Member testMember2 = new Member(22, "Alex Cleeve", MembershipStatus.BRONZE);
        testMembership.addMember(testMember2);

        Member testMember3 = new Member(31, "Marie Cardiff", MembershipStatus.GOLD);
        testMembership.addMember(testMember3);

        Member testMember4 = new Member(37, "George Costanza", MembershipStatus.SILVER);
        testMembership.addMember(testMember4);

        Workout testWorkout1 = new Workout(11, 10, 20);
        Workout testWorkout2 = new Workout(24, 15, 35);
        Workout testWorkout3 = new Workout(32, 45, 90);
        Workout testWorkout4 = new Workout(47, 100, 155);
        Workout testWorkout5 = new Workout(56, 120, 200);
        Workout testWorkout6 = new Workout(62, 300, 400);
        Workout testWorkout7 = new Workout(78, 1000, 1010);
        Workout testWorkout8 = new Workout(80, 1010, 1045);

        testMembership.addWorkout(12, testWorkout1);
        testMembership.addWorkout(22, testWorkout2);
        testMembership.addWorkout(31, testWorkout3);
        testMembership.addWorkout(12, testWorkout4);
        testMembership.addWorkout(22, testWorkout5);
        testMembership.addWorkout(31, testWorkout6);
        testMembership.addWorkout(12, testWorkout7);
        testMembership.addWorkout(4, testWorkout8);

        Map<Integer, Double> averageDurations = testMembership.getAverageWorkoutDurations();
        PrintAssert.assertEquals(averageDurations.get(12) ,25.0 , 0.1 ,
                "average duration for member 12 should be 25.0, was " + averageDurations.get(12));
        PrintAssert.assertEquals(averageDurations.get(22) ,50.0 , 0.1 ,
                "average duration for member 22 should be 50.0, was " + averageDurations.get(22));
        PrintAssert.assertEquals(averageDurations.get(31) ,72.5, 0.1 ,
                "average duration for member 31 should be 72.5, was " + averageDurations.get(31));
        PrintAssert.assertFalse(averageDurations.containsKey(4));
    }



    /* =============================
   Printable Assert Utility
   ============================= */
    class PrintAssert {

        static void assertFalse(boolean b) {
            if (b) {
                System.out.println("❌ FAILED: ");
                System.out.println("   Expected: " + b);
            } else {
                System.out.println("✅ PASSED: " + b);
            }
        }

        static void assertEquals(Object expected, Object actual, String testName) {
            if ((expected == null && actual == null) ||
                    (expected != null && expected.equals(actual))) {
                System.out.println("✅ PASSED: " + testName);
            } else {
                System.out.println("❌ FAILED: " + testName);
                System.out.println("   Expected: " + expected);
                System.out.println("   Actual  : " + actual);
            }
        }

        static void assertEquals(double expected, double actual, double delta, String testName) {
            if (Math.abs(expected - actual) <= delta) {
                System.out.println("✅ PASSED: " + testName);
            } else {
                System.out.println("❌ FAILED: " + testName);
                System.out.println("   Expected: " + expected);
                System.out.println("   Actual  : " + actual);
            }
        }

        static void assertArrayEquals(Object[] expected, Object[] actual, String testName) {
            if (expected == null && actual == null) {
                System.out.println("✅ PASSED: " + testName);
                return;
            }
            if (expected == null || actual == null || expected.length != actual.length) {
                failArray(expected, actual, testName);
                return;
            }
            for (int i = 0; i < expected.length; i++) {
                if (!expected[i].equals(actual[i])) {
                    failArray(expected, actual, testName);
                    return;
                }
            }
            System.out.println("✅ PASSED: " + testName);
        }

        static void assertNull(Object obj, String testName) {
            if (obj == null) {
                System.out.println("✅ PASSED: " + testName);
            } else {
                System.out.println("❌ FAILED: " + testName);
                System.out.println("   Expected: null");
                System.out.println("   Actual  : " + obj);
            }
        }

        private static void failArray(Object[] expected, Object[] actual, String testName) {
            System.out.println("❌ FAILED: " + testName);
            System.out.println("   Expected: " + java.util.Arrays.toString(expected));
            System.out.println("   Actual  : " + java.util.Arrays.toString(actual));
        }


    }
}

