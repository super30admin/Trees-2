
//Approach 1: Iterative
//TC: O(n) all nodes traveres one time
//SC: O(h) height of the stack
// class Solution {
//     public int sumNumbers(TreeNode root) {
//         //create two stacks one for node and one for the curr sum or node sum
//         Stack<TreeNode> s = new Stack<>();
//         Stack<Integer> nums = new Stack<>();
//         //intitalize sum and result to 0
//         int currSum=0;
//         int res=0;
//         //normal inorder while loop to traverse the tree
//         while(root!=null || !s.isEmpty()){
            
//             //normal while loop to store left nodes in the stack with the currSum calculations
//             while(root!=null){
//                 s.push(root);
//                 currSum=currSum*10+root.val;
//                 nums.push(currSum);
//                 root=root.left;
//             }
//             //pop the last node and corresponding currSum
//             root = s.pop();
//             currSum = nums.pop();
            
//             //check if its a leaf node - i.e. no child to right and no child to left
//             if(root.left ==null && root.right==null){
//                 res = res+currSum;
//             }
            
//             //move to the right node
//             root = root.right;
//         }
        
        
//         return res;
        
//     }
// }

// Approach 2: Recursive

class Solution {
    int res;
    public int sumNumbers(TreeNode root) {
        int currSum =0;
        res=0;
        helper(root, currSum);
        return res;
    }
    
    private int helper(TreeNode root, int currSum){
        
        if(root==null){
            return res ;
        }
        //calculate the currSum 
        currSum = currSum*10+root.val;
         //recursively call left and right child
        helper(root.left, currSum);
        helper(root.right,currSum);
        //check for the leaf node and update the result
       if(root.left==null && root.right==null){
            res=res+currSum;
        }
        
       return res;
    }
}