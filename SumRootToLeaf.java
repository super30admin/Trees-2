import javax.swing.tree.TreeNode;


public class SumRootToLeaf {
    public class TreeNode {
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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, 0);
        return sum;

    }

    private  void dfs(TreeNode root, int currentNum) {
        // base case
        if (root == null) {
            return;
        }
        if(root.left==null && root.right ==null){
            sum = sum + currentNum*10 + root.val;
        }
        dfs(root.left, currentNum*10+root.val);
        dfs(root.right, currentNum*10+root.val);

    }
}
