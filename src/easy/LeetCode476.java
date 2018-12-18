package easy;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * .
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
public class LeetCode476 {
    static class Solution {
        public static int findComplement(int num) {
            int tmpRes = 0;//结果数组
            String tmpStringRes;//结果字符串（不可变）
            StringBuilder stringBuilder = new StringBuilder();//结果字符串（可变）
            tmpStringRes = Integer.toBinaryString(num);//10进制转换为2进制
            for (int i = 0; i < tmpStringRes.length(); i++) {
                if (tmpStringRes.charAt(i) == '0')
                    stringBuilder.append('1');
                else
                    stringBuilder.append('0');
            }
            tmpStringRes = stringBuilder.toString();
            tmpRes=  Integer.valueOf(tmpStringRes,2);
            System.out.println(tmpRes);
            return tmpRes;
        }

    }
    public static void main(String[] args) {
        Solution.findComplement(5);
    }
}
