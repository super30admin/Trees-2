//Leetcode: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Time Complexity : O(n) - n is number of nodes in tree
// Space Complexity : O(n) - since we create the extra arrays slicing the inorder and postorder arrays at each recurison
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//In this solution, we know the last element of the postorder is always the parent of the tree, we use this to identify 
// the postion of the element in the inorder. Then we recurse using the analyzed left and right portions of inorder and postorder.
// This solution takes O(n) space. This can be done using pointers for start and end of the arrays for both postorder and inorder

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function(inorder, postorder) {
    let pLen = postorder.length;
        //base
    if(pLen === 0){
          return null;
    }
 
    //recursive logic
    let rootVal = postorder[pLen-1];
    let rootIndex = inorder.indexOf(rootVal); // O(n) search
    let root = new TreeNode(rootVal);

    let inorderLeft = inorder.slice(0, rootIndex); // from 0 to not including the rootIndex element
    let inorderRight = inorder.slice(rootIndex+1); // from not including the rootIndex to end of the array
    let postorderLeft = postorder.slice(0, inorderLeft.length);
    let postorderRight = postorder.slice(inorderLeft.length, postorder.length-1);
    
    root.left = buildTree(inorderLeft, postorderLeft);
    root.right = buildTree(inorderRight, postorderRight);

    return root;
};