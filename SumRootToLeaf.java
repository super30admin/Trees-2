class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {

        int result = 0;
        int currentSum= 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> item = stack.pop();
            currentSum = item.getValue();

            if (root != null) {
                currentSum = currentSum * 10 + root.val;

                if (root.left == null && root.right == null) {
                    result+=currentSum;
                } else {
                    stack.push(new Pair(root.right, currentSum));
                    stack.push(new Pair(root.left, currentSum));
                }

            }

        }
        return result;


    }
}