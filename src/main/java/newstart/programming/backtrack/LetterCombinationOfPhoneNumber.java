package newstart.programming.backtrack;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */


public class LetterCombinationOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits == null || digits.length() == 0) return result;

        Map<Character, char[]> map = new HashMap();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] {'a','b','c'});
        map.put('3', new char[] {'d','e','f'});
        map.put('4', new char[] {'g','h','i'});
        map.put('5', new char[] {'j','k','l'});
        map.put('6', new char[] {'m','n','o'});
        map.put('7', new char[] {'p','q','r', 's'});
        map.put('8', new char[] {'t','u','v'});
        map.put('9', new char[] {'w','x','y', 'z'});
        StringBuilder sb = new StringBuilder();
        backtrack(digits, sb, map, result);
        return result;
    }

    public void backtrack(String digits, StringBuilder sb, Map<Character, char[]> map, List<String> result){
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for(Character d: map.get(digits.charAt(sb.length()))) {
            sb.append(d);
            backtrack(digits, sb, map, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
