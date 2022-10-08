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
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// class Solution {
//     int sum;
//     public int sumNumbers(TreeNode root) {
//         if(root == null)
//             return 0;
        
//         dfs(root, 0);
        
//         return sum;
//     }
    
//     private void dfs(TreeNode root, int num){
//         if(root == null)
//             return;
        
//         if(root.left == null && root.right == null){
//             sum = sum + num * 10 + root.val;
//             return;
//         }
        
//         dfs(root.left, num * 10 + root.val);
//         dfs(root.right, num * 10 + root.val);
//     }
// }

// class Solution {
//     public int sumNumbers(TreeNode root) {
//         if(root == null)
//             return 0;
        
//         return dfs(root, 0);
//     }
    
//     private int dfs(TreeNode root, int num){
//         if(root == null)
//             return 0;
//         if(root.left == null && root.right == null){
//             return num * 10 + root.val;
//         }
        
//         int case1 = dfs(root.left, num * 10 + root.val);
//         int case2 = dfs(root.right, num * 10 + root.val);
        
//         return case1 + case2;
//     }
    
// }

class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int num = 0;
        int sum = 0;
        
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                num = num * 10 + root.val;
                nums.push(num);
                root = root.left;
            }
            root = s.pop();
            num = nums.pop();
            if(root.left == null && root.right == null){
                sum = sum + num;
            }
            root = root.right;
        }
        return sum;
    }
}

