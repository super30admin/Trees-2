// TC: O(N^2)

// SC: O(1)


// recurvise solution


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
    
    int result;
    public int sumNumbers(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        helper(root, 0);
        
        return result;
        
    }
    
    public void helper(TreeNode root, int currSum){
        
        if(root == null){
            return;
        }
        
        helper(root.left, currSum*10 + root.val);
        helper(root.right, currSum*10 + root.val);
        if(root.left == null && root.right == null){
            result += currSum * 10 + root.val;
        }
    }
    
    
    
}


// TC: O(N)
// SC: O(N)


// iterative solution

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
                return node;
            }
             
            public int getValue(){
                return value;
            }
            
        }
        
    public int sumNumbers(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int result = 0, currSum = 0;
        
        Stack<Pair> s = new Stack<>();
        
        while(root != null || !s.isEmpty() ){
            
            while(root != null){
                
                currSum = currSum * 10 + root.val;
                
                s.push(new Pair(root, currSum));
                
                root = root.left;
            }
            Pair p = s.pop();
            root = p.getKey();
            currSum  = p.getValue();
            if(root.left == null && root.right == null){
                result += currSum;
            }
            root = root.right;
            
         }
       return result;
        
        
    }
}