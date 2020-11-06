// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



var sumNumbers = function(root) {
    let total = 0, sum = 0;

    helper(root, sum)
    return total;

    function helper(node, sum){
        if(!node) return

        sum = sum*10 + node.val;
        if(node.left && node.right){
            total += sum;
        }

        helper(node.left, sum)
        helper(node.right, sum)
    }
}