import java.util.Stack;

/**
 * 682. Baseball Game
 * <p>
 * You're now a baseball game point recorder.
 * <p>
 * Given a list of strings, each string can be one of the 4 following types:
 * <p>
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * <p>
 * You need to return the sum of the points you could get in all the rounds.
 * <p>
 * Example 1:
 * Input: ["5","2","C","D","+"]
 * example
 * <p>
 * 5 + 2 - 2 =5
 * 5 + 10 = 15
 * 15+5+15=30
 * <p>
 * <p>
 * Output: 30
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.
 * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 * Example 2:
 * Input: ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get -2 points. The sum is: 3.
 * Round 3: You could get 4 points. The sum is: 7.
 * Operation 1: The round 3's data is invalid. The sum is: 3.
 * Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
 * Round 5: You could get 9 points. The sum is: 8.
 * Round 6: You could get -4 + 9 = 5 points. The sum is 13.
 * Round 7: You could get 9 + 5 = 14 points. The sum is 27.
 * Note:
 * The size of the input list will be between 1 and 1000.
 * Every integer represented in the list will be between -30000 and 30000.
 */
public class LeetCOde682 {

    /**
     * @param ops
     * @return
     */
    public static int calPoints(String[] ops) {
        int sum = 0;
        int valid[] = new int[ops.length];
        int v = -1;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                sum -= valid[v];
                v--;
            } else if (ops[i].equals("D")) {
                int d = (valid[v] + valid[v]);
                v++;
                valid[v] = d;
                sum += d;
            } else if (ops[i].equals("+")) {
                int p = (valid[v] + valid[v - 1]);
                v++;
                valid[v] = p;
                sum += p;
            } else {
                int val = Integer.parseInt(ops[i]);
                v++;
                valid[v] = val;
                sum += val;
            }
        }
        return sum;
    }

    /**
     * @param ops
     * @return
     */
    public static int calPoints_my(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String str : ops) {
            if (str.equals("+")) {
                int top = stack.pop();
                int sum = top + stack.peek();
                stack.push(top);
                stack.push(sum);
            } else if (str.equals("C")) {
                stack.pop();
            } else if (str.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        int res = 0;
        for (int score : stack) {
            res += score;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] res = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};

        System.out.println(calPoints_my(res));
    }
}
