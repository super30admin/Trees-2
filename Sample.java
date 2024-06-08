// Problem -1
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
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
    int ind;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     if(postorder==null || postorder.length==0 || inorder==null || inorder.length==0)
     {
        return null;
     }   
     map=new HashMap<>();
     ind=postorder.length-1;
     for(int i=0;i<inorder.length;i++)
     {
        map.put(inorder[i],i);
     }
     return recurse(postorder,0,postorder.length-1);
    }
    private TreeNode recurse(int[] postorder, int start,int end)
    {
        if(start>end) return null;
        if(ind<0) return null;
        int rootVal=postorder[ind];
        ind--;
        int rootind=map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        root.left=recurse(postorder,start,rootind-1);
        root.right=recurse(postorder,rootind+1,end);
        return root;
    }
}

// Problem -2
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

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
    public int sumNumbers(TreeNode root) {
      Stack<TreeNode> s=new Stack<>();
      Stack<Integer> curVal=new Stack<>();
      int sum=0;
      int num=0;
      while(root!=null || !s.isEmpty())
      {
        while(root!=null)
        {
            s.push(root);
            num=num*10+root.val;
            curVal.push(num);
            root=root.left;
        }
        root=s.pop();
        num=curVal.pop();
        if(root.left==null && root.right==null)
        {
            sum=sum+num;
        }
        root=root.right;
      } 
      return sum;
    }
}
// recussive solution'
/**
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
 /*
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
     if(root==null) return 0;
     sum=0;
     dfs(root,0);
     return sum;
    }
    private void dfs(TreeNode root, int currentVal)
    {
        if(root ==null) return;
        if(root.left==null && root.right==null)
        {
            sum=sum+currentVal*10+root.val;
            return;
        }
        dfs(root.left,currentVal*10+root.val);
        dfs(root.right,currentVal*10+root.val);
    }
}
 **/