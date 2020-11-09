/**LC-129
 * ITERATIVE SOLUTION
 * Time Complexity : O(N^2) 
 * Space Complexity : O(H) H: height of the tree
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. We keep traversing through the left nodes and pushing them on stack till we get null.
 2. Once we get the null, we go to the parent's right child. 
 3. If both child->null, return the local sum and add tovglobal sum.
 4. If only one child is null, just return and do ntg.t.
 */
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
    class Pair{
    
    TreeNode node;
    int value;
    
    public Pair(TreeNode node, int value){
        
        this.node = node;
        this.value = value;
    }
    
    public TreeNode getKey(){
        return this.node;
    }
    
    public int getValue(){
        return this.value;
    }
}
    public int sumNumbers(TreeNode root) {
        
        Stack<Pair> st = new Stack<>();
        
        int currSum = 0;
        int result = 0;
        while(root != null || !st.isEmpty()){
            
            while(root != null){
                currSum = currSum*10 + root.val;
                st.push(new Pair(root, currSum));
                root = root.left;
            }
            
            Pair p = st.pop();
            root = p.getKey();
            currSum = p.getValue();
            if(root.left == null && root.right == null){
                result += currSum;
            }
            root = root.right;
        }
        return result;
    }
}