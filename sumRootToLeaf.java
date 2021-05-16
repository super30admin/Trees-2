
// Space complexity - O(1)
// Space complexity - O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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

//2 approaches can be followed 1) Recursive 2) Iterative
class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        
        
        InorderSum(root, 0);
        
        return result;
    }
    
    private void InorderSum(TreeNode root, int currentValue){
       
        //base condition 1
        if(root == null){
            
            return ; 
        }
        //logic
        currentValue = currentValue * 10 + root.val;
    //    System.out.println("current value is" + currentValue);
        //base condition 2
        if(root.left == null && root.right == null){
            
      //      System.out.println("Result value before is" + result);
            result = result + currentValue;
      //      System.out.println("Result value after is" + result);
        }
        
        
        
        
        InorderSum(root.left, currentValue);
        
        InorderSum(root.right, currentValue);
        
    }
}

//Space complexity - O(n)
//Space complexity - O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
class Pair {
    
    TreeNode node;
    int value;
    
    Pair(TreeNode node, int value){
        
        this.node = node;
        this.value = value;
    }
}
class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        
        if(root == null){return result;}
        
        InorderSum(root,0);
        
        return result;
    }
    
    private void InorderSum(TreeNode root,int currentValue){
        
        Stack<Pair> s1 = new Stack<>();
        //int currentValue = 0;
        
        while(root != null || !s1.isEmpty()){
        while(root != null ){
       // System.out.println(root.val);
        currentValue = currentValue * 10 + root.val;
        Pair p1 = new Pair(root,currentValue);
        s1.add(p1);
        root = root.left;
        
            }
        
        Pair p2 = s1.pop();
        if(p2.node.left == null && p2.node.right == null){
        result = result + p2.value;
        }
        currentValue = p2.value;
       // System.out.println("result is "+result);
        root = p2.node.right;
    }
    }
}
