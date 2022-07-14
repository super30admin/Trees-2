// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        //sum =0;
        helper(root,0);
        return sum;
    }
    
    private void helper(TreeNode root,int num){
        // we will encounter left node null but to move to right node we have to continue  function so we will return root ==null true to go to line 37 helper(root.right...)
        if(root==null){
            return;
        }
        //leaf node occured
        if(root.left==null && root.right==null){
            sum=sum+(num*10+root.val);
            return;
        }
        
        helper(root.left,num*10+root.val);
        helper(root.right,num*10+root.val);
    }
}
