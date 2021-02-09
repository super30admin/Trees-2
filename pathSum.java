// Time Complexity : O(n*n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// use recursive dfs to visit all paths and add to ans list which ever path meet our target
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans = new ArrayList();
        helper(root, targetSum, ans, new ArrayList());
        return ans;
        
    }
    
    public void helper(TreeNode root, int target,  List<List<Integer>> ans, List<Integer> temp) {
        
            if(root==null) return;
        
            temp.add(root.val);
            if(root.left==null && root.right==null && target == root.val) {
                ans.add(new ArrayList(temp));
                temp.remove(temp.size()-1);
                return;
            } 
            
            helper(root.left, target-root.val, ans, temp);
            helper(root.right, target-root.val, ans, temp);
            temp.remove(temp.size()-1);
            
        
    }
}
