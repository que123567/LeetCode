package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. Self Dividing Numbers
 * .
 * A self-dividing number is a number that is divisible by every digit it contains.
 * .
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * .
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * .
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * .
 * Example 1:
 * .
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * .
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class LeetCode728 {
    public static List<Integer> selfDividingNumber(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left,n; i <= right; i++) {
            for (n = i; n > 0; n /= 10) {
                if (n % 10 == 0 || i % (n % 10) != 0)
                    break;
            }
            if (n == 0)
                list.add(i);
        }
        return list;
    }
    public static void main(String[] args) {

        List<Integer> list = selfDividingNumber(1, 22);
        for (int i : list) {
            System.out.print(i+" ");
        }
    }
}
