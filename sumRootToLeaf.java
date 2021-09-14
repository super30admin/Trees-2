// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class sumRootToLeaf {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        addVals(root, 0);
        return sum;
    }
    
    private void addVals(TreeNode root, int value){
        if(root == null) return;
        //When both sides hit null, sum their corresponding values
        if(root.left == null && root.right == null) {
            sum += value + root.val;
            return;
        }
        
        value += root.val;
        addVals(root.left, 10 * value);
        addVals(root.right, 10 * value);
    }
}
