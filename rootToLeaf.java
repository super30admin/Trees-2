// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int currNum = 0;
        int res = 0;
        st.push(root);
        numSt.push(currNum);

        while (!st.isEmpty()) {
            root = st.pop();
            currNum = numSt.pop();
            currNum = currNum * 10 + root.val;
            if (root.left == null && root.right == null) {
                res += currNum;
            }
            if (root.right != null) {
                st.push(root.right);
                numSt.push(currNum);
            }
            if (root.left != null) {
                st.push(root.left);
                numSt.push(currNum);
            }

        }
        return res;
    }
}

/*
    class Solution {
        int res = 0;
        public int sumNumbers(TreeNode root) {
            helper(root,0);
            return res;
        }

        private void helper(TreeNode root, int curr) {
            if(root == null) return;

            curr = curr * 10 + root.val;
            
            if(root.left == null && root.right == null) {
                res += curr;
                return;
            }

            helper(root.left, curr);
            helper(root.right, curr);
        }
    }
*/