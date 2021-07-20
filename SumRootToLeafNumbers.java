// Time Complexity : O(N) N-> No of Nodes in tree
// Space Complexity : O(H) H-> Height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Iterative
class Pair {
    TreeNode root;
    int currSum;

    Pair(TreeNode root, int currSum) {
        this.root = root;
        this.currSum = currSum;
    }

    public TreeNode getKey() {
        return this.root;
    }
    public int getValue() {
        return this.currSum;
    }
}

class SumRootToLeafNumbers {
    int res;
    public int sumNumbers(TreeNode root) {
        Stack<Pair> stack = new Stack();
        int currSum = 0;
        while(root!= null || !stack.isEmpty()) {

            while(root != null) {
                currSum = currSum * 10 + root.val;
                Pair p = new Pair(root, currSum);
                stack.push(p);
                root = root.left;
            }

            Pair temp = stack.pop();
            root = temp.getKey();
            currSum = temp.getValue();
            if(root.left == null && root.right == null) {
                res += currSum;
            }

            root = root.right;
        }

        return res;
    }
}

class Solution {
    int res;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;

        calculateSum(root, 0);

        return res;
    }
    private void calculateSum(TreeNode root, int currSum) {
        if(root == null)
            return;

        currSum = currSum*10 + root.val;
        calculateSum(root.left, currSum);
        if(root.left == null && root.right == null) {
            res += currSum;
        }
        calculateSum(root.right, currSum);
    }
}