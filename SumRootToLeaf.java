// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * We iterate through the all the nodes and store the localSum through te path
 * When we encounter a leaf node, we add the localSum to the result.
 * We used a pair class to store the localSum and the node associated with it.
 */


class Pair {
    TreeNode node;
    int localSum;
    
    public Pair(TreeNode node, int localSum) {
        this.node = node;
        this.localSum = localSum;
    }
    
    public TreeNode getKey() {
        return this.node;
    }
    
    public int getValue() {
        return this.localSum;
    }
    
}
class Solution {
    
    public int sumNumbers(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        
        int sum = 0;
        int curSum = 0;
        
        while(!st.isEmpty() || root != null) {
            while(root != null) {
                curSum = curSum*10 + root.val;
                st.push(new Pair(root, curSum));
                root = root.left;
            }
            
            Pair p = st.pop();
            
            root = p.getKey();
            curSum = p.getValue();
            
            if(root.left == null && root.right == null) {
                sum += curSum;
            }
            
            root = root.right;
        }
        
        return sum;
    }
}
