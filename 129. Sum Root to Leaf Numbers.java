// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //how can we do without void function??? --  yes
    //Approach 3
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root,0);
    }

    public int helper(TreeNode root, int num){
        //base
        if(root == null) return 0;
        num = num*10+root.val;
        //logic
        if(root.left == null && root.right == null){
            return num;
        }
        return helper(root.left,num)+helper(root.right,num);
    }

    //Approach 2 iterative

    //Approach 1 recursive
//     int sum = 0;
//     public int sumNumbers(TreeNode root) {
//         if(root == null) return 0;
//         helper(root,0);
//         return sum;
//     }

//     public void helper(TreeNode root, int num){
//         //base
//         if(root == null) return;
//         num = num*10+root.val;
        
//         //logic -- inorder traversal
//         //can try with other traversals as well
//         helper(root.left,num);
//         if(root.left == null && root.right == null){
//             sum+=num;
//         }
//         helper(root.right,num);
//     }
}