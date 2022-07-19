// Time Complexity : O(N)
// Space Complexity : O(N) 
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
var inordermap map[int]int
var postorderindex int

func buildTree(inorder []int, postorder []int) *TreeNode {
    if len(postorder) == 0{
        return nil
    }
    
    inordermap = make(map[int]int)
    postorderindex = len(postorder)-1
    for key,val := range inorder{
        inordermap[val] = key
    }
    
    left:=0
    right:=len(postorder)-1
    
    return helper(postorder,left,right)
}


func helper(postorder []int,left,right int) *TreeNode {
    if left > right {
        return nil
    }
    
    rootvalue := postorder[postorderindex]
    postorderindex -= 1
    
    root := &TreeNode{}
    root.Val = rootvalue
    
    index := inordermap[rootvalue]
    
    root.Right = helper(postorder,index+1,right)
    root.Left = helper(postorder,left,index-1)
    
    
    
    return root
}
