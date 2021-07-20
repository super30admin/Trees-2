// Time Complexity : O(n)
// Space Complexity : O(H), H = Height of the tree
// Did this code successfully run on Leetcode : Yes
class Pair {
    TreeNode root;
    int sum;
    
    Pair(TreeNode root, int sum) {
        this.root = root;
        this.sum = sum;
    }
    
    TreeNode getKey() {
        return this.root;
    }
    
    int getVal() {
        return this.sum;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        Stack<Pair> stack = new Stack<>();
        int currSum = 0, result = 0;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                currSum = currSum * 10 + root.val;
                stack.push(new Pair(root, currSum));
                root = root.left;
            }
            Pair p = stack.pop();
            root = p.getKey();
            currSum = p.getVal();
            if(root.left == null && root.right == null)
                result += currSum; 
            root = root.right;
        }
        return result;
    }
}