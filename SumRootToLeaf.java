// Approach1 - Recursive 
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We keep a track of current sum at every node
// When we reach a leaf node, we add it to the total sum

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        result = 0 ;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int curSum){
        if(root==null)
            return;
        curSum = 10*curSum + root.val;
        if(root.left==null && root.right==null)
            {
                result+= curSum;
                return;
            }
        helper(root.left, curSum);
        helper(root.right, curSum);
        return;
    }
}

// Approach2 - Iterative 
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We keep a track of current sum at every node, and which node to process in additional stacks

class Solution {
    Stack<TreeNode> st;
    Stack<Integer> curSumSt;
    int result;
    public int sumNumbers(TreeNode root) {
        st = new Stack<TreeNode>();
        curSumSt = new Stack<Integer>();
        result = 0 ;
        helper(root);
        return result;
    }
    private void helper(TreeNode root){
        int curSum = 0;
        st.push(root);
        curSumSt.push(curSum);
        while(!st.isEmpty()){
            root = st.pop();
            curSum = curSumSt.pop();
            curSum = 10*curSum + root.val;
            if(root.left==null && root.right==null)
            {
                result+= curSum;
            }
            if(root.left!=null){
                st.push(root.left);
                curSumSt.push(curSum);
            }
            if(root.right!=null){
                st.push(root.right);
                curSumSt.push(curSum);
            }

        }
        return;
    }
}