// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the tree, space used in the recursive stack, under the hood
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Recurse to the left of the tree and then to the right of the tree while calulating the current sum at each node, until we reach at the leaf of the tree. Once the leaf is found add the current sum to the result, and then move to the other sub-tree. 

public class SumRootToLeafNumbers {
    int sum;
    
    public int sumNumbers(TreeNode root) {
        
        if(root == null) return 0;
        
        sum = 0;
        recurse(root , root.val);
        return sum;
    }
    
    private void recurse(TreeNode root, int value){
        //base case      
        if(root.left == null && root.right == null)
            sum = sum + value;
        
        //recursive case
        if(root.left != null)
            recurse(root.left, value * 10 + root.left.val);
        
        if(root.right != null)
            recurse(root.right, value * 10 + root.right.val);
    }
}
