package jz09;

import java.util.Stack;

class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack(); // 入栈
        s2 = new Stack(); // 出栈
    }
    
    public void appendTail(int value) {
        s1.push(value);
    }
    
    public int deleteHead() {
        if(!s2.empty()) return s2.pop();
        if(s1.empty()) return -1;
        while(!s1.empty()) s2.push(s1.pop());
        return s2.pop();
    }
}