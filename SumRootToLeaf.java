import java.util.Stack;

//## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
//TC:O(n)
//SC:O(h)
class TreeNode {
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
public class SumRootToLeaf {
    // Int based recursion. We need not maintain global variable

    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root, int currNum){
        // base
        if(root == null) return 0;

        currNum = currNum * 10 + root.val;
        if(root.left == null && root.right == null){
            return currNum;
        }
        int left = helper(root.left,currNum);
        int right = helper(root.right,currNum);
        return left + right;
    }
// Void based recursion
    int result;
    public int sumNumbers2(TreeNode root) {
        helper(root, 0);
        return result;
    }
    private void helper2(TreeNode root, int currNum){
        // base
        if(root == null) return;

        currNum = currNum * 10 + root.val;
        // we can write this anywhere between helper function calls or after it.
        if(root.left == null && root.right == null){ // preorder
            result += currNum;
        }
        helper(root.left, currNum);
        //  if(root.left == null && root.right == null){ // inorser
        //     result += currNum;
        // }
        helper(root.right, currNum);
        //  if(root.left == null && root.right == null){  // postorder
        //     result += currNum;
        // }
    }
    public int sumNumbers3(TreeNode root) {
        // Iterative Solution
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int currNum=0;
        int result=0;

        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                currNum = currNum *10 + root.val;
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
