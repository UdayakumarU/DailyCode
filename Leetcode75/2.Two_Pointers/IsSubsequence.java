class Solution {
    public boolean isSubsequence(String s, String t) {
        //create shorter and longer pointer pointing S and T respectively
        //Keep both pointers at 0th index
        //check if charAt(shorter) == charAt(longer) then incrment both the pointers
        // else increment longer only
        // if shorter is s.length then return true else false

        int shorter = 0, longer = 0;

        while(shorter < s.length() && longer < t.length()){
            if(s.charAt(shorter) == t.charAt(longer)){
                ++shorter;
            }
            ++longer;
        }
        
        return shorter == s.length();
    }
}
