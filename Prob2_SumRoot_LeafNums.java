// Time Complexity : O(N) --- Iterating over all nodes of tree
// Space Complexity : O(H) - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null)    return 0;
        
        count(root, 0);
        return sum;
    }
    
    public void count(TreeNode root, int num){
        
        if(root == null)  return;
        
        num = num * 10 + root.val;
        
        count(root.left, num);
        //Stack.pop() -- root becomes last num
        
        if(root.left == null && root.right == null){
            sum += num;
        }
        
        count(root.right, num);
    }
    
    
}

