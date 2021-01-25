sum-root-to-leaf-numbers

//Time Complexity - O(n) where n is number of nodes.
//Space Complxity - O(h) where h is height if the tree.
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
        int val;
        
        public Pair(TreeNode node, int val){
            this.node = node;
            this.val = val;
        }
        public TreeNode getNode(){
            return this.node;
        }
        public int getValue(){
            return this.val;
        }
        
    }
    
    
    public int sumNumbers(TreeNode root) {
        if(root ==null) return 0;
        Stack<Pair> st = new Stack<>();
        int currentSum = 0;
        int result =0;
        
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                
                currentSum = currentSum*10 + root.val;
                st.push(new Pair(root,currentSum));
                root = root.left;
                
            }
            Pair p = st.pop();
            root = p.getNode();
            currentSum = p.getValue();
            if(root.left ==null && root.right ==null){
                result = result+currentSum;
            }
            root=root.right;
        }
        
        
        
        return result;
        
        
        
    }
}