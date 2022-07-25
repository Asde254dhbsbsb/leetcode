

class PerfectPair {
    public long countExcellentPairs(int[] nums, int k) {
        long count = 0;
        // 为了消除重复，同一个num1不能和上一个相等，
        int[] numb = new int[61];
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            numb[moreThanK(nums[i])]++ ;
        }
        // 两数之和大于等于k的
        for(int i = 0; i < 61; i++) {
            if(numb[i] != 0) {
                for(int j = k - i > 0 ? k - i : 0; j < 61; j++) {
                    count += (numb[j] * numb[i]);
                }
            }
        }
        return count;
    }

    static int moreThanK(int num) {
        //比较num的0的个数
        int count = 0;
        while(num != 0) {
            if((num & 0x1) == 1) {
                count++;
            }
            num >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        PerfectPair ps = new PerfectPair();
        int[] nums = {1,2,4,8,16,32,64,128,256};
        int k = 2;

        System.out.println(ps.countExcellentPairs(nums, k));;
    }
}