// Time Complexity : O(N)
// Space Complexity : O(H) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sumNumbers(root *TreeNode) int {
    if root == nil{
        return 0
    }
    
    return helper(root,0)
}


func helper(root *TreeNode,nums int) int{
    if root == nil{
        return 0
    }
    
    sum := nums*10 + root.Val
    
    if root.Left == nil && root.Right == nil{
        return sum
    } 
    
    return helper(root.Left,nums*10+root.Val) + helper(root.Right,nums*10+root.Val)
    
}
