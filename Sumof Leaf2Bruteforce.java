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
//brute force
//tc- o(n2) - every recursive call we need to make a deep copy so n2
//sc-nh (n is numm of list and h is height of tree) in worst case it is n2 when it is skew tree where no of elements is height of the tree
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
        //we can alsio take temp as new array and add root to it
        //List<Integer> temp = new ArrayList<>(path);
        //temp.add(root.val);
        path.add(root.val);
        
        //leaf node
        if(root.left == null && root.right == null)
        {
            if(currsum == target)
            result.add(path);
        }
        
        //logic if temp taken pass temp as path
        helper(root.left, currsum, new ArrayList<>(path), target);
        helper(root.right, currsum, new ArrayList<>(path),target);
        
    }
}