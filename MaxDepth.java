/*
  18.2 Height of binary tree
  Approach: Recursion
  Time complexity: O(n)
  Space complexity: O(logn) : call stack
*/

class Solution {
    public int maxDepth(TreeNode root) {
        return goDeep(root, 0);
    }

    private int goDeep(TreeNode node, int level){
        if(node == null) return level;
        return Math.max(goDeep(node.left, level+1), goDeep(node.right, level+1));
    }
}
