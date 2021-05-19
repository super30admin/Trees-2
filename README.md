# Trees-2

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
class Solution {
     HashMap<Integer,Integer> map = new HashMap<>();
     int idx; 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(postorder.length==0) return null;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        idx=postorder.length-1;
       return helper(inorder,postorder,0,inorder.length-1);
         
    }
    public TreeNode helper(int[] inorder , int[] postorder,int start,int end)
    {
        if(start>end) return null;
        //logic
        int rootIndex=map.get(postorder[idx]);
        TreeNode root= new TreeNode(postorder[idx]);
        idx--;
        root.right=helper(inorder,postorder,rootIndex+1,end);
        root.left=helper(inorder,postorder,start,rootIndex-1);
        return root;
        
    }

        
    
}
TIME COMPLEXITY :O(n)
SPACE COMPLEXITY :O(n/2)
NO ERRORS WHILE EXECUTING .
## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
//to push pair into staack cretaed this reference 
class pair
{
    TreeNode Node;
    int value;
    pair(TreeNode Node,int Value)
    {
        this.Node=Node;
        this.value=Value;
    }
    public TreeNode getKey()
    {
        return this.Node;
    }
    public int getvalue()
    {
        return this.value;
    }
    
    
}

class Solution {
    public int sumNumbers(TreeNode root) {
         Stack<pair> st = new Stack<>();
        int sum=0;
            int result=0;
        
        while(root!=null || !st.isEmpty())
        {
            //push nodesand sum as a pair  into stack 
            while(root!=null)
            {
                sum=sum*10+root.val;
                st.push(new pair(root,sum));
                root=root.left;
            }
            //pop the node doesnt have child and add into the result 
            pair p= st.pop();
            root=p.getKey();
            sum=p.getvalue();
            if(root.left==null && root.right== null)
            {
              result+=sum;
            }
            root=root.right;
       
        
    }
        return result;
}
}
TIME COMPLEXITY :O(n)
SPACE COMPLEXITY :O(n/2)
NO ERRORS WHILE EXECUTING .
   
