// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this


// Your code here along with comments explaining your approach

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
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum){
        if(root == null) return;

        currNum = currNum * 10 + root.val;
        if(root.left == null && root.right == null){
            result += currNum;
        }
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
}

// Iterative approach
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

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
    int result = 0;
    int currNum = 0;
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        while(root !=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                currNum = currNum * 10 + root.val;
                numSt.push(currNum);
                root = root.left;
            }
            root = st.pop();
            currNum = numSt.pop();
            if(root.left == null && root.right == null){
                result += currNum;
            }
            root = root.right;
        }
        return result;

    }
}

// Preorder traversal
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

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
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int result = 0;
        int currNum = 0;
        st.push(root);
        numSt.push(currNum);
        while(!st.isEmpty()){
            root = st.pop();
            currNum = numSt.pop();
            currNum = currNum * 10 + root.val;
            if(root.left == null && root.right == null){
                result += currNum;
            }
            if(root.left != null){
                st.push(root.left);
                numSt.push(currNum);
            }
            if(root.right != null){
                st.push(root.right);
                numSt.push(currNum);
            }
        }
        return result;

    }
}