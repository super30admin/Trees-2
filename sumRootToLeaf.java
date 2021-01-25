//TC - O(n) where n is number of nodes.
//SC - O(h) where h is height if the tree.
// Step1 - Since we have to get sum of each leaf node, we will calculate it by multiplying to 10 and adding to the current root.
// Step2 - we will keep moving to left or right till we hit the null.
// Step3 - as soon as we hit the null we will calculate the current sum for that leaf and add it to the global currSum.
// Step4 - at the end we will return currSum

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int currSum){
        if(root == null) return;
        if(root.left == null && root.right == null){
            result += currSum * 10 + root.val;
        }
        currSum = currSum * 10 + root.val;
        helper(root.left, currSum);   
        helper(root.right, currSum);
    }
}
