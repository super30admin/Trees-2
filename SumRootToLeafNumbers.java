//The approach here is to use recursion to traverse through the nodes, and when we reach the leaf node, then we add the current sum at the leaf node to the total sum
//Time Complexity: O(n)
//Space Complexity: O(h), where h is the maximum depth from root node to a leaf node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode node, Integer cur){
        //base
        if(node == null) return;
        cur = cur*10 + node.val;
        
        //left
        helper(node.left, cur);
        if(node.left == null && node.right == null){
            sum +=cur;
        }
        //right
        helper(node.right, cur);
    }
}