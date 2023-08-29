//17.2 Preorder traversal
//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
//Time Complexity:O(n)
//Space Complexity: O(1)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverse(root, result);
        return result;
    }

    private static void traverse(TreeNode root, List<Integer> result){
        if(root == null) 
          return;
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}
