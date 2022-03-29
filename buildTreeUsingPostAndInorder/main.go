func buildTree(inorder []int, postorder []int) *TreeNode {
    if len(inorder) != len(postorder) || len(inorder) == 0 && len(postorder) == 0{
        return nil
    }
    
    root := &TreeNode{Val: postorder[len(postorder)-1]}
    mid := -1
    
    for i := 0; i < len(inorder); i++ {
        if inorder[i] == root.Val {
            mid = i
            break
        }
    }
    
    root.Left = buildTree(inorder[0:mid], postorder[0:mid])
    root.Right = buildTree(inorder[mid+1:], postorder[mid:len(postorder)-1])
    return root
}
