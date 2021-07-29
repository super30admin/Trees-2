// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    
     //Building hashmap for inorder (type integer ,integer  ) to store inorder value and its index to search root value
    //Get the root from the postorder and check where the index is this in the inorder hashmap .This helps to determine the left and right subtree 
    //With postorder we built the right subtree and then left subtree

    Map<Integer, Integer> inorderMap;
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length ==0)
            return null;

        int n = postorder.length;
        //PostIdx is the index of root .And the in postorder ,root is the last value or end of index
        postIdx = n-1;
        
        inorderMap = new HashMap<>();
        //storing inorder array to hashmap
        
        for(int i = 0; i < n; i++){
            inorderMap.put(inorder[i], i);  
        }
        //parameters: the last two are first index and last index
         return  helper(inorder, postorder, 0, n-1);            
 }
    
   private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
       //base
       if(start > end ) return null;
       
       
       //Getting root node from postorder and then decrementing after that
       
       int rootVal = postorder[postIdx];
       postIdx--;
       
       //Building the rootnode
       TreeNode root = new TreeNode(rootVal);
       
       //Find that root index of the root found in postorder from the inorder hasmap
       int rootIdx = inorderMap.get(rootVal);
       
       //Recursive the right and then left since its postorder
       
       root.right = helper(inorder, postorder, rootIdx+1, end); 
       root.left = helper(inorder, postorder, start , rootIdx-1);

       
       return root;
       
       
       
   }
    
}