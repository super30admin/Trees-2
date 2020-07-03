/*


-preorder traversal follows root-left-right 
-the first element in the preorder traversal is root
-this root splits the inorder into left and right subtree. 
- Now I will have to pop up the root from preorder list since it's already used as a treenode and 
- then repeat the step above for the left and right subtrees.

Time complexity - O(n)
Space Complexity - Height of the tree
*/
class Solution {
    int preIndex=0;
    Map<Integer , Integer > map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length==0 || inorder.length ==0 )
            return null;
        
        map = new HashMap<>();
        //add element from inorder array and its corresponding index into map.
        for(int i=0; i< inorder.length ; i++)
            map.put(inorder[i],i);
        
        return buildTreeUtil(preorder, inorder, 0, inorder.length-1);
    }
    private TreeNode buildTreeUtil(int[] preorder, int[] inorder, int start, int end){
        //base case for recursion
        if(start>end)
            return  null;
        //take 1st element from preorder traversal as a root
        TreeNode root = new TreeNode(preorder[preIndex++]);
        
        int index = getInOrderIndex(root.val);
        
        // left subtree of the root will be start to root_index -1
        root.left =  buildTreeUtil(preorder, inorder, start, index-1);
        root.right =  buildTreeUtil(preorder, inorder, index+1, end);
        return root;
    }
    private int getInOrderIndex(int number){
        return map.get(number);
    }
}
