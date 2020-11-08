/**
 * Time Complexity: O(n)
 * Space Complexity: O(1) no extra space
 * Leetcode : Yes
 * Idea:
 * 1. Visit every node and calculate sum so far and return sum on leaf node. 
 * 2. Add sum of left and right subtree if not a leaf node
 * 3. return final sum
 */
class SumRootToLeaf {
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }

        /**rev */
        public int helper(TreeNode root, int currSum){
            
            if(root == null) return 0;
            
            currSum = currSum * 10 + root.val;

            if(root.right == null && root.left == null) return currSum;

            return helper(root.left, currSum) + helper(root.right, currSum);
        }
        public int findSum(TreeNode root){
            return helper(root, 0);
        }
        /**rev */
    public int sumNumbersHelper(TreeNode root, int sumSoFar){
        // base
        if(root == null) return 0;
        
        int val = sumSoFar * 10 + root.val;

        if(root.right == null && root.left == null)
            return val;
        
        return sumNumbersHelper(root.left, val) + sumNumbersHelper(root.right, val);
    }
    public int sumNumbers(TreeNode root) {               
        return sumNumbersHelper(root, 0);       
    }
    public static void main(String[] args){
        System.out.println("SumRootToLeaf");
        SumRootToLeaf obj = new SumRootToLeaf();
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        //System.out.println(obj.sumNumbers(tree));
        System.out.println(obj.findSum(tree));
    }
}