package medium;

import java.lang.annotation.Target;
import java.util.stream.Stream;

/**
 * 537. Complex Number Multiplication
 * .
 * Given two strings representing two complex numbers.
 * .
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * .
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * .
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class LeetCode537 {
    /**
     * simple Solution
     *
     * @param a
     * @param b
     * @return
     */
    public static String complexNumberMultiply(String a, String b) {
        String[] A = a.split("\\+");
        String[] B = b.split("\\+");

        int leftReal = Integer.parseInt(A[0]);
        int leftImagi = Integer.parseInt(A[1].replace("i", ""));

        int rightReal = Integer.parseInt(B[0]);
        int rightImagi = Integer.parseInt(B[1].replace("i", ""));

        int totalReal = leftReal * rightReal;
        int totalImagi = leftImagi * rightImagi;

        System.out.println(leftReal);
        System.out.println(leftImagi);
        System.out.println(rightReal);
        System.out.println(rightImagi);

        int leave = (leftReal * rightImagi) + (leftImagi * rightReal);

        String afinal = (totalReal + (-1 * totalImagi)) + "";
        String bfinal = leave + "i";
        return afinal + "+" + bfinal;
    }

    public static String complexNumberMultiply_(String a, String b) {
        int[] coefs1 = Stream.of(a.split("[+i]")).mapToInt(Integer::parseInt).toArray(),
                coefs2 = Stream.of(b.split("[+i]")).mapToInt(Integer::parseInt).toArray();
        return (coefs1[0] * coefs2[0] - coefs1[1] * coefs2[1]) + "+" + (coefs1[0] * coefs2[1] + coefs1[1] * coefs2[0]) + "i";
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply_("1+1i", "1+1i"));
        System.out.println(complexNumberMultiply_("1+-1i", "0+0i"));
        String test = "1+2-3*5";
        int[] ss = Stream.of(test.split("[+-/*]")).mapToInt(Integer::parseInt).toArray();
        System.out.println(ss[0]);
        System.out.println(ss[1]);
        System.out.println(ss[2]);
        System.out.println(ss[3]);
//        System.out.println(ss[1]);
//        System.out.println(ss[0]);

    }
}
