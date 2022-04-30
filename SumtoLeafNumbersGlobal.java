//Time Complexity: O(N)
//Space Complexity: O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class SumtoLeafNumbersGlobal {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return -1;
        }

         //With global Sum;
         helper(root, 0);
         return sum;


    }

    public void helper(TreeNode root, int currentSum){

         if(root == null){
             return;
         }

         if(root.left == null && root.right == null){
             sum += root.val + currentSum * 10;
             return;
         }

         helper(root.left, currentSum * 10 + root.val);
         helper(root.right, currentSum * 10 + root.val);

     }
}
