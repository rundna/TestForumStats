package com.kodilla.testing.forum.statistics;
import java.util.*;

public class ForumStatistics {
    double usersCount;
    double comments;
    double posts;
    double avgPostPerUser;
    double avgCommPerUser;
    double avgCommPerPost;

    public void calculateAdvStatistics(Statistics statistics) {

        usersCount = statistics.usersNames().size();
        comments = statistics.commentsCount();
        posts= statistics.postsCount();
        

        if (usersCount == 0.0) {
            avgPostPerUser = 0.0;
            avgCommPerUser = 0.0;
        } else {
            avgPostPerUser = posts / usersCount;
            avgCommPerUser = comments / usersCount;
            //System.out.println("P " +avgPostPerUser);
            //System.out.println("C " + avgCommPerUser);
        }

        if (posts == 0.0) {
            avgCommPerPost = 0.0;
            //System.out.println(avgCommPerPost);
        } else {
            avgCommPerPost = comments / posts;
            //System.out.println("PC " +avgCommPerPost);
        }
    }
}
