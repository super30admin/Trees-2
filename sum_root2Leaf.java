// Time Complexity :O(n) n-number of nodes
// Space Complexity :O(h) h- maximum height of the tree 
// Did this code successfully run on Leetcode :yes 
class Solution {
    class pair {
          TreeNode node;
          int value;
          public pair(TreeNode node,int value)
          {
             this.node=node;
             this.value=value;
          }
          public TreeNode getKey()
          {
              return this.node;
          }
          public int getValue()
          {
              return this.value;
          }

      }
    public int sumNumbers(TreeNode root) {
       
        return helper(root,0);
    }
    
    private int helper(TreeNode root,int currSum)
    {
        if(root==null)
            return 0;
            
        if(root.right==null && root.left==null)
            return currSum*10+root.val;
            
        int left=helper(root.left,currSum*10+root.val);
        int right=helper(root.right,currSum*10+root.val);
        
        return left+right;
    }
}
/* Iterative Solution

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
 
class Solution {
    class pair {
          TreeNode node;
          int value;
          public pair(TreeNode node,int value)
          {
             this.node=node;
             this.value=value;
          }
          public TreeNode getKey()
          {
              return this.node;
          }
          public int getValue()
          {
              return this.value;
          }

      }
    public int sumNumbers(TreeNode root) {
        int currSum=0;int result=0;
        Stack<pair> st=new Stack<>();
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                currSum=currSum*10+root.val;
                st.push(new pair(root,currSum));
                root=root.left;
            }
            pair temp=st.pop();
            root=temp.getKey();
            currSum=temp.getValue();
            if(root.right==null && root.left==null)
                result+=currSum;
            root=root.right;
        }
        return result;
    }
}
*/