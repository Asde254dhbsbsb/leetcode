public class Main {

    public static void main(String[] args) {
        int[] nums = {1,2,1,4,4,4,5};
        quickSort2(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(" " + nums[i]);
        }
    }
    public static void quickSort1(int[] nums, int start, int end){
        if(start>end) return;
        int i=start, j=end;
        int base=nums[start]; // 以首个数为标志
        while (i<j){
            while (i<j && nums[j]>=base) j--;
            while (i<j && nums[i]<=base) i++;
            if(i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,start,i);
        quickSort1(nums,start,j-1);
        quickSort1(nums,j+1,end);
    }

    public static void quickSort2(int[] nums, int start, int end){
        if(start>end) return;
        int i=start, j=end;
        int base=nums[end]; // 以首个数为标志 {2 , 1}; base 1
        while (i<j){ 
            while (i < j && nums[i] <= base) i++;
            while (i < j && nums[j] >= base) j--;
            if(i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,end,j);
        quickSort2(nums,start,j-1);
        quickSort2(nums,j+1,end);
    }

    public static void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

}
