Time Complexity: O(n)
Space Complexity: O(H)
Ran successfully on leetcode?: yes

class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return sum;
    }
    
    private void preorder(TreeNode root, int currSum){
        
        if(root == null) return;
        currSum = currSum*10 + root.val;
        
        if(root.left == null && root.right == null) sum += currSum;
        else {
            preorder(root.left, currSum);
            preorder(root.right, currSum);
        }
    }
}
