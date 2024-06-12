// Time Complexity : O(N) N=number of elements  in  the TREE. 
// Space Complexity : O(1) no extra space used. With recursive stack is O(max(depth)) 
// Any problem you faced while coding this :


// we traverse the tree recursively from left to right and add the sum from root left plus root to right  
//Success
//Details 
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
//Memory Usage: 39.8 MB, less than 5.13% of Java online submissions for Sum Root to
  class Solution {
    public int sumNumbers(TreeNode root) {
        if (root ==null)
            return 0;
        return recSum(root,0);
        
    }
    private int recSum(TreeNode root, int sum){
        int cSum= (sum*10)+ root.val;
        if (root.left==null && root.right==null)//leaf
            return cSum;
        int l=root.left==null? 0:recSum(root.left, cSum);
        int r=root.right==null? 0:recSum(root.right,cSum);
        return l+r;
    }
}