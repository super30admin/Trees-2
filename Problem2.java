// Time Complexity - O(n) where n is the number of elements in the tree
// Space Complexity - O(h) if we consider the recursive stack as the extra space. At a time maximum there will be elements equal to the height of the tree.
// Below recursive solution worked on LeetCode

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);  // call helper  function for root node with value initialized as 0
    }
    private int helper(TreeNode node, int value){
        if(node == null)    return 0;     // if node is null return 0 value
        if(node.left == null && node.right == null) // if both left and right node is null
            return value*10 + node.val;
        return helper(node.left,value*10 + node.val) + helper(node.right,value*10 + node.val); // if atleast one of the right and left has value
    }
}
