//Construct Binary Tree from Inorder and Postorder Traversal (LC 106)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I struggled at first but basically I am using recursion and adding a new TreeNode as I preorder array


// Your code here along with comments explaining your approach

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
    let indexMap = {};
    for(let i=0;i<inorder.length;i++){
        indexMap[inorder[i]] = i;
    }
    function helper(inLeft, inRight){
        if(inLeft > inRight){
            return null;
        }
        
        let val = postorder.pop();
        let root = new TreeNode(val);
        
        let index = indexMap[val];
        
        root.right = helper(index + 1, inRight);
        root.left = helper(inLeft, index - 1);
        return root;
    }
    
    return helper(0, inorder.length - 1);  
};