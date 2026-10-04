//Time Complexity: O(n)
//Space Complexity: O(h)
public class SumRootToLeaf {
    int sum;
    public int sumNumbers(TreeNode root) {
        this.sum = 0;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int curr) {
        //base case
        if(root == null) return;

        curr = curr * 10 + root.val;

        if(root.left == null && root.right == null) {
            sum += curr;
        }

        //logic

        helper(root.left, curr);

        helper(root.right, curr);

    }
}

