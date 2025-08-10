//Problem - https://leetcode.com/problems/substring-with-concatenation-of-all-words

import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        //distinct word in words and its count
        Map<String, Integer> wordCount = new HashMap<>(); 

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        //for loop - all posible starting point i.e - 0 to wordlen -1
        for (int i = 0; i < wordLen; i++) {
            // fix the sliding window pointers 
            int left = i, right = i, count = 0; 
            //word and its count within sliding window
            Map<String, Integer> seen = new HashMap<>(); 

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right+= wordLen;

                // if word exist in wordCount HashMap then check further
                if (wordCount.containsKey(word)) {
                    //add to HashMap
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    //if word count within Sliding window is greater than input word count, move the Sliding pointer and remove word from HashMap
                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    //if count is equal to given words length add indices to o/p list
                    if (count == words.length) {
                        result.add(left);
                    }
                } else { // if word doesnot exist in woedCount HashMap reset the pointer values
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

}
