package org.taskFour;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class User {

    private Long id;

    private final String name;

    private List<User> listFriends = new ArrayList<>();

    public User(String name){
        this.name = name;
        this.id = new Random().nextLong();
    }

    public String getName() {
        return name;
    }

    public List<User> getListFriends() {
        return new ArrayList<>(this.listFriends);
    }

    public void addFriend(User friend){
        this.listFriends.add(friend);
    }

    public void addFriend(List<User> friends){
        for(User friend : friends){
            this.addFriend(friend);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
