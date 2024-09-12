/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Algorithm:
Recursive:
    1. While going to the left or to the right of the tree, multiply previous value with 10 and add the present node value to it.
    2. If we hit a node which is null return 0
    3 If both left and right node are null then return the value*10 + present node value.
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Did the code run successfully on leetcode? Yes

*/
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    
    private int helper(TreeNode node, int value){
             
        //Base cases
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return value*10 + node.val;
        
        
        return helper(node.left, value*10+node.val) + helper(node.right, value*10 + node.val);
    }
    

}