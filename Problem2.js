// ## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE

var sumNumbers = function(root) {
    //**Time Complexity : O(N) */
    //**Space Complexity : O(h) */
    let res = 0
    function helper(root,currentSum){
        //baseCase
        if(!root){
            return 
        }
        currentSum = currentSum * 10 + root.val
        if(root.left ==null && root.right==null){
            //That means this leaf node
            res+=currentSum
        }
        helper(root.left,currentSum)
        helper(root.right,currentSum)
    }
    helper(root,0)
    return res
};