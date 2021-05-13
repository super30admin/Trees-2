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
    int target;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         result = new ArrayList<>();
         target= targetSum;
        System.out.println(target);
         helper(root, 0, new ArrayList<>());
        return result;
    }
    //using backtracking
    public void helper(TreeNode root, int currSum, List<Integer> list)
    {
        if(root==null) return;//base
        
        currSum+= root.val;
        list.add(root.val);
        
        //pre
        if(root.left== null && root.right==null)
        {
            if(currSum==target){                
                result.add(new ArrayList<>(list));
                System.out.println("added in result");
            }
            //return;
        } 
        
        helper(root.left, currSum, list);          
        
        helper(root.right, currSum, list);
        
        list.remove(list.size()-1); //remove last element//optimal recursion, bactracking
    }
}