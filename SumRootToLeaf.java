//Time Complexity: O(n) where n is the maximum depth of the tree
//Space Complexity: O(1)

public class SumRootToLeaf {
    public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    public static int helper(TreeNode root, int val){
        if(root == null)
            return 0;
        
        //multiply the val by 10 and add the current root value
        val = val*10 + root.val;
        
        // if at leaf node directly return the val
        if(root.left == null && root.right == null)
            return val;
        
        //recursively 
        return helper(root.left, val) + helper(root.right, val);
    }

    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(sumNumbers(r));
    }
}