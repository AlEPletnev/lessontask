package org.taskThree;

import java.util.*;
import java.util.stream.Collectors;

public class Task3 {

    public static List<Phone> createPhoneList(){
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone("88005553535", PhoneType.STATIONARY));
        phoneList.add(new Phone("88005553536", PhoneType.MOBILE));
        phoneList.add(new Phone("88005553537", PhoneType.STATIONARY));
        return phoneList;
    }

    public static List<Client> createClientList(){
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client(1,"Alex",21));
        clientList.add(new Client(2,"Sergey",25));
        clientList.add(new Client(3,"Masha",34));
        return clientList;
    }

    public static int calcSumAge(List<Client> clientList, String name){
        int sumAge = 0;
        for(Client client : clientList) {
            if (name.equalsIgnoreCase(client.getName())) {
                sumAge += client.getAge();
            }

        }
        return sumAge;
    }

    public static int calcSumAgeStream(List<Client> clientList, String name){
        return clientList.stream().filter(client->client.getName().equalsIgnoreCase(name))
                                  .reduce(0,(sum,client)->sum+client.getAge(),Integer::sum);
    }

    public static Set<String> getListClientName(List<Client> clientList){
        Set<String> setName = new LinkedHashSet<>();
        for(Client client : clientList){
            setName.add(client.getName());
        }
        return setName;
    }

    public static Set<String> getListClientNameStream(List<Client> clientList){
        return clientList.stream().map(Client::getName).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static boolean isContainClientWithAge(List<Client> clientList, int ageRequirement){
        for(Client client : clientList){
            if(client.getAge()>ageRequirement){
                return true;
            }
        }
        return false;
    }

    public static boolean isContainClientWidthAge(List<Client> clientList, int ageRequirement){
         return clientList.stream().noneMatch((client) -> client.getAge() > ageRequirement);
    }

    //Преобразовать массив в Map, у которой ключ - уникальный идентификатор, значение - имя.
    //Поддержать порядок, в котором клиенты добавлены в массив.!
    public static Map<Integer,String> getLinkedHashMap(List<Client> clientList){
        Map<Integer,String> map = new LinkedHashMap<>();
        if(clientList == null){
            return map;
        }
        for(Client client : clientList){
            map.put(client.getId(),client.getName());
        }
        return map;
    }

    // Вот тут в сторону ордеринг
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