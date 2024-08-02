/*
Construct Binary Tree from Inorder and Postorder
Approach: Root node value of give subtree at last of postOrder (ab+); 
          find the same value postion in inorder (a+b); 
          left and right of inorder root forms the respective subtrees inorder and find the same from postorder;
          call recusrively

Space complexity: O(nlogn)
Time complexity: O(n)
*/

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) 
            return null;

        int postorderLastIndex = postorder.length-1;
        int inorderRootIndex = getIndexOf(inorder, postorder[postorderLastIndex]);

        TreeNode root = new TreeNode(postorder[postorderLastIndex]);

        int leftSubArraylength = inorderRootIndex;
        int rightSubArraylength = inorder.length - (inorderRootIndex+1);

        root.left =  buildTree(getSubArray(inorder, 0, leftSubArraylength), getSubArray(postorder, 0, leftSubArraylength));
        root.right = buildTree(getSubArray(inorder, inorderRootIndex+1, rightSubArraylength), getSubArray(postorder, leftSubArraylength, rightSubArraylength)); 

        return root;
    }

    private static int[] getSubArray(int[] array, int startIndex, int length){
        if(startIndex < 0 || startIndex >= array.length) return new int[0];

        int[] subArray = new int[length]; 

        for(int i = startIndex, j=0; j < length ; ++i, ++j){
            subArray[j] = array[i];
        }

        return subArray; 
    }

    private static int getIndexOf(int[] elements, int element){
        for(int i = 0; i<elements.length; ++i){
            if(elements[i] == element){
                return i;
            }
        }
        return -1;
    }
}
