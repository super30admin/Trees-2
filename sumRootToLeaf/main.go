/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
/*
    approach: inorder recursive using global sum
    - when we reach a leaf node, we want to have an integer value that is the value from root to leaf
    - so, we need to maintain a current num, starting from 0
    - at each node, append the node val to current number ( curr = curr * 10 + r.Val )
    - recurse left
    - process root
        - if this is a leaf node, add the curr number to global sum
        - return early, no need to recurse right
    - recurse right
    
    time: o(n)
    space: o(n)
*/
// func sumNumbers(root *TreeNode) int {
//     sum := 0
//     var dfs func(r *TreeNode, curr int)
//     dfs = func(r *TreeNode, curr int) {
//         // base
//         if r == nil {return}
        
//         // logic
//         curr = curr * 10 + r.Val
//         dfs(r.Left, curr)
//         if r.Left == nil && r.Right == nil {
//             sum += curr
//             return
//         }
//         dfs(r.Right, curr)
//     }
//     dfs(root, 0)
//     return sum
// }

// same as above but using inorder iterative
// time: o(n)
// space: o(n)
// func sumNumbers(root *TreeNode) int {
//     sum := 0
//     type stNode struct{
//         n int
//         node *TreeNode
//     }
//     curr := 0
//     st := []stNode{}
//     for root != nil || len(st) != 0 {
//         for root != nil {
//             curr = curr*10+root.Val
//             st = append(st, stNode{n:curr, node: root})
//             root = root.Left
//         }
//         // we have hit nil!
//         // we are going back to a prev node!
//         // reset state to this prev node state ( state is track within the stack node )
//         // recursion used to restore prev node state back for us, but we need to do it ourselves in iterative
//         // DO THE ONE TO ONE MAPPING OF OUR RECURSION PARAMETERS! SINCE WE ARE GOING BACK 
//         topNode := st[len(st)-1]; st = st[:len(st)-1]
//         root = topNode.node
//         curr = topNode.n
//         if root.Left == nil && root.Right == nil {
//             sum += topNode.n
//         }
//         root = root.Right
//     }
//     return sum
// }


/*
    approach: no global sum var ( inorder )
    - which means we will be using return based recursion (bottom up)
    - at each leaf node we need to have a root-thisLeft node path in an int
    - so we will continue maintaining a path in an int format
    - we can either hit a leaf node or a non leaf node or a nil node
    - when we hit a leaf node,
        - we will return our path number we have created so far
    - when we hit a nil node,
        - we will return a 0
    - when we hit a non-leaf node or our recursion goes back to a non leaf node
        - we will return left + right
        - left or right would be a valid int or 0

    time: o(n)
    space: o(n)
*/
func sumNumbers(root *TreeNode) int {
    var dfs func(r *TreeNode, path int) int
    dfs = func(r *TreeNode, path int) int {
        // base
        if r == nil {return 0}
        
        // logic
        path = path * 10 + r.Val
        left := dfs(r.Left, path)
        
        // if leaf node, return current maintained path
        if r.Left == nil && r.Right == nil {
            return path
        }
        
        right := dfs(r.Right, path)
        return left + right
    }
    return dfs(root, 0)
}
