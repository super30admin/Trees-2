public class Problem2 {

    // TC - O(V) - Number of Nodes
    // SC - O(H) - height of Tree - recursion stack

    private static int result;

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

    public static void helper(TreeNode root, int cur) {
        if(root == null) return;

        cur = cur * 10 + root.val;

        if(root.left == null && root.right == null){ // leaf node
            result += cur;
            return;
        }

        helper(root.left, cur);
        helper(root.right, cur);
    }

    public static int sumNumbers(TreeNode root) {
        if(root == null) return result;

        helper(root, 0);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        TreeNode root2 = new TreeNode(4);
        root2.right = new TreeNode(0);
        root2.left = new TreeNode(9);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);

        //System.out.println(sumNumbers(root));
        System.out.println(sumNumbers(root2));
    }
}
