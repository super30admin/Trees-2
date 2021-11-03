// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Sum root to leaf

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
    
    int number = 0;
    int result = 0;
    
    class Pair{
        
        TreeNode node;
        int value;
        
        public Pair(TreeNode node, int value){
            
            this.node = node;
            this.value = value;
            
        }
        
        public TreeNode getNode(){
            
            return this.node;
            
        }
        
        public int getValue(){
            
            return this.value;
            
        }
        
    }
    
    public int sumNumbers(TreeNode root) {
        
        // int result = 0;
        // int number = 0;
        
//         Stack<Pair> stack = new Stack<>();
        
//         while(root!=null || !stack.isEmpty()){
            
//             while(root!=null){
                
//                 //NLR
//                 number = number * 10 + root.val;
//                 Pair pair = new Pair(root,number);
                
//                 stack.push(pair);
                
//                 root=root.left;
                
//             }
            
//             Pair pair = stack.pop();
//             root = pair.getNode();
//             number = pair.getValue();
            
//             if(root.left==null && root.right==null){
                
//                 result+=number;
                
//             }
            
//             root = root.right;
            
//         }
        
        // return result;
        
        return helper(root,0);
        
    }
    
    public int helper(TreeNode root, int number){
        
        if(root==null){
            return 0;
        }
        
        if(root.left==null && root.right==null){
            
            result+=number*10 + root.val;
            return result;
            
        }
        
        number = number * 10 + root.val;
        
        helper(root.left, number);
        helper(root.right, number);
        
        return result;
        
    }
    
}


// Time Complexity : O(n)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// construct binary tree from inorder and postorder traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length==0){
            return null;
        }
        
        int n = inorder.length;            
        
        return helper(inorder, 0, n-1, postorder, 0, n-1);
        
    }
    
    public TreeNode helper(int[] inorder, int isi, int iei, int[] postorder, int psi, int pei) {
        
        if(isi>iei){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pei]);
        
        int idx = isi;
        
        while(inorder[idx]!=postorder[pei]){
            idx++;
        }
        
        int telem = idx - isi;
        
        root.left = helper(inorder,isi,idx-1,postorder,psi,psi+telem-1);
        root.right = helper(inorder,idx+1,iei,postorder,psi+telem, pei-1);
        
        return root;
        
    }
    
    
}

