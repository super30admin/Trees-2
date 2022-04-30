//Time Complexity: O(N)
//Space Complexity: O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class SumtoLeafNumbersWithReturn {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return -1;
        }


        // Without global sum
        return helper(root, 0);
    }

    public int helper(TreeNode root, int currentSum){

        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return currentSum * 10 + root.val;
        }

        int case1 = helper(root.left, currentSum * 10 + root.val);
        int case2 = helper(root.right, currentSum * 10 + root.val);

        return case1 + case2;
    }
}
