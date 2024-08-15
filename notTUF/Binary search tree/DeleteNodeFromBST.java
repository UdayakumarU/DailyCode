/*
450. Delete Node in a BST
Approach : Recursion
    When a node is a match 
      return its right/left if left/right is null
    else
       find and copy the min value in its right sub tree
       recusively delete the minvalue node in its right sub tree.

*/

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) 
                return root;
        
            if(root.val == key){
                if(root.left == null) return root.right;
                if(root.right == null) return root.left;

                root.val = findMinValue(root.right);
                root.right = deleteNode(root.right, root.val);
            }
            else if(root.val < key){
                root.right = deleteNode(root.right, key);
            }
            else{
                root.left = deleteNode(root.left, key);
            }
            
            return root;
    }

    private static int findMinValue(TreeNode root){
        if(root == null) return 0;
        if(root.left == null )return root.val;
        return findMinValue(root.left);
    }
}
