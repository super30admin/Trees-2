// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    
    class Pair{
        TreeNode node;
        int value;
        
        public Pair(TreeNode node,int value){
            this.node = node;
            this.value = value;
        }
        
        public TreeNode getNode(){
            return this.node;
        }
        
        public int getValue(){
            return this.value;
        }
    }
    public int sumNumbers(TreeNode root) {
        
        int CurrSum=0; int result =0;
        Stack<Pair> st = new Stack<>();
        
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                CurrSum = CurrSum*10 + root.val;
                st.push(new Pair(root,CurrSum));
                root = root.left;
            }
            Pair p = st.pop();
            root = p.getNode();
            CurrSum = p.getValue();
            if(root.left==null && root.right==null){
                result = result+CurrSum;
            }
            
            root = root.right;
        }
        
        return result;
    }
}