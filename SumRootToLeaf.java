class Solution {

    public class Pair {

        TreeNode node;
        int value;

        public Pair (TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }

        public TreeNode getKey() {
            return this.node;
        }

        public int getValue() {
            return this.value;
        }
    }
    public int sumNumbers(TreeNode root) {

        if (root == null) return 0;

        Stack<Pair> stack = new Stack<>();
        int currentSum = 0;
        int result = 0;

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                currentSum = currentSum * 10 + root.val;
                stack.push(new Pair (root, currentSum));
                root = root.left;
            }

            Pair p = stack.pop();
            root = p.getKey();
            currentSum = p.getValue();
            if (root.right == null && root.left == null) {
                result += currentSum;
            }
            root = root.right;

        }

        return result;

    }
}

class Solution {

    int result;

    public int sumNumbers(TreeNode root) {

        if (root == null) return 0;
        helper(root, 0);
        return result;

    }

    private void helper(TreeNode root, int currSum) {

        if (root == null) {
            return;
        }

        currSum = currSum * 10 + root.val;
        helper(root.left, currSum);

        if (root.left == null && root.right == null) {
            result += currSum;
        }

        helper(root.right, currSum);
