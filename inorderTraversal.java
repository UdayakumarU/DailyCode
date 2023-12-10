//17.1 Inorder traversal
//https://leetcode.com/problems/binary-tree-inorder-traversal/description/
//Time Complexity:O(n)
//Space Complexity: O(1)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new LinkedList<>();
        recurseInorder(inOrderList, root);
        return inOrderList;
    }

    private void recurseInorder(List<Integer> inOrderList, TreeNode root ){
        if(root == null)
            return;
        recurseInorder(inOrderList, root.left);
        inOrderList.add(root.val);
        recurseInorder(inOrderList, root.right);
    }
}
