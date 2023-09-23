// Time Complexity : O(n) as it will traverse each node of the tree
// Space Complexity : O(h) space of recursive stack which stores node for all recursive calls
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, initially had a hard time coming up with the correct value to pass to case1 and case2 and also inside the if condition in recursive call

public class Problem2 {

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        //int currSum = 0;

        return inorder(root, 0);
    }

    public int inorder(TreeNode root, int currSum){
        if(root == null){
            return 0;
        }

        int case1 = inorder(root.left, currSum * 10 + root.val);
        if(root.left == null && root.right == null){
            return currSum * 10 + root.val;
        }
        int case2 = inorder(root.right, currSum * 10 + root.val);

        return case1 + case2;

    }
}
