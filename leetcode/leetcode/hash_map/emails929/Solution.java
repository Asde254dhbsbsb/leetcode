package leetcode.hash_map.emails929;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        int count = 0;
        int index = 0;
        Map<String, String> map = new HashMap<>();
        while(index < emails.length) {
            String tmp = "";
            tmp = getAddress(emails[index]);
            if(map.containsKey(tmp)) {
                
            } else {
                map.put(tmp, tmp);
                count++;
            }
            index ++;
        }
        return count;
    }

    String getAddress(String email) {
        String s = "";
        int index = 0;
        char c;
        while((c = email.charAt(index)) != '@') {
            if(c == '.') ;
            else if(c == '+') break; 
            else s += c; 
            index++;
        }
        while(email.charAt(index) != '@') index++;
        s += email.subSequence(index, email.length());
        return s;
    }

}
