// Time Complexity: O(n)
// Space Compexity: O(h) 
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        calculateSum(root, 0);
        return sum;
        
    }

    public void calculateSum(TreeNode root, int currsum){
        if(root == null) return;
        currsum = currsum * 10 + root.val;
        if(root.left == null && root.right == null) sum += currsum;
        calculateSum(root.left, currsum);
        calculateSum(root.right, currsum);
    }
}