/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

/*
    We have to form root-to-leaf concatnated number.
    The concatnated number will be different at each node. 
    We would need the concatnated number saved at each node,
    because a node could go left and right.
    When we go left and come back to the parent node, we have to have the current concat of this node 
    Therefore we will save at each node ( within the recursion stack ) - a local state for the paused call.
    Such that when that paused call is resumed, the local state is back to the way we paused it.
    
    approach 1: using inorder + global sum  *recursive*
    - have a global sum var
    - we can perform a inorder traversal
    - before going to any inorder paths, we will update the local runningNum ( concatnated number ) and save it so we can come back to it.
    - go all the way left
    - once st.pop() on a node happens ( after traversing left )
    - we will check whether this was a leaf node or not
    - if leaf, then sum += concatnated number
    - then inorder right
    - so this way we will visit every single node and only add the concatnated number when we hit a leaf node
    
    time: o(n)
    space: o(h)
    
    approach 2: using inorder + without any global var   *recursive*
    - our inorder helper will itself be responsible for returning the sum.
    - How?
    - we can perform a inorder traversal
    - before going to any inorder paths, we will update the local runningNum ( concatnated number ) and save it so we can come back to it.
    - go all the way left
    - once st.pop() on a node happens ( after traversing left )
    - we will check whether this was a leaf node or not
    - if leaf, we will return the runningNum ( concatnated number ) - this will return back the call to its parent
    - parent will call right
    - right will hit leaf and return the right concatnated number
    - then finally parent gets popped again because parent called right and never ran whatever else was supposed to after
    - then at the end parent will run "return left + right"
    - Then this sum will be left sum of parents-parent ( initially )
    - Then parents-parent calls right and repeats concatnate number -> inorder(left) -> if leaf { return leaf} -> inorder(right) -> return left + right
    - In this approach our base condition will return 0 instead of the running / concatnated number in hand
        - Why? because 1 of the test case fails if we dont -- wish I had figured it out prior to running into a failed case....
        - example: [1,0]
        - from left it returns 10 correctly
        - but the control comes back to main root node, which has 1 as the running number saved, it calls right ( null ) with 1 as the running number
        - when right's base cond gets hit and if we return the running number in hand
        - left + right on the root node gets added ( 10 + 1 ) = which returns 11 which is invalid
    time: o(n) -- we visit every single node
    space: o(h) -- implicit recursion stack under the hood
*/


// approach 1
// func sumNumbers(root *TreeNode) int {
//     c := &classHack{sum: 0}
//     c.inorder(root, 0)
//     return c.sum
// }

// type classHack struct{
//     sum int
// }
// func (c *classHack) inorder(root *TreeNode, runningNum int) {
//     if root == nil {
//         return
//     }
//     runningNum = runningNum * 10 + root.Val
//     c.inorder(root.Left, runningNum)
//     if root.Left == nil && root.Right == nil {
//         c.sum += runningNum
//     }
//     c.inorder(root.Right, runningNum)
// } 


// // approach 2
func sumNumbers(root *TreeNode) int {    
    return inorder(root, 0)
}


func inorder(root *TreeNode, runningNum int) int  {
    // base
    if root == nil {
        return 0
    }
    
    runningNum = runningNum * 10 + root.Val
    // logic
    left := inorder(root.Left, runningNum)
    if root.Left == nil && root.Right == nil {
        return runningNum
    }
    
    right := inorder(root.Right, runningNum)
    if root.Left == nil && root.Right == nil {
        return runningNum
    }
    return left + right
    
}
