//17.3 Postorder traversal
//https://leetcode.com/problems/binary-tree-postorder-traversal/description/
//Time Complexity:O(n)
//Space Complexity: O(1)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverse(root, result);
        return result;
    }

    private static void traverse(TreeNode root, List<Integer> result){
        if(root == null)
            return;
        traverse(root.left, result);
        traverse(root.right, result);
        result.add(root.val);
    }
}
