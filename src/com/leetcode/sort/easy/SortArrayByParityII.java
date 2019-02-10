package com.leetcode.sort.easy;

import java.util.Arrays;

/**
 * 【按奇偶排序数组 II】
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * 提示：
 *
 * 1:   2 <= A.length <= 20000
 * 2:   A.length % 2 == 0
 * 3:   0 <= A[i] <= 1000
 */
public class SortArrayByParityII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2,3,1,1,4,0,0,4,3,3})));
    }

    /**
     *  空间复杂度O1
     */
    private static int[] sortArrayByParityII(int[] A) {
        int start = 0,end = A.length-1;
        while (start<=end){
            while (start<=end&&((start%2==0&&A[start]%2==0)||(start%2!=0&&A[start]%2!=0))){
                start++;
            }
            if (start<end && start%2==0){
                int index = -1;
                for (int i = start;i<=end;i++){
                    if (A[i]%2==0){
                        index = i;
                        break;
                    }
                }
                if (index==-1){
                    return null;
                }else {
                    swap(A,start,index);
                    start++;
                }
            }else if(start<end && start%2!=0){
                int index = -1;
                for (int i = start;i<=end;i++){
                    if (A[i]%2!=0){
                        index = i;
                        break;
                    }
                }
                if (index==-1){
                    return null;
                }else {
                    swap(A,start,index);
                    start++;
                }
            }
        }
        return A;
    }

    /**
     * 空间复杂度ON
     */
    private static int[] sortArrayByParityII2(int[] A){
        int[] B = new int[A.length];
        int indexEven = 0, indexOdd = 1;
        for (int i : A) {
            if(i % 2 == 0){
                B[indexEven] = i;
                indexEven += 2;
            }else{
                B[indexOdd] = i;
                indexOdd += 2;
            }
        }
        return B;
    }

    private static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
