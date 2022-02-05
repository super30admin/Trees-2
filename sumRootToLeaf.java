//Time Complexity: O(N)
//Space Complexity: O(H)

//Recursive solution

//For the recursive solution, we use a local variable to calculate the sum. This helps us to maintain the sum when the control 
//changes from the child to the parent. We make use of the helper function to calculate  the sum. At every node, the sum is equal
//to the value of the node * 10 + the value of the local variable sum. Iteraing preorder, inorder or postorder will not affect out result.
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int num){
        if(root == null) return;
        
        helper(root.left, num * 10 + root.val);
        
        if(root.left == null && root.right == null){
            sum += num * 10 + root.val;
            return;
        }
        
        helper(root.right, num * 10 + root.val);
        
        
    }
}