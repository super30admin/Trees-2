// Time Complexity :O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

int sum =0; // devlaring global sum
    public int sumNumbers(TreeNode root) {
        helper(root,0); // inputting num as 0 when starting
        return sum; // return sum
    }
    
    private void helper(TreeNode root, int num){
        if(root == null) return;
        
        num = (num*10) + root.val; // checking the value of the num at each node
        
        if(root.left == null && root.right == null){ // if leaf node, only then add it to the sum
            sum += num;
        }
        
        helper(root.left,num); // iterate to the left
        helper(root.right,num);// iterate to the right
    }