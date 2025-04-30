package org.taskTwo;

import java.util.*;

public class TopAnalyzer {

    public static List<Post> getTop10(List<Post> list){
        Comparator<Post> comparator = (Post1, Post2) -> Post2.getLikesCount() - Post1.getLikesCount();
        list.sort(comparator);
        List<Post> listWithTop10 = new ArrayList<>();
        for(int i = 0; i <= 9; i++){
            listWithTop10.add(list.get(i));
        }
        return listWithTop10;
    }

}
