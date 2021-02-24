package newstart.programming.romannumber;

import java.util.HashMap;
import java.util.Map;

public class RomanConverter {
    /*
    13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3

Example 2:

Input: s = "IV"
Output: 4

Example 3:

Input: s = "IX"
Output: 9

Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    * */

    public void initMap(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        map.put('E', 5000);
    }

    public int romanToInt(String s) {
        int sum = 0;
        if (s == null || s.length() == 0) return sum;

        Map<Character, Integer> map = new HashMap();
        initMap(map);
        char prev = 'E';
        for (Character cur : s.toCharArray()) {
            sum += map.get(cur);
            if (map.get(prev) < map.get(cur)) {
                sum -= 2 * map.get(prev);
            }
            prev = cur;
        }
        return sum;
    }

    /*12. Integer to Roman
    Example 1:

    Input: num = 3
    Output: "III"

    Example 2:

    Input: num = 4
    Output: "IV"

    Example 3:

    Input: num = 9
    Output: "IX"

    Example 4:

    Input: num = 58
    Output: "LVIII"
    Explanation: L = 50, V = 5, III = 3.

    Example 5:

    Input: num = 1994
    Output: "MCMXCIV"
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4
    * */
    public String intToRoman(int num) {
        String s = "";
        if (num <= 0 || num >= 3999) return s;
        String[] ones = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = new String[]{"X", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = new String[]{"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = new String[]{"M", "MM", "MMM"};

        return thousands[num/1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + ones[(num%10)];
    }
}
