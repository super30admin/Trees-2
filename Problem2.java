// Time Complexity : O(n)
// Space Complexity : O(H) as H is Height of the stack 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//take a pointer as current number and totalsum and calcualte the sum at each node 
//while diving into recusrion for left tree and right tree and at leaf node
//add to the totalSum


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Problem2 {
    int totalSum;

    public int sumNumbers(TreeNode root) {
        totalSum = 0;
        helper(root, 0);
        return totalSum;
    }

    private void helper(TreeNode root, int currentNumber) {
        if (root == null) return;

        currentNumber = currentNumber * 10 + root.val;

        if (root.left == null && root.right == null) {
            totalSum += currentNumber;
        }

        helper(root.left, currentNumber);
        helper(root.right, currentNumber);
    }

    public static void main(String[] args) {
        Problem2 treeSumNumbers = new Problem2();

        // Constructing a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int result = treeSumNumbers.sumNumbers(root);

        System.out.println("Total Sum: " + result);
    }
}
