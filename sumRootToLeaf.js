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
    if(root == null) return 0;
    let result = 0;
    let currSum = 0;
    let stack = [];
    while(root != null || stack.length ){
        while(root!=null){
            currSum = currSum*10 + root.val;
            stack.push([root,currSum]);
            root = root.left;
        }
        let tuple = stack.pop();
         root = tuple[0];
        currSum = tuple[1];
        if(root.left == null && root.right == null) {
            result = result + currSum;
        }
        root = root.right;
        
    }
    return result;
};

//time complexity : O(n)
//space complexity : O(h)-height of the tree