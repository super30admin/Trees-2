/**
 * Time - O(N) where N is the no. of nodes in the tree.
 * Space - O(H) ~ O(N)
 */
class Solution {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        sumNos(root, 0);
        return total;
    }
    public void sumNos(TreeNode root, int curr) {
        if(root == null)
            return;          
        curr = ( curr * 10 ) + root.val;
        if(root.left == null && root.right == null)
            total += curr;
        sumNos(root.left, curr);
        sumNos(root.right, curr);
    }
}
