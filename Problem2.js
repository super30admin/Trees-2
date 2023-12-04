//Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
// Acceted in leetcode
// time and space complexity is O(n)

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {

    let result =0;

const helper=(root, currentNum)=>{

    if(root === null) return;

    currentNum = currentNum*10 + root.val;

    if(root.left == null && root.right == null){
        result += currentNum;
    }

    helper(root.left, currentNum);
    helper(root.right, currentNum);

}
helper(root,0);
return result
}