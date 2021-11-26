package easy;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 */
public class LeetCode7 {

    public static int reverse(int x) {
        long n = 0L;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public int reverse2(int x) {
        boolean isNegative = x < 0;
        x = Math.abs(x);
        int temp = 0;
        StringBuilder res = new StringBuilder();
        while (x != 0) {
            if (!"".equals(res.toString())) {
                if (x > Integer.MAX_VALUE / 10 || x < Integer.MIN_VALUE / 10) {
                    System.out.println(res.toString());
                    return 0;
                }
            }
            if (x >= 0) {
                temp = x % 10;
                x = x / 10;
            }
            res.append(temp);
        }

        if (res.toString().equals("")) {
            res = new StringBuilder("0");
        }
        int finalRes = 0;
        try {
            finalRes = isNegative ? -Integer.parseInt(res.toString()) : Integer.parseInt(res.toString());
        } catch (Exception e) {

        }
        return finalRes;
    }

    public static int reverse3(int x) {
        int y = 0;
        int n;
        while (x != 0) {
            n = x % 10;
            if (y > Integer.MAX_VALUE / 10 || y < Integer.MIN_VALUE / 10) {
                return 0;
            }
            y = y * 10 + n;
            x /= 10;
        }
        return y;
    }


    public static void main(String[] args) {
        int a = reverse3(0);
        int b = reverse3(122);
        int c = reverse3(-123);
        int d = reverse3(1);
        int e = reverse3(1);
        int f = reverse3(-2147483648);
        int g = reverse3(-2147483412);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
    }
}
