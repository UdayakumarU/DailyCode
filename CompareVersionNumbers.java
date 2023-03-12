/*
  16.5 Compare version numbers
  https://leetcode.com/problems/compare-version-numbers/description/
  
  Time complexity: O(max(n,m));
  Space complexity: O(max(n,m))
*/
class Solution {
    public int compareVersion(String version1, String version2) {
        //String version1List
        //String version2List
        /**
            1.01.9.3 => [1,01,9,3]
            2.4.5.6.7= >[1,4,5,6,7]
         */
        String[] token1 = version1.split("\\.");
        String[] token2 = version2.split("\\.");
        
        for(int i=0; i<token1.length || i<token2.length; ++i){
            int revision1 = token1.length>i?Integer.parseInt(token1[i]):0; 
            int revision2 = token2.length>i?Integer.parseInt(token2[i]):0; 
            if(revision1 < revision2){
                return -1;
            }
            else if(revision1 > revision2){
                return 1;
            }
        }
        return 0;
    }
