// Time Complexity : O(n)
// Space Complexity : O(n) n is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//starting from root node keep going left with recrsion by keeping track of the current sum as written below (n*10+val)
//after reaching the end, add it to the output and check for the right.
//if right is present add it to the sum else return.

class Solution {
    int output=0;
    public int sumNumbers(TreeNode root) {
        recurr(root,0);
        return output;
    }

    public void recurr(TreeNode root, int curr) {
        if(root==null){
            return;
        }
        int sum = curr*10+root.val;

        if(root.left == null && root.right == null){
            output+= sum;
            return;
        }
        recurr(root.left,sum);
        recurr(root.right,sum);
    }
}