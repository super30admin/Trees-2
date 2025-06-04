//Problem 106 : Construct binary tree from inorder and postorder Traversal
//Solved successfully on leetcode and faced no issues
//TC : O(n) SC:O(n)

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postindex ={ postorder.length-1};
        HashMap<Integer,Integer>inordermap  = new HashMap<>();
        for (int i = 0 ; i <inorder.length ; i++){
            inordermap.put(inorder[i] , i);
        }

        return buildtree(inorder ,postorder , postindex , 0 , inorder.length-1 , inordermap);
        
    }
    private TreeNode buildtree(int[] inorder , int[] postorder , int[] postindex , int instart , int inend,HashMap<Integer,Integer>inordermap){
        if(instart > inend){
            return null;
        }
        int currentval = postorder[postindex[0]];
        TreeNode cnode = new TreeNode(currentval);
        postindex[0] -= 1;
        int i = inordermap.get(currentval);

        cnode.right = buildtree( inorder , postorder ,postindex , i+1 , inend,inordermap);

         cnode.left = buildtree( inorder , postorder ,postindex , instart , i-1 , inordermap );
     return cnode;
    }
}