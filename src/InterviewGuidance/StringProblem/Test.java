package InterviewGuidance.StringProblem;

public class Test {
    //变形词
    public static class Solution1 {
        public static boolean isDeformation(String str1, String str2) {
            if (str1 == null || str2 == null || (str1.length() != str2.length())) {
                return false;
            }
            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();
            int[] charMap = new int[256];
            for (char value : char1) {
                charMap[value]++;
            }
            for (char c : char2) {
                if (charMap[c]-- == 0) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            String a = "aabb";
            String b = "bbaa";
            System.out.println(isDeformation(a, b));
        }
    }

    //旋转词
    public static class Solution2 {

    }

    //整数字符串转为数字
    public static class Solution3 {

    }

}
