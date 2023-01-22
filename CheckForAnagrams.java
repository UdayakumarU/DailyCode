//16.4 Check for Anagrams
//https://leetcode.com/problems/valid-anagram/description/
//Time Complexity:O(n)
//Space Complexity: O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        int frequency[] = new int[26];
        int sLength = s.length();
        int tLength = t.length();

        for(int i=0; i<sLength; ++i){
            ++frequency[s.charAt(i)-'a'];
        }

        for(int i=0; i<tLength; ++i){
            --frequency[t.charAt(i)-'a'];
        }

        for(int i=0; i<26; ++i){
            if(frequency[i] != 0){
                return false;
            }
        }
        return true;
    }
}
