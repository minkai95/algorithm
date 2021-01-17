package com.leetcode.sort.easy;

/**
 * 【1232. 缀点成线】
 *  在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 */
public class CheckStraightLine {


    public static void main(String[] args) {
        int[][] a = {{1,-8},{2,-3},{1,2}};
        System.out.println(checkStraightLine(a));
    }


    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2) {
            return true;
        }
        double flag;
        if (Math.abs(coordinates[1][0]-coordinates[0][0]) == 0) {
            flag = Double.MAX_VALUE;
        } else {
            flag = Double.valueOf(coordinates[1][1]-coordinates[0][1]) / (coordinates[1][0]-coordinates[0][0]);
        }

        for(int i = 2;i<coordinates.length;i++) {
            double thisFlag;
            if (Math.abs(coordinates[i][0]-coordinates[i-1][0]) == 0){
                thisFlag = Double.MAX_VALUE;
            } else {
                thisFlag = Double.valueOf(coordinates[i][1]-coordinates[i-1][1]) / (coordinates[i][0]-coordinates[i-1][0]);
            }
            if (thisFlag != flag) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkStraightLine2(int[][] coordinates) {
        if(coordinates.length<=2) {
            return true;
        }
        for(int i = 2;i<coordinates.length;i++) {
            int a = (coordinates[i][1]-coordinates[0][1])*(coordinates[1][0]-coordinates[0][0]);
            int b = (coordinates[i][0]-coordinates[0][0])*(coordinates[1][1]-coordinates[0][1]);
            if (a!=b) {
                return false;
            }
        }
        return true;
    }

}
