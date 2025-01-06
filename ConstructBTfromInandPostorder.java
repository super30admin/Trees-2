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

 /*
    Leetcode problem 106: Construct-binary-tree-from-inorder-and-postorder-traversal
    T.C: O(n) :: S.C: O(n) - Hashmap to store the inorder travesed indices

    Solved using Recursive approach: by optimizing few instructions in the logic. Used
    a HashMap to store the index at which the elements are located - inorder array and 
    pointers to partition the inorder array (startIndex and EndIndex). In the helper function 
    get the root element first from the postorder array's last index (maintain a global iterator
    for this array). Then process the right half the inorder array by calling the helper function 
    again where the start index is towards the right half of the root and end in the last index.
    After which you need to recursively process the left half of the inorder array in similar 
    fashion, where the start is at index 0 and end is towards the left of the root element. Base
    case is when start index is greater than end index.

    Use python Tutor for better visulization of the recursive calls and node creation at each call.
    It is important to see how the left and right children are created and assigned to the root in 
    a bottom to top recursive stack (calls in helper).
*/

class Solution {

    HashMap<Integer, Integer> indexMap;
    int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) return null;

        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        postorderIndex = postorder.length - 1;

        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder,int[] postorder, int startIndex, int endIndex) {
        //Base case
        if (startIndex > endIndex) return null;

        //Logic - Recursion
        int rootVal = postorder[postorderIndex];
        postorderIndex--;

        TreeNode root = new TreeNode(rootVal);
        
        //First go towards right as the root from the end of postorder is in right (L R Root)
        root.right = helper(inorder, postorder, indexMap.get(rootVal) + 1, endIndex);
        //Then go towards the left after processing the right sub-tree
        root.left = helper(inorder, postorder, startIndex, indexMap.get(rootVal) - 1);        

        return root;
    }
}