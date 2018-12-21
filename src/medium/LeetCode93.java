package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * .
 * Example:
 * .
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class LeetCode93 {

    /**
     * simple solution
     */
    static class Solution {
        public static List<String> restoreIpAddresses(String s) {
            List<String> list = new ArrayList<>();
            int length = s.length();
            if (s.length() < 4 || s.length() > 12)//长度小于4，返回
                return list;
            for (int i = 1; i < length + 3; i++)
                for (int j = i + 1; j < length + 3; j++)
                    for (int k = j + 1; k < length + 2; k++) {
                        if (i != j - 1 && j != k - 1) {//
                            StringBuilder stringBuffer = new StringBuilder(s);
                            stringBuffer.insert(i, ".");
                            stringBuffer.insert(j, ".");
                            stringBuffer.insert(k, ".");
                            if (ipCheck(stringBuffer.toString()))
                                list.add(stringBuffer.toString());
                        }
                    }
            return list;
        }

        public static boolean ipCheck(String text) {
            if (text != null && !text.isEmpty()) {
                //一位数[0-9]
                //二位数[1-9][0-9]
                //三位数第一种：1[0-9][0-9]
                //三位数第二种:2[0-4][0-9]
                //三位数第三种:25[0-5]
                String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +//ip正则
                        "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
                        "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
                        "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
                if (text.matches(regex)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

    }

    /**
     * 39题 ：https://leetcode.com/problems/combination-sum/description/
     * 39题意： 给你没有重复数字的数组，取数组里的数字，可以重复的取，取得数字之和 = target, 例如：
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     * [7],
     * [2,2,3]
     * ]
     * .
     * 该题的本质：
     * 每段IP 地址的长度都是 1~3 位， 相当于给你一个数组 nums = {1,2,3} ，每次从nums 里取一个数表示 每段IP的长度， 只能取4次并且可以取重复的数字，这四次取得的长度和 sum == 给定字符串的长度。
     * 例如： Input: "25525511135" 长度为 11
     * 那从nums 里取4次组成的有效 组合： [2,3,3,3], [3,2,3,3], [3,3,2,3] , [3,3,3,2] == 长度11
     * 除了长度合法外IP 地址本身也得合法 1. 每段IP <= 255； 2. 如果每段IP 长度不是1， 那么不能是0 开头， 例如 "05" "006" 都是不合法的组合。
     * 结合以上得到的IP地址：
     * 长度为 [2 3 3 3 ]： 25.525.511.135 不合法
     * [3 2 3 3]： 255.25.511.135 不合法
     * [3 3 2 3]: 255.255.11.135 合法
     * [3 3 3 2]: 255.255.111.35 合法
     * 因此得到最终结果为：
     * [3 3 2 3]: 255.255.11.135 合法
     * [3 3 3 2]: 255.255.111.35 合法
     * .
     * 类比39题，写了个容易理解的code 为：
     */
    static class Solution_ {
        private static final String ILLEGAL_IP = "-1";

        public static List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            int[] nums = {1, 2, 3};
            dfs(new ArrayList<>(), nums, result, 0, 0, s);
            return result;
        }

        private static void dfs(List<Integer> list, int[] nums, List<String> result, int depth, int sum, String s) {
            if (depth == 4 && sum == s.length()) {
                String ip = gen_ip_address(list, s);
                if (!ip.equals(ILLEGAL_IP)) {
                    result.add(ip);
                    return;
                }
            }

            if (depth == 4 || sum > s.length()) {
                return;
            }

            for (int num : nums) {
                sum += num;
                list.add(num);
                dfs(list, nums, result, depth + 1, sum, s);
                sum -= num;
                list.remove(list.size() - 1);
            }
        }

        //list里 存放的是每段IP的长度
        private static String gen_ip_address(List<Integer> list, String s) {
            int start = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                String si = s.substring(start, start + list.get(i));
                start += list.get(i);
                if (Integer.valueOf(si) > 255)
                    return ILLEGAL_IP;
                if (list.get(i) > 1 && si.charAt(0) == '0')
                    return ILLEGAL_IP;
                if (i < 3)
                    res.append(si).append(".");
                else
                    res.append(si);
            }
            return res.toString();
        }
    }

    static class Solution_2 {
        static List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            int len = s.length();
            for (int i = 1; i <= 3; ++i) {  // first cut
                if (len - i > 9)
                    continue;
                for (int j = i + 1; j <= i + 3; ++j) {  //second cut
                    if (len - j > 6)
                        continue;
                    for (int k = j + 1; k <= j + 3 && k < len; ++k) {  // third cut
                        int a, b, c, d;                // the four int's seperated by "."
                        a = Integer.parseInt(s.substring(0, i));
                        b = Integer.parseInt(s.substring(i, j)); // notice that "01" can be parsed into 1. Need to deal with that later.
                        c = Integer.parseInt(s.substring(j, k));
                        d = Integer.parseInt(s.substring(k));
                        if (a > 255 || b > 255 || c > 255 || d > 255)
                            continue;
                        String ip = a + "." + b + "." + c + "." + d;
                        if (ip.length() < len + 3)
                            continue;  // this is to reject those int's parsed from "01" or "00"-like substrings
                        ans.add(ip);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution_.restoreIpAddresses("");
//        List<String> res = Solution_2.restoreIpAddresses("25525511135");
        List<String> res = Solution_2.restoreIpAddresses("11111111");
        for (String str : res) {
            System.out.println(str + " ");
        }
    }
}
