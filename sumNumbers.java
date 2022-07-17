// TC - O(n);
// SC - O(1);
class Solution {

    public int sumNumbers(TreeNode root) {
       return helper(root,0);
    }
    private int helper(TreeNode root,int num){
        //base
        if(root==null) return 0;
        //logic
        num = num*10 + root.val; 
        
        if(root.left==null && root.right == null){
            return num;
        }
        return helper(root.left,num) + helper(root.right,num);
        
    } 
}


//Less optimal solution

// class Solution {
//     int sum=0;
//     String num = "";
//     public int sumNumbers(TreeNode root) {
//        return helper(root);
//     }
//     private int helper(TreeNode root){
//         //base
//         if(root.left==null && root.right == null){
//             num = num + root.val;
//             sum = sum+ Integer.parseInt(num);
//             num = num.substring(0,num.length()-1);
//             return sum;
//         } 
//         //logic
//         num = num + root.val;
        
//         if(root.left!=null) helper(root.left);
        
//         if(root.right!=null) helper(root.right);
//         num = num.substring(0,num.length()-1);
//         return sum;
//     } 
// }