package org.taskThree;

import java.util.*;
import java.util.stream.Collectors;

public class Task3 {

    public static int calcSumAgeStream(List<Client> clientList, String name){
        return clientList.stream().filter(client->client.getName().equalsIgnoreCase(name))
                                  .reduce(0,(sum,client)->sum+client.getAge(),Integer::sum);
    }

    public static Set<String> getListClientNameStream(List<Client> clientList){
        return clientList.stream().map(Client::getName).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static boolean isContainClientWidthAge(List<Client> clientList, int ageRequirement){
         return clientList.stream().noneMatch((client) -> client.getAge() > ageRequirement);
    }

    public static Map<Integer, String> getLinkedHashMapStream(List<Client> clientList){
        return clientList.stream()
                .collect(Collectors.toMap(Client::getId,Client::getName, (existing,replacement) -> existing,LinkedHashMap::new));
    }

    // Преобразовать массив в Map, у которой ключ - возраст, значение - коллекция клиентов с таким возрастом.
    public static Map<Integer, List<Client>> getMap2(List<Client> clientList){
        return clientList.stream().collect(Collectors.groupingBy(Client::getAge));
    }

    public static String getStringNumbers(List<Client> clientList){
        StringBuilder resultString = new StringBuilder();
        for(Client client : clientList){
            resultString.append(",").append(client.getPhoneList().stream().reduce("", (acc, phone) -> acc + "," + phone.getNumber(), String::concat));
        }
        return resultString.toString();
    }

    public static Client getOldest(List<Client> clientList, PhoneType phoneType){
        List<Client> resultClientList = clientList.stream()
                .filter(client -> client.getPhoneType() == phoneType)
                .sorted(Comparator.comparingInt(Client::getAge)).toList();
        return resultClientList.get(resultClientList.size()-1);
    }


}