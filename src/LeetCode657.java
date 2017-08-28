import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 * <p>
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */

//移动过程中根据上下左右记录坐标，判断最后是否回到原点。
public class LeetCode657 {
    static class Solution {
        public static boolean judgeCircle(String moves) {
            int[] index = new int[2];// 移动坐标记录x,y轴
            for (int i = 0; i < moves.length(); i++) {
                if ((moves.charAt(i)) == 'U') {
                    index[1]++;
                }
                if ((moves.charAt(i)) == 'D') {
                    index[1]--;
                }
                if ((moves.charAt(i)) == 'L') {
                    index[0]--;
                }
                if ((moves.charAt(i)) == 'R') {
                    index[0]++;
                }
            }
            return (index[0] == 0 && index[1] == 0);
        }
    }

    /**
     * 字符串分割判断数量 相等则回到原点
     */
    static class Solution2 {
        public static boolean judgeCircle(String moves) {
            return moves.split("L").length == moves.split("R").length && moves.split("U").length == moves.split("D").length;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Solution.judgeCircle("UDL"));
//        System.out.println(Solution.judgeCircle("UDRL"));
//        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::print);
//        IntStream.range(1, 10).forEach(System.out::print);
//        System.out.println();
//        IntStream.rangeClosed(1,3).forEach(System.out::print);
        List<Integer> num = Arrays.asList(1, 2, 3, 4);
        List<Integer> resNum = num.stream().map(n -> n * n).collect(Collectors.toList());
        resNum.forEach(System.out::print);

    }

}