// Time Complexity : O(N)
// Space Complexity :  O(H)height of tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    class Pair{
        TreeNode node;
        int value;
        public Pair(TreeNode node, int value){
            this.node=node;
            this.value=value;
        }
        public TreeNode getKey(){
            return this.node;
        }
        public int getValue(){
            return this.value;
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        Stack <Pair> st=new Stack<>();
        int currSum=0; int result=0;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                currSum=currSum*10+root.val;
                st.push(new Pair(root, currSum));
                root=root.left;
            }
            Pair p=st.pop();
            root=p.getKey();
            currSum=p.getValue();
            if(root.left==null && root.right==null){
                result += currSum;
            }
            root=root.right;
        }
        return result;
    }
}