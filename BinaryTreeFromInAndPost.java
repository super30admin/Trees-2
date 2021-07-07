// Time Complexity : O(n), n is length of array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    //postorder index, to print the current root, initially last element 
    //postorders last element is always the root, and following elements are the root for RST and LST ...
    int pIndex; 
     //globally initinialize map to use in both methods
    HashMap<Integer, Integer> map;   
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         //if length == 0, return null
        if(postorder.length == 0 || inorder.length == 0) return null; 
        
        //create hashmap and add inorder elements to search inorder element poistion in O(1). 
        //To know where to split the array for LST and RST
        map = new HashMap<>(); 
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        
        //call helper method
        //the pointers point to 0 and inorder.length-1 in the beginning
        return helper(inorder, postorder, 0, inorder.length-1);      
        
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        
        //To set value of pIndex at start, we know start will be 0 and end will be last element of inorder
        //in case of preorder we do not do this as in preorder root is at 0 position and java by default sets value to 0
        //decrement later
        if(start == 0 && end == inorder.length-1){
            pIndex = postorder.length-1;
        }
        
        //Inorder Index
        int iIndex; 
        
        //if start > end, then all elements have been added for that call
        //if pIndex < 0, we have added all elements to the tree
        if(start > end  || pIndex < 0) return null;
    
        //search position of current root in Inorder
        iIndex = map.get(postorder[pIndex]);
        
        //add that value as the root
        TreeNode root = new TreeNode(postorder[pIndex]); 
        
         //decrement pIndex, to get the next root, based on RST or LST
        pIndex--;
       
        
        //call left and right helper function based on iIndex position.
        
        //right of iIndex position forms the RST (iIndex to end)
        root.right = helper(inorder, postorder, iIndex+1, end);
        
        //left of iIndex position forms the LST (start to iIndex-1)
        root.left = helper(inorder, postorder, start, iIndex-1);
     
        
        //return the root
        return root;      
    }
}



/*
                  pI
Post - [9,15,7,20,3]

find 3 is I[]
Left of 3 is LST and right of 3 is RST in Inorder input
start is at 0
end is at 7
  
       iI
I - [9,3,15,20,7]



call RST:

               pI
Post - [9,15,7,20,3]

Find 20 in I[]
Left of 20 is LST, right of 20 is RST
start is at 15
end is at 7             
            iI
I - [9,3,15,20,7]


In post order : Return RST first, as Post order is : LEFT,RIGHT,ROOT
In pre order : Return LST first as Pre Order is : ROOT,LEFT,RIGHT

*/

