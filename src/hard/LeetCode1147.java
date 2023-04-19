package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/
 * 1147. 段式回文
 * 你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:
 * <p>
 * subtexti 是 非空 字符串
 * 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
 * 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立
 * 返回k可能最大值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ghiabcdefhelloadamhelloabcdefghi"
 * 输出：7
 * 解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
 * 示例 2：
 * <p>
 * 输入：text = "merchant"
 * 输出：1
 * 解释：我们可以把字符串拆分成 "(merchant)"。
 * 示例 3：
 * <p>
 * 输入：text = "antaprezatepzapreanta"
 * 输出：11
 * 解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 1000
 * text 仅由小写英文字符组成
 */
public class LeetCode1147 {

    static class Solution_version_1 {
        public int longestDecomposition(String text) {
            if (isSingleWord(text)) {
                return 1;
            }
            return getSameStrIndex(text, 0);
        }

        public int getSameStrIndex(String text, int cnt) {
            int length = text.length();
            for (int i = 0; i < length / 2; i++) {
                for (int subIndex = 0; ; subIndex++) {
                    if (text.charAt(i) == text.charAt(length - 1 - subIndex)) {
                        if (text.substring(0, i + 1).equals(text.substring(length - 1 - i, length))) {
                            String leftWord = text.substring(i + 1, length - 1 - i);
                            if (isSingleWord(leftWord)) {
                                if (leftWord.equals("")) {
                                    return (cnt + 1) * 2;
                                } else {
                                    return (cnt + 1) * 2 + 1;
                                }
                            } else {
                                return getSameStrIndex(leftWord, cnt + 1);
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            return 0;
        }

        public boolean isSingleWord(String text) {
            for (int i = 0; i < text.length() / 2; i++) {
                if (text.substring(0, i + 1).equals(text.substring(text.length() - 1 - i))) {
                    return false;
                }
            }
            return true;
        }
    }

    //solution1简化版
    static class Solution_version_1_simple {
        public int longestDecomposition(String text) {
            int length = text.length();
            int res = 0;
            int l = 0, r = length - 1;
            while (l <= r) {
                int len = 1;
                //圈定一个对应的单词
                while (l + len - 1 < r - len + 1) {
                    if (judge(text, l, r - len + 1, len)) {
                        res += 2;
                        break;
                    }
                    len += 1;
                }

                if (l + len - 1 >= r - len + 1) {
                    res += 1;
                }

                //剩下的继续圈
                l += len;
                r -= len;
            }
            return res;
        }

        public boolean judge(String text, int l, int r, int len) {
            for (int i = 0; i < len; i++) {
                if (text.charAt(l + len - 1) != text.charAt(r + len - 1)) {
                    return false;
                }
            }
            return true;
        }

    }

    /**
     * 官方：字符串指纹算法优化
     * 主要：
     * 1.pre数组的定义；为什么定义为n+1个.
     * 2.pow数组的定义。
     * 3.使用了2次Hash确保正确性
     * 4.hash的取法：其中+mod确保非负。
     */
    static class Solution_version_Rabin_Karp {

        long[] pre1;
        long[] pre2;
        long[] pow1;
        long[] pow2;
        static final int MOD1 = 1000000007;
        static final int MOD2 = 1000000009;
        int base1, base2;
        Random random = new Random();

        public int longestDecomposition(String text) {
            init(text);
            int n = text.length();
            int res = 0;
            int l = 0, r = n - 1;
            while (l <= r) {
                int len = 1;
                while (l + len - 1 < r - len + 1) {
                    if (Arrays.equals(getHash(l, l + len - 1), getHash(r - len + 1, r))) {
                        res += 2;
                        break;
                    }
                    ++len;
                }
                if (l + len - 1 >= r - len + 1) {
                    ++res;
                }
                l += len;
                r -= len;
            }
            return res;
        }

        public void init(String s) {
            base1 = 1000000 + random.nextInt(9000000);
            base2 = 1000000 + random.nextInt(9000000);
            while (base2 == base1) {
                base2 = 1000000 + random.nextInt(9000000);
            }
            int n = s.length();
            pow1 = new long[n];
            pow2 = new long[n];
            pre1 = new long[n + 1];
            pre2 = new long[n + 1];
            pow1[0] = pow2[0] = 1;
            pre1[1] = pre2[1] = s.charAt(0);
            for (int i = 1; i < n; i++) {
                pow1[i] = (pow1[i - 1] * base1) % MOD1;
                pow2[i] = (pow2[i - 1] * base2) % MOD2;
                pre1[i + 1] = (pre1[i] * base1 + s.charAt(i)) % MOD1;
                pre2[i + 1] = (pre2[i] * base2 + s.charAt(i)) % MOD2;
            }
        }

        public long[] getHash(int l, int r) {
            return new long[]{(pre1[r + 1] - ((pre1[l] * pow1[r + 1 - l]) % MOD1) + MOD1) % MOD1, (pre2[r + 1] - ((pre2[l] * pow2[r + 1 - l]) % MOD2) + MOD2) % MOD2};
        }

    }

    public static void main(String[] args) {
        Solution_version_Rabin_Karp solution = new Solution_version_Rabin_Karp();

        //(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        int res1 = solution.longestDecomposition(text);
        System.out.println(res1 == 7);

        text = "merchant";
        res1 = solution.longestDecomposition(text);
        System.out.println(res1 == 1);

        text = "antaprezatepzapreanta";
        int res2 = solution.longestDecomposition(text);
        System.out.println(res2 == 11);

        text = "elvtoelvto";
        System.out.println(solution.longestDecomposition(text) == 2);

    }
}
