import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.generateParenthesis(2);
    }
    public List<String> generateParenthesis(int n) {
        // dp[n] 前面有几对括号 
        // '('   ')' 
        List<List<String>> parenthesisList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("");
        List<String> list2 = new ArrayList<>();
        list2.add("()");
        parenthesisList.add(list1);
        parenthesisList.add(list2);
        for (int i = 2; i <= n; i++) {
            List<String> tmpList = new ArrayList<>(); 
            for(int j = 0; j < i; j++) {
                for(String lefString:parenthesisList.get(j)) {
                    for(String rightString: parenthesisList.get(i-j-1)) {
                        tmpList.add('(' + lefString + ')' + rightString);
                    }
                }
            }
            parenthesisList.add(tmpList);
        }
        return parenthesisList.get(n);
    }

// ------ 只要保证左括号数目小于右括号即可---在相等的时候只是要左括号 ，依次递归
    // List<String> res = new ArrayList<>();
    // public List<String> generateParenthesis(int n) {
    //     if(n <= 0){
    //         return res;
    //     }
    //     getParenthesis("",n,n);
    //     return res;
    // }

    // private void getParenthesis(String str,int left, int right) {
    //     if(left == 0 && right == 0 ){
    //         res.add(str);
    //         return;
    //     }
    //     if(left == right){
    //         //剩余左右括号数相等，下一个只能用左括号
    //         getParenthesis(str+"(",left-1,right);
    //     }else if(left < right){
    //         //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
    //         if(left > 0){
    //             getParenthesis(str+"(",left-1,right);
    //         }
    //         getParenthesis(str+")",left,right-1);
    //     }
    // }
    
}
