/*
  Check if the tree is balanced binary tree or not
  Approach : Check the subtree height difference is not more than 1 recursively for every node 
  space: O(1)
  Time: O(n)
*/


class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) 
            return true; 
        int right = depth(root.right);
        int left = depth(root.left);

        return (Math.abs(left-right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int depth(TreeNode node){
        if(node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
