package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. Word Ladder
 * .
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * .
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * .
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * .
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * .
 * Output: 5
 * .
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * .
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * .
 * Output: 0
 * .
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class LeetCode127 {



    public static int ladderLength(String beginWord, String endWord, List<String> wordLisst) {
        Set<String> wordSet = new HashSet<>(wordLisst);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int distance = 1;
        while (!visited.contains(endWord)) {
            Set<String> temp = new HashSet<>();
            for (String word : visited) {
                for (int i = 0; i < word.length(); i++) {
                    char[] modifiedStr = word.toCharArray();
                    for (int j = 'a'; j < 'z' + 1; j++) {
                        modifiedStr[i] = (char) j;
                        String distanceOneWord = new String(modifiedStr);
                        if (wordSet.contains(distanceOneWord)) {
                            temp.add(distanceOneWord);
                            wordSet.remove(distanceOneWord);
                        }
                    }
                }
            }
            distance++;
            if (temp.size() == 0) {//no way to go
                return 0;
            }
            visited = temp;
        }
        return distance;
    }

    public static void main(String[] args) {
        LeetCode127 leetCode127 = new LeetCode127();
        String beginword = "hit";
        String endWord = "cog";

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dot");
        list.add("lot");
        list.add("log");
        list.add("cog");

        System.out.println(leetCode127.ladderLength(beginword, endWord, list));
    }

}
