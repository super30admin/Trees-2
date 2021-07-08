// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Decision between sum as local or global variable
/* Your code here along with comments explaining your approach: s string is used to take the paths from root to leaf in form of a string. And sum
the s ( by conversion from s to integer) and add it to sum variable. Similarly, recursively, find all the paths from root to leaf and as you reach
leaf, you know that you've got a path, convert that path from string to integer and sum it up. Return the global sum.
*/
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        String s = "";
        return sum(root, s);    
    }
    private int sum(TreeNode root, String s){
    if(root == null){return 0;}
     s += root.val;                                     // Add the nodes one by one as you come across these nodes from the path in root to leaf
    if(root.left == null && root.right == null){
        sum+=Integer.parseInt(s);                       // leaf node => whatever path you got, convert that path into integer and sum it up
    }
        sum(root.left, s);
        sum(root.right, s);
        return sum;                             // Return the global sum
    }
}