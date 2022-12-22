// Time Complexity : O(n)
// Space Complexity :O(n) // height of the tree

/*
 * keep track of current sum and add that value 
 * to the total sum when it is a leaf node. and run the function
 * on left and right node.
 */

public class SumRootToLeaf {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0); 
        return sum;
    }

    public void helper(TreeNode root, int currSum){
        //base
        if(root == null){
            return;
        }

        //logic
        currSum = currSum*10 + root.val;
        System.out.println(currSum);
        helper(root.left, currSum);
        helper(root.right, currSum);
        if(root.left == null && root.right == null){
            sum += currSum;
        }
    }
}
