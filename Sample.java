// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0)
        {
            return null;
        }    
        index=postorder.length-1;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(inorder,postorder,0,postorder.length-1);
    }
    private TreeNode helper(int[] inorder, int[] postorder,int start,int end)
    {
        if(start>end)
            return null;
        int rootIndex=map.get(postorder[index]);
        TreeNode root=new TreeNode(postorder[index]);
        index--;
        root.right=helper(inorder,postorder,rootIndex+1,end);
        root.left=helper(inorder,postorder,start,rootIndex-1);
        return root;
    }
}



// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


//Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
   //     Stack<Pair> st=new Stack<>();
       
        //int currSum=0;
        helper(root,0);
        return result;
       /* while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                currSum=currSum*10+root.val;
                st.push(new Pair(root,currSum));
                root=root.left;
            }
             Pair p=st.pop();
            root=p.getKey();
            currSum= p.getValue();
            if(root.left==null && root.right==null)
            {
                result+=currSum;
            }
            root=root.right;
        }
        return result;
    }*/
    }
    private void helper(TreeNode root,int currSum)
    {
        if(root==null)  return;
        currSum=currSum*10+root.val;
        helper(root.left,currSum);
        if(root.left==null && root.right==null)
        {
            result+=currSum;
        }
        helper(root.right,currSum);
    }
}
 