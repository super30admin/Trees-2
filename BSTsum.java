//Time complexity: O(N) since the recursion will happen for the length of the tree.
//Space Complexity:O(h) h is the height of the tree
//In this problem, I'll use a helper function called findSum, which will return 0 if the node is null or return order multiplied with 10 + the value or will recursively call the same function for the left and the right part separately by passing the left and the right element as the root element and the order to be equal to order*10 +val and will return their sum. 
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public int sumNumbers(TreeNode root) {
        return findSum(root,0);
    }
    private int findSum(TreeNode root,int order){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return order*10+root.val;
        }
        return findSum(root.left,order*10+root.val) +findSum(root.right,order*10+root.val);
    }
}
