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
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// logic, go with the left and pass prev * 10 + sum value; once we get any of the left or right null we just add it to some and return form that
// Your code here along with comments explaining your approach

// using recursion
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    public void helper( TreeNode root, int num){
        // base
        if( root == null ) return;
        // logic
        helper( root.left, num*10 + root.val);
        if( root.left == null && root.right == null ){
            sum += num * 10 + root.val;
        }
        helper( root.right, num*10 + root.val);

    }
}

// using iterative
class Solution {
    Stack <TreeNode> st = new Stack<>();
    Stack <Integer> numSum = new Stack<>();
    int sum = 0; int num = 0;
    public int sumNumbers(TreeNode root) {
        while( root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                num = num*10 + root.val;
                numSum.push(num);
                root = root.left;
            }
            // st.pop();
            root = st.pop();
            num = numSum.pop();
            if(root.left == null && root.right == null){
                sum += num;
            }
            root = root.right;
        }
        return sum;
    }
}
