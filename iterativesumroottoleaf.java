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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode>st=new Stack<>();
        Stack<Integer>numst=new Stack<>();
        int currsum=0;
        if(root==null) return sum;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                currsum=currsum*10+root.val;
                numst.push(currsum);
                root=root.left;
            }
            root=st.pop();
            currsum=numst.pop();
            if(root.left==null && root.right==null){
                sum=sum+currsum;
            }
            root=root.right;
        }
        return sum;
        
    }
}
                
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
    