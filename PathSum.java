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
//Time Complexity: O(N).
//Space Complexity: O(NH).
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<>();
        if(root == null) return result;
        
        helper(root, targetSum, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int num, ArrayList<Integer> path){
        
        
        
        if(root == null) return;
        
        path.add(root.val);
        int sum = 0;
        if(root.left == null && root.right == null){
            sum = num + root.val;
            
            if(sum == targetSum){
                result.add(path);
            }
        }
        
        helper(root.left, targetSum, num+root.val, new ArrayList<>(path));
        helper(root.right, targetSum, num+root.val, new ArrayList<>(path));
    }
}