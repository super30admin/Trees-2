// Time Complexity : O(n) n nodes
// Space Complexity : O(h) height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
Used two stacks to store the node and the current sum at that node and traverse through the tree in inorder traversal.
when I met the leaf I popped the node I added the current sum to the global sum and afer the whole tree
is traversed I returned the global sum.




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
                
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
    