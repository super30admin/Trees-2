// Time Complexity :O(n) where n is the number of nodes in the tree
// Space Complexity : best case: O(log n) and worst case is O(n) where n is the number of nodes
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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

class SumRootToLeaf {
    private int prevSum;
    private int totalSum;

    public int sumNumbers(TreeNode root) {
        preOrderTraversal(root);
        return totalSum;
    }

    private void preOrderTraversal(TreeNode root){

        //base
        if(root.left == null && root.right == null){
            totalSum = totalSum + prevSum * 10 + root.val;
            return;
        }
        //root
        prevSum = prevSum * 10 + root.val;
        //left
        if(root.left != null){
            preOrderTraversal(root.left);
        }
        if(root.right != null){
            preOrderTraversal(root.right);
        }
        prevSum = (prevSum - root.val)/10;
    }
}