package MonotonicStack.RemoveKInteger402;

import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        for(int i = 1; i < num.length(); i++) {
            while(k > 0 && !stack.empty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k > 0 && !stack.empty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()) sb.append(stack.remove(0));
        while(sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        } 
        return sb.toString() == "" ? "0" : sb.toString();
    }
}
