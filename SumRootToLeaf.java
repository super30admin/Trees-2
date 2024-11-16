// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach - in the helper
// function we will check if the current node is a leaf node, if it is then
//we add it to the result. If not we call the left and right node recursively.


public class SumRootToLeaf{
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return result;
    }

    void helper(TreeNode root, int curr){
        if(root == null) return;
        curr = curr * 10 + root.val;
        //seeing if the current node is leaf node 
        if(root.left == null && root.right == null){
            result += curr;
        }
        helper(root.left, curr);
        helper(root.right, curr);
    }
}