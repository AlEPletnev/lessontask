package org.taskFour;

import java.util.*;

public final class SearchServiceImpl implements SearchService{

    private Set<User> setForSearchInDepth;

    private Set<User> setForSearchInWidth;

    private Deque<User> dequeFriend;

    @Override
    public List<User> searchForFriendsInWidth(User me, String name) {
        this.dequeFriend = new LinkedList<>();
        this.setForSearchInWidth = new HashSet<>();
        getAllFriendInWidth(me);
        return this.setForSearchInWidth.stream().filter(friend->friend.getName().equalsIgnoreCase(name)).toList();

    }

    @Override
    public List<User> searchForFriendsInDepth(User me, String name) {
        this.setForSearchInDepth = new HashSet<>();
        getAllFriendsInDepth(me);
        return this.setForSearchInDepth.stream().filter(friend->friend.getName().equalsIgnoreCase(name)).toList();
    }

    public void getAllFriendsInDepth(User me){
        List<User> list = me.getListFriends();
        if(list != null & !(list.isEmpty())){
            for(User user : list){
                if(!this.setForSearchInDepth.contains(user)){
                    this.setForSearchInDepth.add(user);
                    getAllFriendsInDepth(user);
                }
            }
        }
    }

    public void getAllFriendInWidth(User me){
        List<User> list = me.getListFriends();
        if(list != null & !(list.isEmpty())){
             for(User user : list){
                 if(!this.setForSearchInWidth.contains(user)){
                     this.setForSearchInWidth.add(user);
                     this.dequeFriend.add(user);
                 }
             }
             if(!this.dequeFriend.isEmpty()){
                 getAllFriendInWidth(this.dequeFriend.removeFirst());
             }
        }
    }
}
