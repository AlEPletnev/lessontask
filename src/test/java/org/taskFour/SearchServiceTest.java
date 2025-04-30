package org.taskFour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SearchServiceTest {

    @Test
    public void test1(){
        User vasilii = new User("Василий");
        User arina = new User("Арина");
        User yulya = new User("Юля");
        User evgenii = new User("Евгений");
        User konstantin = new User("Константин");
        User vladimir = new User("Владимир");
        User mariya = new User("Мария");
        User dmitrii = new User("Дмитрий");
        User anatolii = new User("Анатолий");
        User gennadii = new User("Геннадий");
        User anna = new User("Анна");
        User mikhail = new User("Михаил");
        User sergei = new User("Сергей");
        User natasha = new User("Наташа");
        vasilii.addFriend(Arrays.asList(arina, yulya));
        arina.addFriend(Arrays.asList(vasilii, dmitrii));
        yulya.addFriend(Arrays.asList(vasilii, konstantin, evgenii));
        evgenii.addFriend(Arrays.asList(yulya, natasha));
        konstantin.addFriend(Arrays.asList(yulya, vladimir, mariya, natasha));
        vladimir.addFriend(Arrays.asList(konstantin, mariya));
        mariya.addFriend(Arrays.asList(konstantin, vladimir));
        dmitrii.addFriend(Arrays.asList(arina, anatolii, sergei));
        anatolii.addFriend(Arrays.asList(dmitrii, gennadii, mikhail));
        gennadii.addFriend(Arrays.asList(anatolii, anna));
        anna.addFriend(Arrays.asList(gennadii, mikhail));
        mikhail.addFriend(Arrays.asList(anatolii, sergei, anna, natasha));
        sergei.addFriend(Arrays.asList(dmitrii, mikhail));
        natasha.addFriend(Arrays.asList(konstantin, evgenii, mikhail));

        SearchServiceImpl service = new SearchServiceImpl();
        List<User> foundFriend = service.searchForFriendsInDepth(vasilii,"Наташа");
        Assertions.assertTrue(foundFriend.contains(natasha));
        foundFriend = service.searchForFriendsInWidth(vasilii, "Наташа");
        Assertions.assertTrue(foundFriend.contains(natasha));
    }

    @Test
    public void test2() {
        User vasilii = new User("Василий");
        User arina = new User("Арина");
        User yulya = new User("Юля");
        User evgenii = new User("Евгений");
        User konstantin = new User("Константин");
        User vladimir = new User("Владимир");
        User mariya = new User("Мария");
        User dmitrii = new User("Дмитрий");
        User anatolii = new User("Анатолий");
        User gennadii = new User("Геннадий");
        User anna = new User("Анна");
        User mikhail = new User("Михаил");
        User sergei = new User("Сергей");
        User natasha = new User("Наташа");
        User natasha2 = new User("Наташа");
        vasilii.addFriend(Arrays.asList(arina, yulya));
        arina.addFriend(Arrays.asList(vasilii, dmitrii, natasha2));
        yulya.addFriend(Arrays.asList(vasilii, evgenii));
        evgenii.addFriend(Arrays.asList(yulya));
        konstantin.addFriend(Arrays.asList(vladimir, mariya));
        vladimir.addFriend(Arrays.asList(konstantin));
        mariya.addFriend(Arrays.asList(konstantin, vasilii));
        dmitrii.addFriend(Arrays.asList(arina, anatolii, natasha));
        anatolii.addFriend(Arrays.asList(dmitrii, gennadii));
        gennadii.addFriend(Arrays.asList(anatolii));
        anna.addFriend(Arrays.asList(mikhail));
        mikhail.addFriend(Arrays.asList(sergei, anna));
        sergei.addFriend(Arrays.asList(natasha, mikhail));
        natasha.addFriend(Arrays.asList(dmitrii, sergei));
        natasha2.addFriend(Arrays.asList(arina));

        SearchService service = new SearchServiceImpl();

        List<User> foundFriends = service.searchForFriendsInDepth(vasilii, "Наташа");
        Assertions.assertTrue(foundFriends.contains(natasha));
        Assertions.assertTrue(foundFriends.contains(natasha2));
        foundFriends = service.searchForFriendsInWidth(vasilii, "Наташа");
        Assertions.assertTrue(foundFriends.contains(natasha));
        Assertions.assertTrue(foundFriends.contains(natasha2));
    }

    @Test
    public void test3() {
        User vasilii = new User("Василий");
        User arina = new User("Арина");
        User mariya = new User("Мария");
        User vladimir = new User("Владимир");
        User evgenii = new User("Евгений");
        User yulya = new User("Юля");
        User konstantin = new User("Константин");
        User dmitrii = new User("Дмитрий");
        User natasha = new User("Наташа");
        vasilii.addFriend(Arrays.asList(arina, mariya, vladimir, evgenii));
        arina.addFriend(Arrays.asList(vasilii, dmitrii, vasilii));
        yulya.addFriend(Arrays.asList(konstantin, evgenii, vladimir, dmitrii));
        evgenii.addFriend(Arrays.asList(yulya, vasilii, dmitrii));
        konstantin.addFriend(Arrays.asList(vladimir, mariya, yulya, natasha));
        vladimir.addFriend(Arrays.asList(konstantin, vasilii, yulya));
        mariya.addFriend(Arrays.asList(konstantin, vasilii, natasha));
        dmitrii.addFriend(Arrays.asList(arina, evgenii, natasha, yulya));
        natasha.addFriend(Arrays.asList(dmitrii, arina, konstantin, mariya));
        SearchService service = new SearchServiceImpl();
        List<User> foundFriends = service.searchForFriendsInDepth(vasilii, "Наташа");
        Assertions.assertTrue(foundFriends.contains(natasha));
        foundFriends = service.searchForFriendsInWidth(vasilii, "Наташа");
        Assertions.assertTrue(foundFriends.contains(natasha));
    }
}
