/*
  Construct Binary Tree from inorder and preorder
  Approach: Root node value of give subtree at first of postOrder (+ab); 
            find the same value postion in inorder (a+b); 
            left and right of inorder root forms the respective subtrees and find the same from preorder;
            call recusrively
            
  Space complexity: O(nlogn)
  Time complexity: O(n)           
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0) 
            return null;

        int preOrderRootIndex = 0;
        int inorderRootIndex = getIndexOf(inorder, preorder[preOrderRootIndex]);

        TreeNode root = new TreeNode(preorder[preOrderRootIndex]);

        int leftSubArrayLength = inorderRootIndex;
        int rightSubArrayLength = inorder.length - (inorderRootIndex+1);

        root.left = buildTree(getSubArray(preorder, 1, leftSubArrayLength), getSubArray(inorder, 0, leftSubArrayLength));
        root.right = buildTree(getSubArray(preorder, leftSubArrayLength+1, rightSubArrayLength), getSubArray(inorder, inorderRootIndex+1, rightSubArrayLength));

        return root;
    }

    private static int[] getSubArray(int[] array, int startIndex, int length){
        if(startIndex < 0 || startIndex > array.length || length < 0) 
            return new int[0];
        
        int[] subArray = new int[length];
        for(int i=0, j=startIndex; i<length; ++i, ++j){
            subArray[i] = array[j];
        }

        return subArray;
    }

    private static int getIndexOf(int[] elements, int element){
        for(int i=0; i<elements.length; ++i){
            if(elements[i] == element){
                return i;
            }
        }
        return -1;
    }
}



