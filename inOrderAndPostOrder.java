// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
1. The last element of postorder is current node element.
2. Find the node element in inorder list.
3. See the number of left elements and right elements of node element in inordered list
4. Divide inorder and preorder arrays into 2 sub array using the left and right indexes from previous step.
5. Repete the sum by sending both as recursive function.
*/


// Your code here along with comments explaining your approach
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //Base Condition
        if(postorder.length == 0) return null;
        
        //Get root value which is basicall current parent node
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = 0;
        //Find the node element from inorder array
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == root.val) {
                rootIdx = i;
            }
        }
        //divide into subarray based on right and left indexes found before
        int[] preLeft = Arrays.copyOfRange(postorder, 0, rootIdx);
        int[] prRight = Arrays.copyOfRange(postorder, rootIdx, postorder.length-1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        
        //Pass the subarrays as recursive functions
        root.left = buildTree(inLeft, preLeft);
        root.right = buildTree(inRight, prRight);
        return root;
    } 
}
