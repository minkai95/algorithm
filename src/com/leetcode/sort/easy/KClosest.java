package com.leetcode.sort.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 【最接近原点的 K 个点】
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *（这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 * 提示：
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class KClosest {

    public static void main(String[] args) {
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};
        int K = 2;
        int[][] ints = new KClosest().kClosest2(points,K);
        for (int[] i: ints) {
            System.out.println(Arrays.toString(i));
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][];
        Map<Double,int[]> map = new HashMap<>();
        Double[] doubleArray = new Double[points.length];
        for (int i = 0;i<points.length;i++) {
            Double d = Math.sqrt(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            map.put(d,points[i]);
            doubleArray[i] = d;
        }
        Arrays.sort(doubleArray);
        for (int i = 0; i<K; i++){
            result[i]=map.get(doubleArray[i]);
        }
        return result;
    }

    private class ArrayComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0]*o1[0]+o1[1]*o1[1] - o2[0]*o2[0]-o2[1]*o2[1];
        }
    }

    public int[][] kClosest2(int[][] points, int K) {
        int[][] result = new int[K][];
        Arrays.sort(points,new ArrayComparator());
        System.arraycopy(points,0,result,0,K);
        return result;
    }

}
