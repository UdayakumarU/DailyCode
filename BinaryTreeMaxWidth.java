/*
  17.12
  Initial thought: assign every nodes exact position using 2i(left) and 2i+1(right), but this leeds to overflow
  Final thought: assign the position on every level using 2i-1(left) and 2i(right); ensure every level starts from 1 to n
  Time complexity : O(n)
  Space complexity: O(logn)
*/

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        WidthFinder widthFinder = new WidthFinder();
        return widthFinder.findMaxWidth(root);
    }
}

class Pair{
    long startIndex;
    long endIndex;
    
    Pair(long startIndex, long endIndex){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}

class WidthFinder{
    HashMap<Long, Pair> widthOfEachLevel;

    WidthFinder(){
        widthOfEachLevel = new HashMap<>();
    }

    public int findMaxWidth(TreeNode node){
         setNodePosition(node, 1, 1);
         return getMaxWidth();
    }

    private void setNodePosition(TreeNode node, long currentPosition, long currentLevel){
        if(node == null) return;
        
        Pair currentPair = widthOfEachLevel.get(currentLevel);
        if(currentPair == null){
            widthOfEachLevel.put(currentLevel, new Pair(currentPosition, currentPosition));
        }
        else{
            long startIndex = Math.min(currentPosition, currentPair.startIndex);
            long endIndex = Math.max(currentPosition, currentPair.endIndex);
            widthOfEachLevel.put(currentLevel, new Pair(startIndex, endIndex));
        }
        setNodePosition(node.left, (currentPosition * 2)-1, currentLevel+1);
        setNodePosition(node.right, (currentPosition * 2), currentLevel+1);
    }

    private int getMaxWidth(){

        int maxWidth = 0;
        for(Pair pair: widthOfEachLevel.values()){
            maxWidth = Math.max(maxWidth, (int)(pair.endIndex - pair.startIndex) +1);
        }

        return maxWidth;
    }
}
