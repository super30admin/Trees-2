//Time complexity: O(n)
//space complexity: O(h)

//we use sum at globally because we need to keep track of the total sum of all root-to-leaf numbers
//and currNum locally as we are accessing the current path value

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    private void helper (TreeNode root,Integer currNum){
        if(root==null)
            return;

        currNum=currNum*10+root.val;       

        if(root.left==null && root.right==null)     //when we reach the leaf node update the sum
            sum+=currNum;

        //explore left and right subtrees
        helper(root.left,currNum);
        helper(root.right,currNum);
    }
}