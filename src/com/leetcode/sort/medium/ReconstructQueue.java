package com.leetcode.sort.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 【406. 根据身高重建队列】
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class ReconstructQueue {


    private static int[][] reconstructQueue(int[][] people) {
        // 先对people进行排序,按照people[0]降序,people[0]相同时people[1]升序的规则进行排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]) {
                    return o2[0]-o1[0];
                }
                return o1[1]-o2[1];
            }
        });
        // 存放结果集的栈
        Stack<int[]> ret = new Stack<>();
        // 存放备份数组的栈
        Stack<int[]> backup = new Stack<>();
        // 依次遍历排好序的数组
        for (int[] arr:people) {
            // 结果集空的话直接添加进去,或者当前的这个元素刚刚好符合要求: 即arr[1]的值就是排在前面的数组的个数
            if (ret.isEmpty() || arr[1]==ret.size()) {
                ret.push(arr);
                continue;
            }
            // 加着加着ret中的数据就会大于当前的arr[1]的值,那么需要把当前数组插入到栈ret从底往上数的第arr[1]个元素处,也就是要把原本ret栈中arr[1]处及其后面的数组依次向后移动一位
            if (arr[1]<ret.size()) {
                int time = ret.size() - arr[1];
                // 先把ret栈中从底往上的第arr[1]个数组及其上面的数组全部弹出栈，临时存放到backup栈中
                while (time>0) {
                    backup.push(ret.pop());
                    --time;
                }
                // 将当前的数组push进ret栈中
                ret.push(arr);
                // 再把临时栈中的全部数据弹出放进结果集栈中
                while (!backup.isEmpty()) {
                    ret.push(backup.pop());
                }
            }
        }
        // 将ret栈从底向上遍历依次取出数据返回
        for (int i=0;i<ret.size();i++) {
            people[i] = ret.get(i);
        }
        return people;
    }

    public static void main(String[] args) {
        int[][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] arr2 = reconstructQueue(arr);
        for (int[] a:arr2) {
            System.out.println(Arrays.toString(a));
        }
    }

}
