class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// TC: O(n) for both the approaches.
// SC: O(h) for both the approaches.

// I have used two approaches, DFS traversal(integer parameter which maintains
// the sum moving up or down the nodes) and other with DFS traversal along with
// backtracking
public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(sumNumbersWithDFS(root)); // 25
        System.out.println(sumNumbersDFSAlongWithBacktracking(root)); // 25

        TreeNode root1 = new TreeNode(4, new TreeNode(9), new TreeNode(0));
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(1);
        System.out.println(sumNumbersWithDFS(root1)); // 1026
        System.out.println(sumNumbersDFSAlongWithBacktracking(root1)); // 1026
    }

    static int result;

    private static int sumNumbersWithDFS(TreeNode root) {
        result = 0;
        getSumWithDFS(root, 0);
        return result;
    }

    private static void getSumWithDFS(TreeNode root, int current) {
        if (root == null)
            return;

        current = current * 10 + root.val;
        if (root.left == null && root.right == null)
            result += current;
        getSumWithDFS(root.left, current);
        getSumWithDFS(root.right, current);
    }

    private static int sumNumbersDFSAlongWithBacktracking(TreeNode root) {
        result = 0;
        dfsWithBacktracking(root, new StringBuilder());
        return result;
    }

    private static void dfsWithBacktracking(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        sb.append(root.val);
        if (root.left == null && root.right == null)
            result += Integer.parseInt(sb.toString());
        dfsWithBacktracking(root.left, sb);
        dfsWithBacktracking(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

}