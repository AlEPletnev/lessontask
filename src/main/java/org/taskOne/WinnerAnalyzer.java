package org.taskOne;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerAnalyzer {

    public static String showWinner(List<String> competitors) {
        String nameWinner = null;
        Integer countWinner = 0;
        Map<String, Integer> playerAnalytics = new HashMap<>();
        for(String pairNamePoint : competitors){
            String[] pair = pairNamePoint.split(" ");
            if(pair.length < 2){
                continue;
            }
            String namePlayer = pair[0];
            Integer pointPlayer = Integer.parseInt(pair[1]);
            if(playerAnalytics.containsKey(namePlayer)){
                Integer newPointPlayer = pointPlayer + playerAnalytics.get(namePlayer);
                if(newPointPlayer > countWinner){
                    countWinner = newPointPlayer;
                    nameWinner = namePlayer;
                }
                playerAnalytics.put(namePlayer,newPointPlayer);
            } else {
                if(pointPlayer > countWinner){
                    countWinner = pointPlayer;
                    nameWinner = namePlayer;
                }
                playerAnalytics.put(namePlayer,pointPlayer);
            }
        }
        return nameWinner;
    }

}
