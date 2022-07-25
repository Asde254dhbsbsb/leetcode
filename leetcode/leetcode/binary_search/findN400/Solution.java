package findN400;

class Solution {

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.findNthDigit(2147483647));
        int[] a = sl.getRank(250954974);
        System.out.println("a[0] = " + a[0] + "a[1] = " + a[1]);
    }
    public int findNthDigit(int n) {
        // 在10到n之间二分
        int left = 10, right = n;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            int[] a = getRank(mid);
            if(a[0] == -1) {
                right = mid - 1;
            }
            else if(a[0] > n) {
                right = mid - 1;
            }
            else if(a[1] < n) {
                left = mid + 1;
            }
            else {
                // 说明就是这个数,是这个数的第几位？===>
                int i = n - a[0];
                String s = Integer.toString(mid);
                return s.charAt(i) - '0';
            }
        }
        return n;
    }

    int[] getRank(int n) {
        int size = String.valueOf(n).length();
        long rank = 0, preMax = 1;
        for(int i = 1; i < size; i++) {
            long tmpMax = preMax * 10;
            rank += (tmpMax - preMax) * i;
            preMax = tmpMax;
        }

        rank += (n - preMax) * size;
        String s = String.valueOf(rank);
        int[] a = new int[2];
        try {
            int i = Integer.valueOf(s);
            a[0] = i + 1;
            if(a[0] < i) throw new NumberFormatException();
            a[1] = i + size;
            if(a[1] < i) a[1] = Integer.MAX_VALUE;
        } catch (NumberFormatException e) {
            a[0] = -1;
            a[1] = -1;
        } 
        
        return a;
    }
}