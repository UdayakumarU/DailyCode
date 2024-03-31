class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> preorder = new ArrayList<>();
        TreeNode current = root;

        //loop until current is null
        while(current != null){
            //if current left is null then visit current and point to its right
            if(current.left == null){
                preorder.add(current.val);
                current = current.right;
            }
            //else
            else{
                //find the inorderPredecessor
                TreeNode predecessor = getInorderPredecessor(current);
                
                //if it's right is null then point to current and visit current
                if(predecessor.right == null){
                    predecessor.right = current;
                    preorder.add(current.val);
                    current = current.left;
                }
                //else make predecessor null and point current to its right
                else{
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
        return preorder;
    }

    private static TreeNode getInorderPredecessor(TreeNode root){
        TreeNode current = root.left;
        if(current.right != null && current.right != root){
            current = current.right;
        }
        return current;
    }
}
