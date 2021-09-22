
//Iterative Solution

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
        
        public Pair(TreeNode node, int value ){
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
        int csum = 0;
        int result = 0;
        
        while(root!= null || !st.isEmpty()){
            while(root!=null){
                
                csum= csum*10 + root.val;
                st.push(new Pair(root, csum));
                root = root.left;
            }
            Pair p = st.pop();
            root = p.getKey();
            csum = p.getValue();
            if(root.left == null && root.right == null){
                result += csum;
            }
            
            root = root.right;
          
            
            
        }
        
        return result;
        
    }
}


//TC O(N)
//SC O(H)

//Recursive Solution

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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        int csum = 0;
        
        
        helper(root, 0);
        return result;
        
    }
    private void helper(TreeNode root, int csum){
        if(root==null) return;
        
        csum = csum*10 + root.val;
        helper(root.left,csum);;
        
        
        if(root.left ==null && root.right == null){
            result += csum;
        }
        
        helper(root.right,csum);
    } 
}
