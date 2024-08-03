/*
  Check for Children Sum Property

  Approach : Recursion, with global status value
  Space complexity : O(n)
  Time complexity : O(1)
*/

class Solution
{
    public static int isSumProperty(Node root)
    {
        SumProperty sp = new SumProperty();
        sp.checkSubtreeSum(root);
        return sp.status;
    }

}

class SumProperty{
    
    int status = 1;
    
    public int checkSubtreeSum(Node root){
        if(root == null) return 0;
        
        if(this.status == 0 || root.left == null && root.right == null) 
            return root.data;
        
        int leftSum = checkSubtreeSum(root.left);
        int rightSum = checkSubtreeSum(root.right);
        
        if(leftSum+rightSum != root.data)
            this.status = 0;
        
        return root.data;
        
    }
}
