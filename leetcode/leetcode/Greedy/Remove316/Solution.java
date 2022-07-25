package Greedy.Remove316;

import java.util.Stack;



public class Solution {
    // 思路就是 遇到一个新字符 如果比栈顶小 并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
    // hash记录数量！
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            if(!stack.contains(s.charAt(i))){            while(!stack.empty() && s.charAt(i) < stack.peek() ) {
                if(judgeSame(s, i + 1, stack.peek())) stack.pop();
                else break;
            }
            stack.push(s.charAt(i));}
        }
        StringBuilder sl = new StringBuilder();
        while(!stack.empty()) {
            sl.append(stack.remove(0));
        }
        return sl.toString();
    }

    boolean judgeSame(String s, int index, char top) {
        for(int i = index; i < s.length(); i++) {
            if(s.charAt(i) == top) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String s = "abacb"; 
        System.out.println(sl.removeDuplicateLetters(s));
    }
}
