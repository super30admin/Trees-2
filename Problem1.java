/**Given inorder and postorder traversal of a tree, construct the binary tree.

Note: You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]

postorder = [9,15,7,20,3] Return the following binary tree:

3

/ \

9 20

/  \
15 7
**/

// Time Complexity : O(n2) as there will be two traversals(first it iterate  over the list and second it will look for root in the list)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : No, but it didn;t run 


// Your code here along with comments explaining your approach
//postorder and inorder traversal, Find root first and then prepare edge cases
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //Edge case
        if(postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0)
            return null;
    }
    TreeNode root = new TreeNode(postorder[postorder.length-1]);
    int index = -1;
    for(int i=0; i<postorder.length; i++){
        if(inorder[i] == root.val){
            index = i;
            break;
        }
    }
    int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
    int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
    int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length-1);
    int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
    root.left = buildTree(inLeft.postLeft);
    root.right = buildTree(inRight.postRight);
    return root;
}
