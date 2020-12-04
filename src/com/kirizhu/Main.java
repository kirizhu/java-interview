package com.kirizhu;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String[] input = { "aaaasd","a", "aab","aaa", "aaabcd", "ef", "cssssssd", "fdz", "kf", "zc", "lklklklklklklklkl", "l"};
        String[] strings = { "apple", "pie", "apple", "red", "red", "red"};
        System.out.println(sortByAs(input));
        System.out.println(recursiveOutput(9));
        System.out.println(mostRepeatedString(strings));
    }
    public static ArrayList<String> sortByAs(String[] input){

        Map<String, Integer> asHashMap = new HashMap<>();

        for (String value : input) {
                int numberOfAs = 0;
                for (int j = 0; j < value.length(); j++) {
                    if (value.charAt(j) == 'a') {
                        numberOfAs++;
                        asHashMap.put(value, numberOfAs);
                    }
                }
            asHashMap.put(value, numberOfAs);
        }
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

        return asArray;
    }

    public static ArrayList<Integer> ouputArray = new ArrayList<>();
    public static ArrayList<Integer> recursiveOutput(Integer input){
        if (input <=2){
            ouputArray.add(input);
            ouputArray.sort(Comparator.naturalOrder());
            return ouputArray;
        }
        ouputArray.add(input);
        return recursiveOutput(input/2);
    }

    public static String mostRepeatedString(String[] input){
        Map<String, Integer> stringIntegerHashMap = new HashMap<>();
        int mostRepeats = 0;
        String answer = "";
        for (String s : input) {
            if (!stringIntegerHashMap.containsKey(s)) {
                stringIntegerHashMap.put(s, 1);
            } else {
                int oldValue = stringIntegerHashMap.get(s);
                stringIntegerHashMap.replace(s, oldValue, oldValue + 1);
            }
            if (stringIntegerHashMap.get(s) > mostRepeats) {
                mostRepeats = stringIntegerHashMap.get(s);
                answer = s;
            }
        }
        return answer;
    }
}
