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
    if(postorder.length == 0 || inorder.length == 0) return null;
    let index;
    let root = new TreeNode(postorder[postorder.length-1]);

    //root index in inorder
    for(i =0; i<inorder.length;i++){
        if(inorder[i] == root.val){
            index = i;
        }
        
    }
   let inleft = inorder.slice(0,index);
   let inright = inorder.slice(index+1,inorder.length);
   let postleft = postorder.slice(0,index);
   let  postright = postorder.slice(index,postorder.length-1);
    root.left = buildTree(inleft,postleft);
    root.right = buildTree(inright,postright);
    return root;
    
    
};

//timecomplexity : O(n)
//space complexity : O(1)