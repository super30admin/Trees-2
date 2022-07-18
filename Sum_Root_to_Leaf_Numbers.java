//Time complexity: O(N)
//Space complexity: O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution{
    public int SumNumbers(TreeNode root){
        if(root==null) return 0;
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
            if(root.left ==null && root.right==null){
                sum = sum + num;
            }
            root = root.right;
        }
        return sum;
    }
}




// class Solution {
//     int sum;
//     public int sumNumbers(TreeNode root) {

//         if(root == null) return sum;
//         helper(root, 0);
//         return sum;

//     }
//     private void helper(TreeNode root, int num){
//         if(root == null) return;
//         if(root.left ==null  && root.right == null){
//             sum = sum + num * 10 + root.val;
//             return;
//         }

//         helper(root.left, num*10 + root.val);
//         helper(root.right, num*10 + root.val);
//     }
// }