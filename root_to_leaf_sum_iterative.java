// Time Complexity : O(n) : Traversing the every node once
// Space Complexity : O(n) - Recursive Stack  O(n)- Iterative (Stack)

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
    
    class Pair {
        // Pair object contains Tree node and temp number as value
        TreeNode node;
        int value;
        
        // constructor
        public Pair(TreeNode node, int value){
            this.value =  value;
            this.node = node;
        }
        
        // Get the node 
        public TreeNode getNode(){
            return this.node;
        }
        
        // Fetch the value
        public int getValue(){
            return this.value;
        }
        
    }
    
    public int sumNumbers(TreeNode root) {
        
        // Preorder Traversal - Iterative approach using stack
        Stack<Pair> stack = new Stack<>();
        
        int result = 0;
        int number = 0;
        
        
        while (root != null || !stack.isEmpty()){
            
            while (root != null){
                
                // NLR : Preorder ( Node operation - (N))
                // update the number 
                number = number * 10 + root.val;
                
                // create a pair with root and number as pair object
                Pair pair = new Pair(root, number);
                
                // Push pair into the stack
                stack.push(pair);
                    
                // NLR : Preorder ( left subtree - (L))
                // For next iteration : Consider the left most child
                root = root.left;
            }
            
            Pair tempPair = stack.pop();
            
            root  = tempPair.getNode();
            
            // Restore the number based on the current node
            number = tempPair.getValue();
            
            // Base Case : Do this only for leaf nodes
            if (root.left ==  null && root.right == null){
                result +=  number;
            }
            
            //  NLR : Preorder ( right subtree - (R))
            root = root.right;
            
        }
     
    
        return result;
    }
    
}