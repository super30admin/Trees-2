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
//Approach 1 without using global variable;
class Solution {

    // Time Complexity : 0(n) where n is the nodes in the tree
// Space Complexity : 0(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I used recursion where I initially passed the root and 0 as sum
    //1St I traverse left subtree till I hit leaf. In each recursive call, I store the node and the current sum till that node
    //which is determined by the currentsum * 10 plus the value of the node itself. Then once the leaf is hit, then I calculate
    //the sum of nodes taking individual node as a digit. Then I unwind the recursion stack and then the right part of the tree
    //is hit and the value of its parent taken and then the leaf node is evaluated in the above manner. Finally, the sum of
    //left and right subtree is returned.

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int currentsum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return currentsum * 10 + root.val;
        }
        int case1 = helper(root.left, currentsum * 10 + root.val);
        int case2 = helper(root.right, currentsum * 10 + root.val);
        return case1 + case2;
    }
}

//Approach 2- taking global variable
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
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    public void helper(TreeNode root, int currentsum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum+= currentsum * 10 + root.val;
        }
        helper(root.left, currentsum * 10 + root.val);
        helper(root.right, currentsum * 10 + root.val);
    }
}

//Approach 3- Iterative
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
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        int totalsum = 0;
        int num = 0;
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                num = num*10 + root.val;
                sum.push(num);
                root = root.left;
            }
            root = s.pop();
            num = sum.pop();
            if(root.left == null && root.right == null){
                totalsum = totalsum + num;
            }
            root = root.right;
        }
        return totalsum;
    }
}