// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : minor issues but overall no


// Your code here along with comments explaining your approach
//we will do an inorder traversal through the tree, and at the end of every leaf node we add the sum of that path
//to the total sum, and return the total sum at the very end


public class PathSum1 {

    int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int currSum){
        //base
        if(root == null) return;
        //logic

        //add to current path sum
        currSum = currSum * 10 + root.val;

        //add to total result when at a leaf node
        if(root.left == null && root.right == null){
            result += currSum;
        }
        helper(root.left,currSum);
        helper(root.right,currSum);


    }
}