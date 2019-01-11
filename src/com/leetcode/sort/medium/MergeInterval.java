package com.leetcode.sort.medium;

/**
 * 【合并区间】
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */

import java.util.*;


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class MergeInterval {

    public static void main(String[] args) {
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);
        Interval i5 = new Interval(1,4);
        Interval i6 = new Interval(4,5);
        List<Interval> list1 = new ArrayList<>();
        list1.add(i1);
        list1.add(i2);
        list1.add(i3);
        list1.add(i4);
        List<Interval> list2 = new ArrayList<>();
        list2.add(i5);
        list2.add(i6);
        List<Interval> resultList1 = merge(list1);
        List<Interval> resultList2 = merge(list2);
        for (Interval interval: resultList1) {
            System.out.print("["+interval.start+","+interval.end+"],");
        }
        System.out.println();
        for (Interval interval: resultList2) {
            System.out.print("["+interval.start+","+interval.end+"],");
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public  int compare(Interval i1, Interval i2) {
            return i1.start-i2.start;
        }
    }
    private static List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()<=1) {
            return intervals;
        }
        LinkedList<Interval> list = new LinkedList<>();
        Collections.sort(intervals, new IntervalComparator());

        for (Interval interval : intervals) {
            if(list.isEmpty() || list.getLast().end<interval.start) {
                list.add(interval);
            }else {
                list.getLast().end = Math.max(list.getLast().end, interval.end);
            }
        }
        return list;
    }
}
