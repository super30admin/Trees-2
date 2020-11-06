// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var buildTree = function(inorder, postorder) {
    const n = inorder.length
    const map = new Map();
    inorder.forEach((num, index) => map.set(num,index));

    let idx_post = n - 1;
    return helper(0, n-1);

    function helper(left, right) {
        if(idx_post < 0 || left > right) return null

        const curr_val = postorder[idx_post--];
        const curr_node = new TreeNode(curr_val);

        const curr_idx = map.get(curr_val);

        curr_node.right = helper(curr_idx + 1, right);
        curr_node.left = helper(left, curr_idx - 1);

        return curr_node
    }
};