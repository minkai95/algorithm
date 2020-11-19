package com.leetcode.sort.easy;

import java.util.Arrays;

/**
 * 【283.移动零】
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int pointZeroIndex = -1;
        int notZeroIndex = -1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0){
                if (pointZeroIndex!=-1) {
                    pointZeroIndex = nums[pointZeroIndex]!=0 ? i : pointZeroIndex;
                } else {
                    pointZeroIndex = i;
                }
            } else {
                notZeroIndex = i;
            }
            if (pointZeroIndex!=-1 && notZeroIndex!=-1 && nums[pointZeroIndex]==0 && nums[notZeroIndex]!=0 && pointZeroIndex<notZeroIndex) {
                int temp = nums[pointZeroIndex];
                nums[pointZeroIndex] = nums[notZeroIndex];
                nums[notZeroIndex] = temp;
                ++notZeroIndex;
                ++pointZeroIndex;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for (int a=0;a<nums.length;a++) {
            if (nums[a]!=0) {
                nums[j++] = nums[a];
            }
        }
        for (int i=j;i<nums.length;i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,0};

        moveZeroes(arr);

    }

}
