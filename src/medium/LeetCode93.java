package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
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

    static class Solution2 {

        public static void main(String[] args) {

        }
    }

    public static void main(String[] args) {
    }
}
