// Time Complexity :  O(N) no of nodes
// Space Complexity : O(N) - worst case for one side tree, avg n/2
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int sumNumbers(TreeNode root) {
//         if(root == null) return 0;
//         return helper(root, 0);
//     }
//     public int helper(TreeNode root, int result){
//         if(root == null){return 0;}
        
//         if(root.left == null && root.right == null){
//             return result * 10 + root.val;
//         }
        
//         //logic
//         return helper(root.left, result * 10 + root.val) + helper(root.right, result * 10 + root.val);
//         //return result;
        class Pair{
            TreeNode node;
            int value;
            Pair(TreeNode node, int value){
                this.node = node;
                this.value = value;
            }
            private TreeNode getKey(){
                return this.node;
            }
            private int getValue(){
                return this.value;
            }
        }
        if(root == null) return 0;
        Stack<Pair> st = new Stack<Pair>();
        // st.add(root);
        int currSum = 0;
        int result = 0;
        int count = 0;
        while(root != null || !st.isEmpty()){
            while(root != null){
                currSum = root.val + currSum*10;
                st.push(new Pair(root, currSum));
                root = root.left;
            }
            
            Pair p = st.pop();
            root = p.getKey();
            // System.out.println(count++ +" : "+ root.val);
            currSum = p.getValue();
            if(root.left == null && root.right == null){
                result += currSum;
            }
            root = root.right;
        }
        return result;
    }
}