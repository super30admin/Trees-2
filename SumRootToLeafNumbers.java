// TC - O(n)
// SC - O(h)

import java.util.*;

public class SumRootToLeafNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Iterative
    public static class Solution1 {
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

    // Recursive void function

    public static class Solution2 {
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

    // Recursive int function
    public static class Solution3 {
        int result;

        public int sumNumbers(TreeNode root) {
            helper(root, 0);
            return result;
        }

        private int helper(TreeNode root, int currNum) {

            //base case
            if (root == null)
                return 0;

            //logic
            currNum = currNum * 10 + root.val;

            //check leaf
            if (root.left == null && root.right == null) {
                result += currNum;
                return currNum;
            }

            return helper(root.left, currNum) + helper(root.right, currNum);
        }
    }

}
