//Time Complexity : O(n), where n is the number of nodes in the tree
//Space Complexity : O(h), h is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    //declare a global variable to hold the result of each path
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        //helper function to calculate the sum. Initially the sum is 0
        inorder(root,0);
        return result;
    }
    private void inorder(TreeNode root, int sum){
        if(root == null){
            return;
        }
        //calculate the local sum at each node or level using the sum from the parent node
        int currsum = sum * 10 + root.val;
        //perform inorder 
        inorder(root.left, currsum);
        //when reached at leaf node calculate the final sum for respective path
        if(root.left==null && root.right==null){
            result = result + currsum;
        }
        //after completeing the left path calculation move to the right path
        inorder(root.right, currsum);
    }
}
© 2021 GitHub, Inc.