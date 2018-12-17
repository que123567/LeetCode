package hard;

public class Test {
    public static int count_one(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }


    public static int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1); //be careful about the terminating condition;
    }

    public static void main(String[] args) {
        System.out.println(getSum(10, 20));
        System.out.println(~2);

    }
}
