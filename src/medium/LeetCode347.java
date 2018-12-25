package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements
 * .
 * Given a non-empty array of integers, return the k most frequent elements.
 * .
 * Example 1:
 * .
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * .
 * Input: nums = [1], k = 1
 * Output: [1]
 */
//bucket
public class LeetCode347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> res=new ArrayList<>();

        for (int pos = bucket.length-1; pos >=0&&res.size()<k ; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 2, 4, 4, 6}, 2);
        for (int i : res) {
            System.out.print(i + " ");
        }

    }
}
