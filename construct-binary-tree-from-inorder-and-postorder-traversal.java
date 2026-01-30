 // TimeComplexity: O(n)
 // SpaceComplexity: O(n)
 // Explanation: I am building the binary tree recursively by taking the last element of the current postorder range as the root, because postorder visits nodes in left → right → root order. Using a HashMap of inorder values, I find the root’s position in the inorder array, which tells me the boundaries of the left and right subtrees. I first recursively construct the right subtree, then the left subtree, updating the postorder index as I go, until the entire tree is reconstructed.
class Solution {
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
    
    return helper(postorder, inorderMap, 0 , inorder.length-1); 
    }


    private TreeNode helper(int[] postorder, Map<Integer, Integer> inorderMap, int inleft, int inright) {
        if(inleft>inright) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
    
        
        int rootidx = inorderMap.get(root.val);
        root.right = helper(postorder, inorderMap,rootidx+1, inright);
        root.left = helper(postorder, inorderMap,inleft, rootidx-1);
        
        return root;   
    }
}

