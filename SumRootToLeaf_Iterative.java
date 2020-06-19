// Time Complexity : O(n) --> where n is length of input array
// Space Complexity : O(h) --> where h is height of tree (log n to n)
// Did this code successfully run on Leetcode (129): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    class Pair {
        TreeNode node;
        int value;
        public Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
        public TreeNode getKey() {
            return this.node;
        }
        public int getValue() {
            return this.value;
        } 
    }
    
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        Stack<Pair> st = new Stack<>();
        int result = 0;
        int currSum = 0;
        
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                currSum = currSum * 10 + root.val;
                st.push(new Pair(root, currSum));
                root = root.left; 
            }
            
            Pair p = st.pop();
            root = p.getKey();
            currSum = p.getValue();
            
            // check for leaf
            if (root.left == null && root.right == null) result += currSum;
            
            root = root.right;
        }    
        return result;
    }
}