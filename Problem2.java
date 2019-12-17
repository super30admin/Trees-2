/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
LeetCode SUbmitted : YES
Time Complexity : O(2^N)
Space Complexity : O(K) // K number of unique paths from root to leaves

The idea is to recursive find all the paths and then take sum of it. I think the more optimal way could be to store current sum of the parent node at each level of the tree so you dont traverse again from start. Sort of a Queues to store current parent


**/
class Solution {
    public int sumNumbers(TreeNode root) {
        
        if(root == null)
            return 0;
        
        List<Integer> output = new ArrayList<>();
        
        calc(root,0, output);
        
        int sum = 0;
        for(int i : output){
            //System.out.println(i);
            sum += i;
        }
        
        return sum;
        
    }
    
    public void calc(TreeNode root, Integer count,List<Integer> output){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            output.add(Integer.valueOf(String.valueOf(count) + String.valueOf(root.val))); 
            return;
        }
        
        calc(root.left,Integer.valueOf(String.valueOf(count) + String.valueOf(root.val)),output);
        calc(root.right,Integer.valueOf(String.valueOf(count) + String.valueOf(root.val)),output);
        
    }
}
