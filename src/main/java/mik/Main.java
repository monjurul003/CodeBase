package mik;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String StringChallenge(String str1, String str2) {
        // code goes here
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0 ||str1.length() < str2.length()) {
            return "false";
        }

        Map<Character, Integer> map = new HashMap();
        //counting each character in the string. If the input limits to a~z then I could use char array instead
        for(char ch : str2.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)-1);
        }
        String result = "true";
        for(char ch : map.keySet()) {
            if(map.get(ch) > 0) {
                result = "false";
                break;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        // keep this function call here

        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge("cdoer", "codelr"));
    }
}
