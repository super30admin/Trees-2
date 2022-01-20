# Trees-2

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/a


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
    HashMap<Integer, Integer> map;
    int idx; 
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end)
    {
        //base case
        if(start> end) return null;
        //recursion
        
        int rootVal = preorder[idx];
        idx--;
        int rootIndexInorder = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(preorder, inorder, rootIndexInorder +1, end);
        root.left = helper(preorder, inorder, start, rootIndexInorder-1 );
        
        
        return root;
        
    }
    
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0) return null;
        this.idx = postorder.length -1;
        map = new HashMap<>();
        for(int i=0; i < inorder.length ; i++)
        {
            map.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, postorder.length -1);
    }
}
## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :N/A


// Your code here along with comments explaining your approach
   
//recursive inorder 
class Solution {
    int sum;
    private void inorder(TreeNode root, int currSum)
    {
        if(root == null) return;
        inorder(root.left, currSum*10 + root.val);
        if(root.left == null && root.right == null)
        {
            sum+= currSum* 10 + root.val;
        }
        inorder(root.right, currSum*10 + root.val);
    }
    
    public int sumNumbers(TreeNode root) 
    {
        this.sum=0;
        inorder(root, 0);
        return sum;
    }
}

//recursive preorder
class Solution {
    int sum;
    private void preorder(TreeNode root, int currSum)
    {
        if(root == null) return;
       
        if(root.left == null && root.right == null)
        {
            sum+= currSum* 10 + root.val;
        }
        preorder(root.left, currSum*10 + root.val);
        preorder(root.right, currSum*10 + root.val);
    }
    
    public int sumNumbers(TreeNode root) 
    {
        this.sum=0;
        preorder(root, 0);
        return sum;
    }
}

//recursive postorder
class Solution {
    int sum;
    private void postorder(TreeNode root, int currSum)
    {
        if(root == null) return;
        postorder(root.left, currSum*10 + root.val);
        postorder(root.right, currSum*10 + root.val);
        if(root.left == null && root.right == null)
        {
            sum+= currSum* 10 + root.val;
        }
       
    }
    
    public int sumNumbers(TreeNode root) 
    {
        this.sum=0;
        postorder(root, 0);
        return sum;
    }
}

//iterative inorder
class Solution {
    public int sumNumbers(TreeNode root) {
        //Iterative solution
        
        int sum=0;
        int currSum=0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));
        
        while(!stack.isEmpty())
        {
                
                while(root!= null)
                {
                     currSum = currSum * 10 + root.val;
                     stack.push(new Pair(root, currSum));
                     root = root.left;
                    
                }
                
                
                Pair<TreeNode, Integer> p = stack.pop();
                root = p.getKey();
                currSum = p.getValue();
                
                if(root.left == null && root.right == null )
                {
                    sum += currSum;
                }
                
                
               root = root.right;
                
            
        }
        return sum;
    }

    //iterative preorder
    class Solution {
    public int sumNumbers(TreeNode root) {
        //Iterative solution
        
        int sum=0;
        int currSum=0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));
        
        while(root!= null || !stack.isEmpty())
        {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            currSum = p.getValue();
            if(root != null)
            {
                currSum = currSum * 10 + root.val;
                 if(root.left == null && root.right == null )
                {
                    sum += currSum;
                }
                
                stack.push(new Pair(root.right, currSum));
                stack.push(new Pair(root.left, currSum));
                
            }
        }
        return sum;
    }
    
    
}