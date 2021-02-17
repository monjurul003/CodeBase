package newstart.programming.backtrack;


import java.util.ArrayList;
import java.util.List;

/*784. Letter Case Permutation
Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
* */
public class LetterCaseCombination {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList();
        if (S == null || S.length() == 0)
            return result;

        StringBuilder sb = new StringBuilder();
        backTrack(result, 0, S.length(), sb, S);
        return result;
    }

    private void backTrack(List<String> result, int i, int max, StringBuilder sb, String str) {
        if (i == max) {
            result.add(sb.toString());
            return;
        }
        char ch = str.charAt(i);
        if (Character.isLetter(ch)) {
            sb.append(Character.toLowerCase(ch));
            backTrack(result, i + 1, max, sb, str);
            sb.setLength(sb.length() - 1);
            sb.append(Character.toUpperCase(ch));
            backTrack(result, i + 1, max, sb, str);
            sb.setLength(sb.length() - 1);

        } else {
            sb.append(ch);
            backTrack(result, i + 1, max, sb, str);
            sb.setLength(sb.length() - 1);
        }
    }

}
