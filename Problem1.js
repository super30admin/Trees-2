//Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
//Accepted in LeetCode
//TC and SC is O(n)

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

    function recurse(pStart, pEnd, inStart, inEnd){
        // base case

        if(pStart > pEnd || inStart >inEnd) return null;

        let rootVal = postorder[pEnd];
        let inIndex = inorder.indexOf(rootVal);
        let nLeft = inIndex-inStart;

        let root = new TreeNode(rootVal);

        root.left = recurse(pStart, pStart+nLeft-1, inStart, inIndex-1);
        root.right= recurse(pStart+nLeft, pEnd-1, inIndex+1, inEnd);

        return root;
    }

    return recurse(0, postorder.length-1, 0, inorder.length-1);
    
};