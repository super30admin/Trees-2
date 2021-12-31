//Time Complexity: O(n)
//Space Complexity: O(h) where h is the height of the tree
public class SumTree {
    public int sumNumbers(TreeNode root) {
        int result = helper(root, 0);
        return result;
    }
    public static int helper(TreeNode node, int x){
        if(node==null)
            return 0;
        x *= 10;
        x += node.val;
        if(node.left==null && node.right==null)
            return x;
        return helper(node.left, x) + helper(node.right,x);
    }
}
