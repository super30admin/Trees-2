// TC - O(n)
// SC - O(1)
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
    public int sumNumbers(TreeNode root) {
//         int ans[] = {0};
//         getCount(root,ans,0);
//         return ans[0];
//     }
//     public void getCount(TreeNode root,int[] ans,int num){
        
//         if(root==null) return;
        
//         if(root.left==null && root.right==null){
//             ans[0] += num*10 + root.val;
//             return;
//         }
//         num = num * 10 + root.val;
//         getCount(root.left,ans,num);
//         getCount(root.right,ans,num);
//         return;
//     }
        
  //// ITERATIVE APPROACH
        
        int sum = 0;
        int num = 0;
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                num = num*10 + root.val;
                nums.push(num);
                root = root.left;
            }
            root = s.pop();
            num = nums.pop();
            if(root.left==null && root.right==null){
                sum = sum + num;
            }
            root = root.right;
        }
        return sum;
        
    }     
}