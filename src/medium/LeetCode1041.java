package medium;

/**
 * https://leetcode.cn/problems/robot-bounded-in-circle/description/
 * <p>
 * 1041. 困于环中的机器人
 * <p>
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:
 * <p>
 * 北方向 是y轴的正方向。
 * 南方向 是y轴的负方向。
 * 东方向 是x轴的正方向。
 * 西方向 是x轴的负方向。
 * 机器人可以接受下列三条指令之一：
 * <p>
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 * <p>
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：instructions = "GGLLGG"
 * 输出：true
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “G”:移动一步。位置:(0,2).方向:北。
 * “L”:逆时针旋转90度。位置:(0,2).方向:西。
 * “L”:逆时针旋转90度。位置:(0,2)方向:南。
 * “G”:移动一步。位置:(0,1)方向:南。
 * “G”:移动一步。位置:(0,0)方向:南。
 * 重复指令，机器人进入循环:(0,0)——>(0,1)——>(0,2)——>(0,1)——>(0,0)。
 * 在此基础上，我们返回true。
 * 示例 2：
 * <p>
 * 输入：instructions = "GG"
 * 输出：false
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “G”:移动一步。位置:(0,2).方向:北。
 * 重复这些指示，继续朝北前进，不会进入循环。
 * 在此基础上，返回false。
 * 示例 3：
 * <p>
 * 输入：instructions = "GL"
 * 输出：true
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “L”:逆时针旋转90度。位置:(0,1).方向:西。
 * “G”:移动一步。位置:(- 1,1)方向:西。
 * “L”:逆时针旋转90度。位置:(- 1,1)方向:南。
 * “G”:移动一步。位置:(- 1,0)方向:南。
 * “L”:逆时针旋转90度。位置:(- 1,0)方向:东方。
 * “G”:移动一步。位置:(0,0)方向:东方。
 * “L”:逆时针旋转90度。位置:(0,0)方向:北。
 * 重复指令，机器人进入循环:(0,0)——>(0,1)——>(- 1,1)——>(- 1,0)——>(0,0)。
 * 在此基础上，我们返回true。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= instructions.length <= 100
 * instructions[i] 仅包含 'G', 'L', 'R'
 */
public class LeetCode1041 {
    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Bot {
        //0,1,2,3 北，东，南，西。
        int orientation = 0;
        Location location = new Location(0, 0);

        private void move() {
            switch (orientation) {
                case 0:
                    location.y += 1;
                    break;
                case 1:
                    location.x += 1;
                    break;
                case 2:
                    location.y -= 1;
                    break;
                case 3:
                    location.x -= 1;
                    break;
                default:
                    break;
            }
        }

        boolean changeOrientation(char a) {
            boolean turn = false;
            if (a == 'R') {
                orientation = (orientation + 1) % 4;
                turn = true;
            }
            if (a == 'L') {
                orientation = (orientation + 3) % 4;
                turn = true;
            }
            return turn;
        }
    }

    static class Solution {
        public boolean isRobotBounded(String instructions) {
            Bot bot = new Bot();
            for (int circle = 0; circle < 5; circle++) {
                for (int i = 0; i < instructions.length(); i++) {
                    char a = instructions.charAt(i);
                    if (bot.changeOrientation(a)) {
                        continue;
                    }
                    if (a == 'G') {
                        bot.move();
                    }
                }
                if (bot.location.x == 0 && bot.location.y == 0) {
                    return true;
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {
        String instructions = "GGLLGG";
        Solution solution = new Solution();
        System.out.println(solution.isRobotBounded(instructions));


    }
}
