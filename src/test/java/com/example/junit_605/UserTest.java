package com.example.junit_605;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

   private User user;
   private User user1;
   private User user2;
   private User user3;

   private User userNotAdd;
   private User userNotAdd1;

   @Before
    public void setUp() throws Exception{
         user = new User("Jenya", 35, Sex.MALE);
         user1 = new User("Vlad", 17, Sex.MALE);
         user2 = new User("Marina", 25, Sex.FEMALE);
         user3 = new User("Kristina", 18, Sex.FEMALE);

         userNotAdd = new User("", 0, null);
         userNotAdd1 = new User(null,0,null);
    }

    @Test
   public void getAllUsers() {

        List<User> expected = User.getAllUsers();

        List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);
        actual.add(user3);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetAllUsers_NOT_NULL() {
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void testGetAllUsers_SEX_MALE() {

        List<User> expected = User.getAllUsers(Sex.MALE);

        List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetAllUsers_SEX_FEMALE() {

        List<User> expected = User.getAllUsers(Sex.FEMALE);

        List<User> actual = new ArrayList<>();
        actual.add(user2);
        actual.add(user3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllUsers_MALE_NO_NULL(){
        List<User> expected = User.getAllUsers(Sex.MALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void testGetAllUsers_FEMALE_NO_NULL(){
        List<User> expected = User.getAllUsers(Sex.FEMALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getHowManyUsers() {

        int expected = User.getHowManyUsers();

        int actual = 4;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetHowManyUsers_FEMALE() {

        int expected = User.getHowManyUsers(Sex.FEMALE);

        int actual = 2;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetHowManyUsers_MALE() {

        int expected = User.getHowManyUsers(Sex.MALE);

        int actual = 2;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllAgeUsers() {

        int expected = User.getAllAgeUsers();

        int actual = 35+17+25+18;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllAgeUsers_MALE(){

        int expected = User.getAllAgeUsers(Sex.MALE);
        int actual = 17+35;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllAgeUsers_FEMALE(){

        int expected = User.getAllAgeUsers(Sex.FEMALE);

        int actual = 25 + 18;

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void getAverageAgeOfAllUsers() {
        int expected = User.getAverageAgeOfAllUsers();

        int actual = (25+18+17+35) / 4;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageAgeOfAllUsers_MALE() {
        int expected = User.getAverageAgeOfAllUsers(Sex.MALE);
        int actual = (17+35) / 2;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetAverageAgeOfAllUsers_FEMALE(){
        int expected = User.getAverageAgeOfAllUsers(Sex.FEMALE);

        int actual = (25+18) /2;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void newUser_EMPTY_NAME() {

        for (User user : User.getAllUsers()) {
            if (user.getName() != null && user.getName().isEmpty()) {
                Assert.fail("Попытка создания пользователя с пустым именем");
            }
        }

    }

    @Test
    public void newUser_AGE_ZERO(){
       for(User user : User.getAllUsers()){
           if (user.getAge() <= 0){
               Assert.fail("Попытка создания пользователя c не допустимым возрастом");
           }
       }
    }

    @Test
    public void newUser_SEX_NO_NULL(){
       for(User user: User.getAllUsers()){
           if (user.getSex() == null){
               Assert.fail("Попытка создания пользователя с указанием пола = null");
           }
       }
    }

}