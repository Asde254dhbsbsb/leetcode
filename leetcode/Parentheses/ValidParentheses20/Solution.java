import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isValid(String s) {
        List<Character> parentheses = new ArrayList<>();
        parentheses.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int len = parentheses.size() - 1;
            Character cr = s.charAt(i);
            if(len > 0) {
                Character cl = parentheses.get(len);
                if (cl == '(' && cr == ')' || cl == '[' && cr == ']' || cl == '{' && cr == '}') {
                    parentheses.remove(len);
                } else parentheses.add(cr);
            } else parentheses.add(cr);
        }
        if(parentheses.size() == 0) return true;
        return false;
    }
}