// Time Complexity : O(n) n nodes
// Space Complexity :O(h) height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
Traverse throught the whole tree and store the nodes at the path in a stack as alist at every node and also the current sum
at every node . when the sum is equal to the targetsum then we can append the list into the result list and move forward.
when we reach the end we can backtrack through the list to move to right of the node and so on.
//In the end the resut list of lists is returned.



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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,0,new ArrayList<>(),targetSum);
        return result;
    }
    private void helper(TreeNode root,int cursum,List<Integer>path, int targetSum){
        if(root==null) return;
        path.add(root.val);
        cursum=cursum+root.val;
        helper(root.left,cursum,new ArrayList<>(path),targetSum);
        if(root.left==null && root.right==null){
            if(cursum==targetSum){
            result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.right,cursum,new ArrayList<>(path),targetSum);
        path.remove(path.size()-1);
        return;
    }
}