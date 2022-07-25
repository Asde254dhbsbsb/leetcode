package leetcode.merage_sort;

import java.util.ArrayList;
import java.util.List;

public class MerageSort {

    // 两个数组足以 
    public ListNode sortList(ListNode head) {
        // left 到mid
        List<Integer> valList = new ArrayList<>();
        while(head != null) {
            valList.add(head.val);
            head = head.next;
        } // 获取了
        
        int[] a = new int[valList.size()];
        int[] tmp = new int[valList.size()];
        for (int i = 0; i < tmp.length; i++) {
            a[i] = valList.get(i);
        }
        mergeSort(a, tmp, 0, a.length - 1);
        ListNode pre = null;
        for (int i = 0; i < tmp.length; i++) {
            if(i == 0) {
                head = new ListNode(a[0], null);
                pre = head;
            } else {
                ListNode tmpNode = new ListNode(a[i], null);
                pre.next = tmpNode;
                pre = tmpNode;
            }
            
        }
        return head;
    }

    void mergeSort(int[] a, int[] tmp, int left, int right) {
        // 使得左部、右部有序即可
        if(left < right) {
            int mid = (right - left)/2 + left;
            mergeSort(a, tmp, left, mid);
            mergeSort(a, tmp, mid + 1, right);
            merge(a, tmp, left, mid, right);
        }
    }

    void merge(int[] a, int[] tmp, int leftPos, int leftEnd, int rightEnd) {
        // 在rightPos到rightEnd里面 进行排序；
        int tmpPos = leftPos, rightPos = leftEnd + 1;
        int left = leftPos, right = rightEnd;
        
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if(rightPos == 10) System.out.println("1111");
            if(a[leftPos] <= a[rightPos]) 
                tmp[tmpPos++] = a[leftPos++];
            else 
                tmp[tmpPos++] = a[rightPos++];            
        }
        // 拷贝剩余的
        for (int i = leftPos; i <= leftEnd; i++) 
            tmp[tmpPos++] = a[i];
    
        for (int i = rightPos; i <= rightEnd; i++) 
            tmp[tmpPos++] = a[i];
        
        while(left <= right) 
            a[left] = tmp[left++]; // 只加一次

        
    }

    public static void main(String[] args) {
        int[] a = {2,4,1,6,4,5,1,12,3,10};
        int[] tmp = new int[a.length];
        MerageSort ms = new MerageSort();
        ms.mergeSort(a, tmp, 0, a.length - 1);
        for(int i:a) System.out.println("i="+i);
    }
}