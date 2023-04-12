package hard;

import java.util.ArrayList;
import java.util.List;

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

    }

    //字符串指纹算法优化
    static class Solution_version_Rabin_Karp {

    }

    public static void main(String[] args) {
        Solution_version_1 solution = new Solution_version_1();

        //(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        int res1 = solution.longestDecomposition(text);
        System.out.println(res1 == 7);
//
        text = "merchant";
        res1 = solution.longestDecomposition(text);
        System.out.println(res1 == 1);
//
        text = "antaprezatepzapreanta";
        int res2 = solution.longestDecomposition(text);
        System.out.println(res2 == 11);

        text = "elvtoelvto";
        System.out.println(solution.longestDecomposition(text) == 2);

    }
}
