package org.taskFour;

import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
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
        System.out.println(foundFriend.contains(natasha));
        foundFriend = service.searchForFriendsInWidth(vasilii, "Наташа");
        System.out.println(foundFriend.contains(natasha));
    }
}
