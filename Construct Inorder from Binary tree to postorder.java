// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// The sequence of postorder is left-right-root, and that of inorder is left-root-right. This means that the last element in the postorder is the root of the tree. 
//We can look for the last element in the inorder array and take all the elements before that rootNode to bbe on the left side of the tree and all the elements after the noot node, to be on the right side of the tree. 
//To track this we will set a range from start to index of rootNode and the right side as index of rootNode+1 to the end. We will use a hashmap to store all the values of the inorder array, so we can search its index efficiently and star searching for the root from the end of the postorder array.

class Solution {
    int idx;
   HashMap<Integer,Integer> map;
   public TreeNode buildTree(int[] inorder, int[] postorder) {
       this.map=new HashMap<>();
       //Storing the values of Inorder in HashMap
       this.idx=postorder.length-1;
       for(int i=0;i<inorder.length;i++)
       {
           map.put(inorder[i],i);
       }
       return helper(postorder,0,inorder.length-1);

   }

   private TreeNode helper(int[] postorder, int start, int end)
 {  
     //base 
   if(start>end || idx==-1) return null;
  
   //logic
   int rootval=postorder[idx];
   idx--;

   //search for the rootval in inorder
   int rootIdx=map.get(rootval);

   //Construct the tree
   TreeNode root=new TreeNode(rootval);

   root.right=helper(postorder,rootIdx+1,end);
   root.left=helper(postorder,start,rootIdx-1);
   

   return root;
}
   
}
