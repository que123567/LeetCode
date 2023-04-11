package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 简单
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * https://leetcode.cn/problems/pascals-triangle-ii/solutions/601082/yang-hui-san-jiao-ii-by-leetcode-solutio-shuk/
 */
public class LeetCode119 {

    /**
     * simple version 1
     */
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    rowList.add(1);
                } else {
                    rowList.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(rowList);
        }
        return res.get(rowIndex);
    }

    /**
     * version 2 滚动数组
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }


    /**
     * version3 Using only one list;
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow3(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    public static List<Integer> getRow4(int rowIndex) {

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Integer> res = getRow3(4);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString() + " ");
        }
    }
}
