// Time Complexity : O(n), since dfs, we need to visit each node
// Space Complexity : O(log n) for stack space 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no, the thought of dfs came to mind quickly

// Your code here along with comments explaining your approach
// idea is to do a dfs since we need to make a num that way
// only catch is it is valid only if the end is actually a leaf node, so need to look if both left and right children are null

class Solution {
    //ArrayList<Integer> paths = new ArrayList<Integer>();
    int curSum = 0;
    
    private void dfs(TreeNode root, int current_num_from_path){
        current_num_from_path = current_num_from_path*10 + root.val;
        
        if(root.left!=null)
            dfs(root.left, current_num_from_path);
        if(root.right!=null)
            dfs(root.right, current_num_from_path);
        
        else if(root.left==null && root.right==null){    
            //paths.add(current_num_from_path);
            curSum += current_num_from_path;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        
        int current_num_from_path = 0;
        dfs(root, current_num_from_path);
        
        /*
        int sum = 0;
        for(int pathNum : paths){
            sum+=pathNum;
        }
        */
        return curSum;
    }
}