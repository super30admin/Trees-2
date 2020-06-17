
// Time Complexity : O(n)
//Space Complexity : O(h) 
//Did this code successfully run on Leetcode : Yes

class Solution {
    class Pair{
        TreeNode node;
        int value;
        public Pair(TreeNode node, int value){
            this.node= node;
            this.value = value;
            
        }
        
        public TreeNode getKey(){
            return this.node;
        }
        
        public int getValue(){
            return this.value;
        }
    }
    
   
    public int sumNumbers(TreeNode root) {
         int result = 0;
        int currSum = 0;
        Stack<Pair> st = new Stack<>();
        
        while(root != null || !st.isEmpty()){
            while(root != null){
                currSum = currSum * 10 + root.val;
                st.push(new Pair(root,currSum));
                root = root.left;
            }
            
            Pair p = st.pop();
            root = p.getKey();
            currSum = p.getValue();
            if(root.left == null && root.right == null) {
                result = result + currSum;
            }
            
            root = root.right;
            
        }
        return result;
    }
}