/**
 * Time Complexity - O(N)
 * Space Complexity - O(H) - H represents the height of the tree
 */

class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {

        sumRootLeaf(root, 0);
        return result;

    }
    private int sumRootLeaf(TreeNode node,int sum) {
        if(node == null)
            return 0;

        sum = sum * 10 + node.val;

        if(node.left == null && node.right == null)
            result += sum;

        sumRootLeaf(node.left,sum);

        sumRootLeaf(node.right,sum);


        return result;
    }
}