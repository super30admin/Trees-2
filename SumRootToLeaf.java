// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class SumRootToLeaf {
}
/* Method 3 -Recursive Method - return type int
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }

    private int helper(TreeNode root, int currNum){

        //base case
        if(root == null)
            return 0;

        //logic
        currNum = currNum *10 + root.val;

        //check leaf
        if(root.left == null && root.right == null){
            result += currNum;
            return currNum;
        }

        return helper(root.left, currNum) + helper(root.right,currNum);
    }
}
/* Method 2 -Recursive Method - return type void
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int currNum){

        //base case
        if(root == null)
            return;

        //logic
        currNum = currNum *10 + root.val;

        //check leaf
        if(root.left == null && root.right == null)
            result += currNum;

        helper(root.left, currNum);
        helper(root.right,currNum);
    }
}




/* Method 1 -Iterative
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

class Solution {
    public int sumNumbers(TreeNode root) {

        Stack<TreeNode> st  = new Stack<>();
        Stack<Integer> numSt = new Stack<>();

        int currNum = 0;
        int result = 0;

        while(root != null || !st.isEmpty()){
            while(root != null){
                currNum = currNum *10 + root.val;
                st.push(root);
                numSt.push(currNum);
                root = root.left;
            }

            root = st.pop();
            currNum = numSt.pop();

            //check leaf
            if(root.left == null && root.right == null){
                result += currNum;
            }

            root = root.right;
        }
        return result;
    }
}
*/