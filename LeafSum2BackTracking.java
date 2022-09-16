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
//tc - o(n)
//sc- o(h)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root,0,new ArrayList<>(), targetSum);
        return result;
    }
    private void helper(TreeNode root, int currsum, List<Integer> path, int target)
    {
        //base case
        if(root == null) return;
        
        currsum += root.val;
   //action
        path.add(root.val);
        
        //leaf node //we can add this code before after or inbtwwn recursive calls 
        //as we can do it pre post or inorder
        if(root.left == null && root.right == null)
        {
            if(currsum == target)
            result.add(new ArrayList<>(path)); // store solution nefore backtracking
        }
        //recurse
        //logic if temp taken pass temp as path
        helper(root.left, currsum, path, target);
        helper(root.right, currsum, path,target);
        
        //backtrack
        
        path.remove(path.size()-1);
        
    }
}