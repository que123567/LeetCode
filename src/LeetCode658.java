import java.util.*;

//
public class LeetCode658 {
    static class Solution {
        public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            int lo = 0, hi = arr.size() - k;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (x - arr.get(mid) > arr.get(mid + k) - x)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            return arr.subList(lo, lo + k);
        }
    }

    static class Solution2 {
        public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            List<Integer> less = new ArrayList<>(), greater = new ArrayList<>(),
                    lessResult = new LinkedList<>(), greaterResult = new LinkedList<>();

            for (Integer i : arr) {
                if (i <= x) less.add(i);
                else greater.add(i);
            }

            Collections.reverse(less);
            int i = 0, j = 0, n = less.size(), m = greater.size();
            for (int size = 0; size < k; size++) {
                if (i < n && j < m) {
                    if (Math.abs(less.get(i) - x) <= Math.abs(greater.get(j) - x)) lessResult.add(less.get(i++));
                    else greaterResult.add(greater.get(j++));
                } else if (i < n) lessResult.add(less.get(i++));
                else greaterResult.add(greater.get(j++));
            }

            Collections.reverse(lessResult);
            lessResult.addAll(greaterResult);
            return lessResult;

        }
    }

    static class Solution3 {
        public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            Collections.sort(arr, (a, b) -> a == b ? 0 : Math.abs(a - x) - Math.abs(b - x));
            arr = arr.subList(0, k);
            Collections.sort(arr);
            return arr;
        }
    }

    static class Solution4 {
        public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            List<Integer> resList = new ArrayList<>();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < arr.size(); i++) {
                map.put(arr.get(i) - x, i);
            }
         //   map.forEach((key,value)->System.out.println(key+value));
            int i = 0;
            for (Integer value : map.values()) {
                resList.add(arr.get(value));
                i++;
                if (i == k) {
                    break;
                }
            }
//            Collections.sort(resList);
            return resList;
        }


    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        res.add(1);
        res.add(1);
        res.add(2);
        res.add(3);
        res.add(4);
        res.add(5);

        res = Solution4.findClosestElements(res, 4, 3);

        //res.forEach(c -> System.out.print(c));

//        res.forEach(item -> {
//            if (item.equals(1))
//                System.out.println(item);
//        });

    }

}
