package com.leetcode.sort.easy;

import java.util.Arrays;

/**
 * 【有序数组的平方】
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    private static int[] sortedSquares(int[] A) {
        if (A==null || A.length<1){
            return null;
        }
        int[] result = new int[A.length];
        int r = result.length-1;
        if (A.length==1){
            result[0]=(int)Math.pow(A[0],2);
            return result;
        }
        int i = 0, j = A.length-1;
        while (i<=j && r>=0){
            while (i<=j && A[i]*A[i] < A[j]*A[j]){
                result[r]=A[j]*A[j];
                j--;
                r--;
            }
            while (i<=j && A[i]*A[i] >= A[j]*A[j]){
                result[r]=A[i]*A[i];
                i++;
                r--;
            }
        }
        return result;
    }

}
