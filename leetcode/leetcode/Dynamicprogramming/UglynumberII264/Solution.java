import java.util.PriorityQueue;

public class Solution {
    // 使用Double来扩充大小
    public int nthUglyNumber(int n) {
        // 最小堆或者优先队列直接放进去，出队而且比目前的最大抽数大；
        PriorityQueue<Double> pq = new PriorityQueue<>();
        int[] zI = {2,3,5};
        int count = 1;
        double answer = 1;
        while(count < n) {
            for(int i:zI) {
                pq.add((double)(answer*i));
            }
            answer = pq.peek();
            pq.poll();
            while(!pq.isEmpty() && pq.peek() == answer) pq.poll();
            // pre最小抽数
            count++;
        }
        return (int)answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 1601; i++) {
            System.out.println(s.nthUglyNumber(i));
        }
    }
}
