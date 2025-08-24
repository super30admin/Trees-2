// Time Complexity: O(N) where N is number of nodes
// Space Complexity: O(N)+O(H) where N is number of nodes and H is height of the tree for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * The core logic is to use postorder traversal to get the root at each step and then find the index of that root in inorder traversal . Further all nodes to the left of the root in inorder traversal will be part of left subtree and all nodes to the right will be part of right subtree. 
 * We can use a hashmap to store the value to index mapping for inorder traversal to optimize the search process to O(1) time.
 * We perform recursive calls to build the right and left subtrees by adjusting the start and end indices for inorder traversal.we do the right subtree first because in postorder traversal the right subtree comes before the left subtree when we are moving from the end to the start of the array.
 */



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
import java.util.HashMap;
import java.util.Map;
class ConstructTree {
    int postIndex = 0;
    Map<Integer, Integer> idxMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) idxMap.put(inorder[i], i);
        return build(postorder, 0, inorder.length - 1);
        
    }
    private TreeNode build(int[] postorder, int startIndex, int endIndex){
    if ( startIndex > endIndex ) { return null; } // if left greater than right then stop
    
    int rootVal = postorder[postIndex--];
    TreeNode root = new TreeNode( rootVal );

    int inorderIndex = idxMap.get( rootVal );
    root.right = build(postorder, inorderIndex + 1, endIndex );
    root.left = build(postorder, startIndex, inorderIndex - 1); 

    return root; // return root

}
}