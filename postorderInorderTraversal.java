//Time complexity: O(N)
//Space Complexity O(1)
class Solution {
    
    private int index;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //If the lengths of the postorder and inorder does not match or if it is empty return null
        if(inorder.length != postorder.length || inorder.length==0 || postorder.length == 0) return null;
        //set an index to the end of postorder array
        index = postorder.length-1;
        //Find root using build function that takes start index as 0 and end as the last position of postorder array
        TreeNode root = build(inorder,postorder, 0, index);
        return root;
        
    }
    //build function to calculate the root node
    private TreeNode build(int[] inorder, int[] postorder, int start, int end)
    {
        //check if start is greater than the end index if true return null
        if(start>end) return null;
        //store the value at the current index in postorder(root) to node and decrement index
        TreeNode node = new TreeNode(postorder[index--]);
        //if the start and end both are same there is just one value in tree and it is the root node
        if(start == end) return node;
        //find the root value in inorder array using findIdx function which takes the value to be searched and end as input
        int i = findIdx(inorder,node.val,end);
        //find the root for the right part(all values in inorder that are to the right of i index) of the tree using build
        node.right = build(inorder, postorder, i+1, end);
        //find the root for the left part(all values in inorder that are to the left of i index) of the tree using build
        node.left = build(inorder, postorder, start, i-1);
        return node;
    }
    
    //function to find the index of the root value present in inorder array
    private int findIdx(int[] inorder, int val, int end) {
        //iterate over inorder from end index to 0
        for (int i=end; i>=0; i--) 
        {
            //If the value is found return its index
            if (inorder[i]==val) return i;
        }
        //else return 0
        return 0;
    }
}