package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestForumStatistics {

    List<String> generateList(int items){
        List<String> list = new ArrayList<>();

        for(int i =0;i<items;i++){
            list.add("User"+i);
        }
        return list;
    }

    @Test
    public void testCalculateAdvStatistics () {
        Statistics statsMock = mock(Statistics.class);
        List<String> users = generateList(3);

        int comments = 20;
        int posts = 10;

        when(statsMock.usersNames()).thenReturn(users);
        when(statsMock.commentsCount()).thenReturn(comments);
        when(statsMock.postsCount()).thenReturn(posts);

        ForumStatistics testForum = new ForumStatistics(); //no constructor
        testForum.calculateAdvStatistics(statsMock);

        Assert.assertEquals(3.0, testForum.usersCount, 0.01);
        Assert.assertEquals(10.0, testForum.posts, 0.01);
        Assert.assertEquals(20.0, testForum.comments, 0.01);
        Assert.assertEquals(3.33, testForum.avgPostPerUser, 0.01);
        Assert.assertEquals(6.66, testForum.avgCommPerUser, 0.01);
        Assert.assertEquals(2.0, testForum.avgCommPerPost, 0.01);
    }

        @Test
        public void testCalculateAdvStatisticsWhenUsers0() {
            Statistics statsMock = mock(Statistics.class);
            List<String> users = generateList(0);

            int comments = 0;
            int posts = 0;

            when(statsMock.usersNames()).thenReturn(users);
            when(statsMock.commentsCount()).thenReturn(comments);
            when(statsMock.postsCount()).thenReturn(posts);

            ForumStatistics testForum = new ForumStatistics();
            testForum.calculateAdvStatistics(statsMock);

            Assert.assertEquals(0.0, testForum.usersCount, 0.01);
            Assert.assertEquals(0.0, testForum.posts, 0.01);
            Assert.assertEquals(0.0, testForum.comments, 0.01);
            Assert.assertEquals(0.0, testForum.avgPostPerUser, 0.01);
            Assert.assertEquals(0.0, testForum.avgCommPerUser, 0.01);
            Assert.assertEquals(0.0, testForum.avgCommPerPost, 0.01);
        }

    @Test
    public void testCalculateAdvStatisticsWhenUsers100() {
        Statistics statsMock = mock(Statistics.class);
        List<String> users = generateList(100);

        int comments = 0;
        int posts = 0;

        when(statsMock.usersNames()).thenReturn(users);
        when(statsMock.commentsCount()).thenReturn(comments);
        when(statsMock.postsCount()).thenReturn(posts);

        ForumStatistics testForum = new ForumStatistics();
        testForum.calculateAdvStatistics(statsMock);

        Assert.assertEquals(100.0, testForum.usersCount, 0.01);
        Assert.assertEquals(0.0, testForum.posts, 0.01);
        Assert.assertEquals(0.0, testForum.comments, 0.01);
        Assert.assertEquals(0.0, testForum.avgPostPerUser, 0.01);
        Assert.assertEquals(0.0, testForum.avgCommPerUser, 0.01);
        Assert.assertEquals(0.0, testForum.avgCommPerPost, 0.01);
    }
    @Test
    public void testCalculateAdvStatisticsWhenPosts1000Users100() {
        Statistics statsMock = mock(Statistics.class);
        List<String> users = generateList(100);

        int comments = 0;
        int posts = 1000;

        when(statsMock.usersNames()).thenReturn(users);
        when(statsMock.commentsCount()).thenReturn(comments);
        when(statsMock.postsCount()).thenReturn(posts);

        ForumStatistics testForum = new ForumStatistics();
        testForum.calculateAdvStatistics(statsMock);

        Assert.assertEquals(100.0, testForum.usersCount, 0.01);
        Assert.assertEquals(1000.0, testForum.posts, 0.01);
        Assert.assertEquals(0.0, testForum.comments, 0.01);
        Assert.assertEquals(10.0, testForum.avgPostPerUser, 0.01);
        Assert.assertEquals(0.0, testForum.avgCommPerUser, 0.01);
        Assert.assertEquals(0.0, testForum.avgCommPerPost, 0.01);
    }
    @Test
    public void testCalculateAdvStatisticsWhenPosts1000Users0() {
        Statistics statsMock = mock(Statistics.class);
        List<String> users = generateList(0);

        int comments = 0;
        int posts = 1000;

        when(statsMock.usersNames()).thenReturn(users);
        when(statsMock.commentsCount()).thenReturn(comments);
        when(statsMock.postsCount()).thenReturn(posts);

        ForumStatistics testForum = new ForumStatistics();
        testForum.calculateAdvStatistics(statsMock);

        Assert.assertEquals(0.0, testForum.usersCount, 0.01);
        Assert.assertEquals(1000.0, testForum.posts, 0.01);
        Assert.assertEquals(0.0, testForum.comments, 0.01);
        Assert.assertEquals(0.0, testForum.avgPostPerUser, 0.01);
        Assert.assertEquals(0.0, testForum.avgCommPerUser, 0.01);
        Assert.assertEquals(0.0, testForum.avgCommPerPost, 0.01);
    }
    @Test
    public void testCalculateAdvStatisticsWhenCommentsLessPostsUsers0() {
        Statistics statsMock = mock(Statistics.class);
        List<String> users = generateList(0);

        int comments = 200;
        int posts = 1000;

        when(statsMock.usersNames()).thenReturn(users);
        when(statsMock.commentsCount()).thenReturn(comments);
        when(statsMock.postsCount()).thenReturn(posts);

        ForumStatistics testForum = new ForumStatistics();
        testForum.calculateAdvStatistics(statsMock);

        Assert.assertEquals(0.0, testForum.usersCount, 0.01);
        Assert.assertTrue(testForum.comments<testForum.posts);
        Assert.assertEquals(200.0, testForum.comments, 0.01);
        Assert.assertEquals(1000.0, testForum.posts, 0.01);
        Assert.assertEquals(0.0, testForum.avgPostPerUser, 0.01);
        Assert.assertEquals(0.0, testForum.avgCommPerUser, 0.01);
        Assert.assertEquals(0.2, testForum.avgCommPerPost, 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWhenCommentsMorePostsUsers0() {
        Statistics statsMock = mock(Statistics.class);
        List<String> users = generateList(0);

        int comments = 2000;
        int posts = 800;

        when(statsMock.usersNames()).thenReturn(users);
        when(statsMock.commentsCount()).thenReturn(comments);
        when(statsMock.postsCount()).thenReturn(posts);

        ForumStatistics testForum = new ForumStatistics();
        testForum.calculateAdvStatistics(statsMock);

        Assert.assertEquals(0.0, testForum.usersCount, 0.01);
        Assert.assertTrue(testForum.comments>testForum.posts);
        Assert.assertEquals(2000.0, testForum.comments, 0.01);
        Assert.assertEquals(800.0, testForum.posts, 0.01);
        Assert.assertEquals(0.0, testForum.avgPostPerUser, 0.01);
        Assert.assertEquals(0.0, testForum.avgCommPerUser, 0.01);
        Assert.assertEquals(2.5, testForum.avgCommPerPost, 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWhenCommentsMorePostsUsers100() {
        Statistics statsMock = mock(Statistics.class);
        List<String> users = generateList(100);

        int comments = 2000;
        int posts = 800;

        when(statsMock.usersNames()).thenReturn(users);
        when(statsMock.commentsCount()).thenReturn(comments);
        when(statsMock.postsCount()).thenReturn(posts);

        ForumStatistics testForum = new ForumStatistics();
        testForum.calculateAdvStatistics(statsMock);

        Assert.assertEquals(100.0, testForum.usersCount, 0.01);
        Assert.assertTrue(testForum.comments>testForum.posts);
        Assert.assertEquals(2000.0, testForum.comments, 0.01);
        Assert.assertEquals(800.0, testForum.posts, 0.01);
        Assert.assertEquals(8.0, testForum.avgPostPerUser, 0.01);
        Assert.assertEquals(20.0, testForum.avgCommPerUser, 0.01);
        Assert.assertEquals(2.5, testForum.avgCommPerPost, 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWhenCommentsLessPostsUsers100() {
        Statistics statsMock = mock(Statistics.class);
        List<String> users = generateList(100);

        int comments = 20;
        int posts = 800;

        when(statsMock.usersNames()).thenReturn(users);
        when(statsMock.commentsCount()).thenReturn(comments);
        when(statsMock.postsCount()).thenReturn(posts);

        ForumStatistics testForum = new ForumStatistics();
        testForum.calculateAdvStatistics(statsMock);

        Assert.assertEquals(100.0, testForum.usersCount, 0.01);
        Assert.assertTrue(testForum.comments<testForum.posts);
        Assert.assertEquals(20.0, testForum.comments, 0.01);
        Assert.assertEquals(800.0, testForum.posts, 0.01);
        Assert.assertEquals(8.0, testForum.avgPostPerUser, 0.01);
        Assert.assertEquals(0.2, testForum.avgCommPerUser, 0.01);
        Assert.assertEquals(0.025, testForum.avgCommPerPost, 0.01);
    }



    }


