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
// Time Complexity: O(n)
// Space Complexity: O(n) for building hashmap
//106. Construct Binary Tree from Inorder and Postorder Traversal - Medium
class Solution {
    HashMap<Integer,Integer> inIndex=new HashMap<>();
    int pIndex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
    
        for(int i=0;i<n;i++)
        {
            inIndex.put(inorder[i],i);
        }
        // In postorder ( left,rt,root)-> the root will be the last element. So the root will be at index n-1;
        //Now the node at n-2 index, will be in the rt subtree of the inorder with node(indexed at n-1 in postorder)
        //TreeNode root=new TreeNode(postorder[n-1]);
        pIndex=n;
       
        return  build(postorder,0,n-1);
        
    }
    
    public TreeNode build( int[] postorder,int start, int end)
    {
        --pIndex;
        
        
       TreeNode node=new TreeNode(postorder[pIndex]);
       
        int rootIndex=inIndex.get(node.val);
        int lstart=start;
        int lend=rootIndex-1;
        int rstart=rootIndex+1;
        int rend=end;
        
        // build right substree
        if(rstart<=rend)
       node.right= build(postorder,rstart,rend);
      
        // build left substree
     if(lstart<=lend)
        node.left=build(postorder,lstart,lend);
        
        return node;
         
        
    }
    
    
}