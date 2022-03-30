/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// // brute force , slicing post and inorder into smaller calls and recursively finding root and returning root from the lowest level to left and right
// func buildTree(inorder []int, postorder []int) *TreeNode {
//     if len(inorder) != len(postorder) || len(inorder) == 0 && len(postorder) == 0{
//         return nil
//     }
    
//     root := &TreeNode{Val: postorder[len(postorder)-1]}
//     mid := -1
    
//     for i := 0; i < len(inorder); i++ {
//         if inorder[i] == root.Val {
//             mid = i
//             break
//         }
//     }
    
//     root.Left = buildTree(inorder[0:mid], postorder[0:mid])
//     root.Right = buildTree(inorder[mid+1:], postorder[mid:len(postorder)-1])
//     return root
// }


type btree struct {
    inordermap map[int]int
    postOrderIdx int
}

func buildTree(inorder []int, postorder []int) *TreeNode {
    
    if len(inorder) != len(postorder) {
        return nil
    }
    
    b := &btree{
        postOrderIdx: len(postorder)-1,
        inordermap: map[int]int{},
    }
    
    for i := 0; i < len(inorder); i++ {
        b.inordermap[inorder[i]] = i
    }
    
    return b.helper(postorder, 0, len(inorder)-1)
}


func (b *btree) helper(post []int, start, end int) *TreeNode{
    if start > end {
        return nil
    }
    rootVal := post[b.postOrderIdx]
    b.postOrderIdx--
    rootIdx := b.inordermap[rootVal]
    root := &TreeNode{Val: rootVal}
    
    root.Right = b.helper(post, rootIdx+1, end)
    root.Left = b.helper(post, start, rootIdx-1)
    
    return root
}
