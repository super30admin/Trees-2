// Time complexity 0(n)
// space complexity 0(h)
// code successfully executed in leetcode

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import javafx.util.Pair;
class Solution {
    public int sumNumbers(TreeNode root) {
             int result = 0;
        //edge case
        if(root == null) return result;
        
        Queue <Pair<TreeNode,Integer>> f1 = new LinkedList<>();
        // adding the elements to the queue in a pair wise.
        f1.offer(new Pair(root,0)); 
        // Checking the queue is empty
        while(!f1.isEmpty()){
            Pair<TreeNode,Integer> p = f1.poll();
            TreeNode node = p.getKey();
            int Value = p.getValue();
            
            // checking if node is not null, ifnot, will be performing val*10 + current 
            if(node!= null){    
                Value = Value*10 + node.val;
                if(node.left == null && node.right == null){
                    result = result + Value;
                }
                f1.offer(new Pair(node.left,Value));
                f1.offer(new Pair(node.right,Value));
                
            }
        }
         
        return result;
        
     }
}