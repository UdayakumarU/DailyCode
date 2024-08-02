/*
  Symmetric Binary Tree
  Approach: Recursively check the alternative subtrees and campare its value
  Time complexity: O(n)
  Space complexity: O(1)
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compareNodes(root.left, root.right);
    }

    private static boolean compareNodes(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null) 
            return true;

        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }

        return compareNodes(node1.left, node2.right) && compareNodes(node1.right, node2.left);
    }
}
