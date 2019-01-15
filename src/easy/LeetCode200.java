package easy;

/**
 * 204. Count Primes
 * '
 * Count the number of prime numbers less than a non-negative number, n.
 * '
 * Example:
 * '
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class LeetCode200 {
    /**
     * version1
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

//    /**
//     * version2
//     *
//     * @param n
//     * @return
//     */
//    public int countPrimes_verson2(int n) {
//        if (n <= 2)
//            return 0;
//        int ans = 1;// don't forget to record 2. :-)
//        boolean[] isCompositeArr = new boolean[n];
//        int upper = (int) Math.sqrt(n);
//        for (int i = 3; i < n; i = i + 2) {//1.scan only odd number
//            if (isCompositeArr[i])
//                continue;
//            ans++;
//            if (i > upper)
//                continue;//2. avoid i^2 overflow.
//            for (int j = i * i; j < n; j = j + 2 * i) {//3. initialize j to i^2
//                //4. increase 2i to keep j as an odd number
//
//                isCompositeArr[j] = true;
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
