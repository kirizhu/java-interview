package com.kirizhu;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String[] input = { "aaaasd","a", "aab","aaa", "aaabcd", "ef", "cssssssd", "fdz", "kf", "zc", "lklklklklklklklkl", "l"};
        sortByAs(input);
    }
    public static ArrayList<String> sortByAs(String[] input){

        Map<String, Integer> asHashMap = new HashMap<>();
        ArrayList<String> noAsArray = new ArrayList<>();
        for (String value : input) {
            if (!value.contains("a")) {
                noAsArray.add(value);
            } else {
                int numberOfAs = 0;
                for (int j = 0; j < value.length(); j++) {
                    if (value.charAt(j) == 'a') {
                        numberOfAs++;
                        asHashMap.put(value, numberOfAs);
                    }
                }
            }
        }
        noAsArray.sort((a, b) -> Integer.compare(b.length(), a.length()));

        Set<Map.Entry<String,Integer>> entrySet = asHashMap.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(entrySet);

        list.sort((o1, o2) -> {
            if (o2.getValue().compareTo(o1.getValue()) == 0) {
                return Integer.compare(o2.getKey().length(), o1.getKey().length());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        ArrayList<String> asArray = new ArrayList<>();
        list.forEach (s -> asArray.add(s.getKey()));


        asArray.addAll(noAsArray);
        System.out.println(asArray);
        return asArray;
    }


}
