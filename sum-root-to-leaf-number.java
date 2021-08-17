//Time Complexity: O(n), where n is the number of elements in the tree
//Space complexity: O(h), where h is height of the tree
//running on leetcode: yes
class Solution {
    //global sum (class variable)
    int sum;
    public int sumNumbers(TreeNode root) {
        //empty tree
        if (root==null)
        {
            return 0;
        }
        helper(root,0); //0 is the current sum here
        return sum;
    }
     private void helper(TreeNode root, int currSum){
         //base case
         if (root==null){
             return;
         }
         //logic
         currSum=currSum*10+root.val;
         //move to the left side of the root and calculate sum
         helper(root.left, currSum);
         //check if its a leaf node
         if (root.left==null && root.right==null)
         {
             //add the currSum to global variable
             sum += currSum;
         }
         //move to right side
         helper(root.right, currSum);
     }
}
