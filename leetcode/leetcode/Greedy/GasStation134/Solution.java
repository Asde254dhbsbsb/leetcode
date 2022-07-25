package Greedy.GasStation134;
    // 类似于求最大连续整数和？
public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 1) return gas[0] - cost[0] < 0 ? -1 : 0;
        int begin = 0;
        int totalGas = gas[0] - cost[0];
        int index = 1;
        while(true) {
            if(totalGas < 0) {
                if(index <= begin) return -1;
                begin = index;
                totalGas = gas[begin] - cost[begin];
            }
            else if(totalGas >= 0 && index == begin) {
                return begin;
            } else 
                totalGas += gas[index] - cost[index];

            index = (index + 1 + gas.length) % gas.length; 
        }
    }
    // 简便方法！ 一次遍历 ，最后sumGas >= costGas才能一定能开完全程！！！
    // int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
    //     int rest = 0, run = 0, start = 0;
    //     for (int i = 0; i < gas.size(); ++i){
    //         run += (gas[i] - cost[i]);
    //         rest += (gas[i] - cost[i]);
    //         if (run < 0){
    //             start = i + 1;
    //             run = 0;
    //         }
    //     }
    //     return rest < 0 ? -1: start;
    // }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(
            sl.canCompleteCircuit(gas, cost)
        );
    }
}
