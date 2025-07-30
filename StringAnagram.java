// Time Complexity: O(n * k log k)  
//   - n = number of strings in the input array
//   - k = maximum length of a string (sorting takes O(k log k))
// Space Complexity: O(n * k)  
//   - HashMap stores all strings grouped by sorted key, plus intermediate char arrays
// Did this code run on LeetCode? Yes
// Any problems faced while coding? No

// Approach:
// We use a HashMap to group words that are anagrams of each other.
// For each word, we convert it into a character array, sort it, and use the sorted string as a key.
// Since all anagrams share the same sorted character representation, they will be grouped under the same key.
// Finally, we return all grouped anagram lists stored in the map.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringAnagram {
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
