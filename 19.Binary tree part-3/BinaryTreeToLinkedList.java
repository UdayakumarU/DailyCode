/*
 Flatten Binary Tree to Linked List
 Approach: Recursion; Find the rightmost node of the left subtree, join its right to root right

 Time complexity: O(n)
 Space complexity: O(1)
*/

class Solution {
    public void flatten(TreeNode root) {
        root = helper(root);
    }

    private static TreeNode helper(TreeNode root){
        if(root == null) 
            return null;

        if(root.left == null && root.right == null) 
            return root;

        TreeNode tempRight = root.right;

        root.right = helper(root.left);

        TreeNode rightEndNode = getRightMostNode(root);

        rightEndNode.right = helper(tempRight);
        
        root.left = null;

        return root;
    }


    private static TreeNode getRightMostNode(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

}
