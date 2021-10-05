// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


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
    List<List<Integer>> result;
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        result = new ArrayList<>();
        dfs(root, new ArrayList<>());
        return finalSum(result);
        
        
    }
    
    private void dfs(TreeNode root, List<Integer> path ){
        if (root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null){
            result.add(new ArrayList<> (path));
        }
        dfs(root.left, new ArrayList<>(path));
        dfs(root.right, new ArrayList<>(path));
        path.remove(path.size() -1);
    }
    
    private int finalSum(List<List<Integer>> result){
        List<Integer> l1 = new ArrayList<>();
        for(int i=0; i < result.size(); i++){
            List<Integer> res1 = result.get(i);
            StringBuffer sb = new StringBuffer();
            for(int j=0; j < res1.size(); j++){
                sb.append(String.valueOf(res1.get(j)));
            }
            l1.add(Integer.valueOf(sb.toString()));
        }
        int k = 0;
        int s1 = 0;
        for(k=0; k <l1.size(); k++){
            s1 = s1 + l1.get(k);
        }
        return s1;
    }
    
}