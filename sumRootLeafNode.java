// Time Complexity : O(N)
// Space Complexity : O(H) - H = Height of tree  
// Did this code successfully run on Leetcode : Yess
// Any problem you faced while coding this :No

/*
1.  Recursively call the left and right nodes
2. When sending values to the child function multiply current value with 10
3. if it's the last child then return the value
*/

// Your code here along with comments explaining your approach
class Solution {
    //This is the final answer we need to return
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        countNode(root, 0);
        return sum;
    }
    
    public void countNode(TreeNode root, int value) {
        if(root.left == null && root.right == null) sum += value*10 + root.val;
        if(root.left != null) countNode(root.left, value*10 + root.val);
        if(root.right != null) countNode(root.right, value*10 + root.val);
    }
}
