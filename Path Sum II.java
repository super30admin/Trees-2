// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList<>();
        //edge
        if(root==null) return result;
        List<Integer> path= new ArrayList<>();
        helper(root,sum,path,0);
        return result;
        
    }
    public void helper(TreeNode root, int target,List<Integer> path, int sum )
    {
        if(root==null) return;
        
        //action
         sum+=root.val;
         path.add(root.val);
        if( root.left==null && root.right==null)
        {
            if(sum==target)
            {
            result.add(new ArrayList<>(path));
            }
        }
        //recursion
        helper(root.left,target,path,sum);
        helper(root.right,target,path,sum);
        path.remove(path.size()-1);
    }
}
