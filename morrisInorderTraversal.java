class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();

        TreeNode current = root;
        //loop until current is null
        while(current != null){
            //if there is not left, then visit and shift to its right
            if(current.left == null){
                inorder.add(current.val);
                current = current.right;
            }
            //otherwise find its inorder predecessor
            else{
                TreeNode predecessor = getInorderPredecessor(current);
                //if predecessor.right null then point it to current then change current to its left
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }
                //if predecessor is current make predecessor.right null and visit current and change current to its right
                else{
                    predecessor.right = null;
                    inorder.add(current.val);
                    current = current.right;
                }
            }
        }
        return inorder; 
    }

    private static TreeNode getInorderPredecessor(TreeNode root){
        TreeNode current = root.left;
        while(current.right != null && current.right != root){
            current = current.right;
        }
        return current;
    }
}
