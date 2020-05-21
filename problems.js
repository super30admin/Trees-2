// ## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

var buildTree = function(preorder, inorder) {
    let hash = {};
    inorder.forEach((e, i)=>{hash[e] = i});
    
    let recur = function(start, end) {
        if (start > end) return null;
        let root = new TreeNode(preorder.shift());
        root.left = recur(start, hash[root.val] - 1);
        root.right = recur(hash[root.val] + 1, end);
        return root;
    }    
    return recur(0, inorder.length - 1);    
};




// ## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes

const sumNumbers = function(root) {
    let res = 0;
    helper(root, 0);
    return res;
    function helper(root, sum) {
        // base
        if(root === null) return;
        // logic
        if(root.left === null && root.right === null) {
            res += sum * 10 + root.val;
        }
        helper(root.left, sum * 10 + root.val);
        helper(root.right, sum * 10 + root.val);
    }
};