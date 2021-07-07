//129.
//time - O(n)
//space - O(h) - height of tree
//function calls
        // (4, 0) -> (9, 40) -> (5, 490) -> adds 495 to sum
        //                   -> (1, 490) -> adds 491 to sum
        //        -> (0, 40) -> adds 40 to sum
                        
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumUtil(root, 0);
        return sum;
    }
    
    public void sumUtil(TreeNode root, int currentSum) {
        //base
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
            sum += root.val + currentSum;
            return;
        }
        //logic
        currentSum = (currentSum + root.val) * 10;
        sumUtil(root.left, currentSum);
        sumUtil(root.right, currentSum);
    }
}
