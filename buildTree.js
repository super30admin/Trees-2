// Time Complexity : O(n^2) where n in number of element in a tree
// Space Complexity : O(n) where n in number of element in a tree
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

//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3]

//Solution 1 : Brute Force Solution
var buildTree = function(inorder, postorder) {
    //base case
    if(inorder.length === 0 || postorder.length === 0) return null;
    
    let root = new TreeNode(postorder[inorder.length - 1]);
    let rIndex;
    for(let i = 0; i < inorder.length; i++) {
        if(inorder[i] === root.val) {
            rIndex = i;
            break;
        }
    }
    let il = inorder.slice(0, rIndex);
    let ir = inorder.slice(rIndex + 1, inorder.length);
    let pl = postorder.slice(0,il.length);
    let pr = postorder.slice(il.length,inorder.length+1);
    console.log(il,ir,pl,pr);
    root.right = buildTree(ir, pr);
    root.left = buildTree(il, pl);
    return root;
};

//Time Complexity : O(n)
//Space Complexity : O(n) 
//Solution 2 : HashMap solution
// var buildTree = function(inorder, postorder) {
//     let map = inorder.reduce((prev,curr,index) => {
//         prev.set(curr,index);
//         return prev;
//     },new Map());
//     let postIndex = postorder.length - 1;
//     let helper = function(left,right) {
//         //base case
//         if(left > right) return null;
//         //action
//         let root = new TreeNode(postorder[postIndex]);
//         postIndex--;
//         let rIndex = map.get(root.val);
//         root.right = helper(rIndex+1,right);
//         root.left = helper(left,rIndex-1);
//         return root;
//     }
//     return helper(0,inorder.length-1);  
// };