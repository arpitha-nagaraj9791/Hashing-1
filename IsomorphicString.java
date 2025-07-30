// Time Complexity: O(n), where n is the length of the strings
// Space Complexity: O(1), since the maps can contain at most 256 unique ASCII characters
// Did this code run on LeetCode? Yes
// Any problems faced while coding? No

// Approach:
// We use two HashMaps to maintain character mappings from string s to t and t to s.
// As we iterate over each character in both strings, we ensure that each character from s consistently maps to a single character in t, and vice versa.
// If any inconsistency is found in the mapping, we return false; otherwise, return true after completing the iteration.

import java.util.HashMap;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar) != tChar) return false;
            }else{
                sMap.put(sChar, tChar);
            }

            if(tMap.containsKey(tChar)){
                if(tMap.get(tChar) != sChar) return false;
            }else{
                tMap.put(tChar, sChar);
            }
        }
        return true;
    }
}
