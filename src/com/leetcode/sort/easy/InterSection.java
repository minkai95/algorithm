package com.leetcode.sort.easy;

import java.util.*;

/**
 * 【两个数组的交集】
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 *
 * 【两个数组的交集 II】
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */

public class InterSection {

    public static void main(String[] args) {
        int[] arr1 = interSection(new int[]{1,2,2,1},new int[]{2,2});
        int[] arr2 = interSection(new int[]{4,9,5},new int[]{9,4,9,8,4});
        int[] arr11 = interSection2(new int[]{1,2,2,1},new int[]{2,2});
        int[] arr22 = interSection2(new int[]{4,9,5},new int[]{9,4,9,8,4});
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr11));
        System.out.println(Arrays.toString(arr22));
    }

    private static int[] interSection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> resultMap = new Hashtable<>();
        List<Integer> list1 = new ArrayList<>();
        for(int tmp:nums1) {
            list1.add(tmp);
        }
        for(int temp:nums2) {
            if(list1.contains(temp)) {
                resultMap.put(temp, temp);
            }
        }
        return mapToArray(resultMap);
    }

    private static int[] interSection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        for(int tmp:nums1) {
            list1.add(tmp);
        }
        int key = 0;
        for(int temp:nums2) {
            if(list1.contains(temp)) {
                resultMap.put(key++, temp);
                list1.remove((Integer) temp);
            }
        }
        return mapToArray(resultMap);
    }

    private static int[] mapToArray(Map<Integer,Integer> map){
        int[] result = new int[map.size()];
        int i = 0;
        for(Integer value: map.values()) {
            result[i++] = value;
        }
        return result;
    }
}
