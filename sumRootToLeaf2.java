//time O(n)
//space O(h)

class Solution {
    int globalSum = 0;
    public int sumNumbers(TreeNode root) {
        inorder(root, 0);
        return globalSum;
    }
    private void inorder(TreeNode root, int currNum) {
        //base 
        if(root == null) return;

        //logic
        currNum = currNum * 10 + root.val;
        inorder(root.left, currNum);
        if(root.left == null && root.right == null) {
            globalSum += currNum;
        }
        inorder(root.right, currNum);
    }
}
