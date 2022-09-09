// Time complexity: O(N)
// Space complexity: O(H)

// Iterative approach

class Pair {
    TreeNode root;
    int currSum;
    
    public Pair(TreeNode root, int currSum) {
        this.root = root;
        this.currSum = currSum;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        int currSum = 0;
        int result = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                currSum = currSum*10 + root.val;
                stack.push(new Pair(root, currSum));
                root = root.left;
            }
            Pair pair = stack.pop();
            root = pair.root;
            currSum = pair.currSum;
            if (root.left == null && root.right == null) {
                result += currSum;
            }
            root = root.right;
        }
        return result;
    }
}