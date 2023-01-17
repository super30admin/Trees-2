package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// Time : N^2
//Space : N^2
// TODO : revisit and do the optimized solution where map would be used and pointers would be passed for slicing th slice
func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	rootVal := preorder[0]
	root := TreeNode{
		Val: rootVal,
	}
	rootIdx := -1
	// find root in inorder
	for i := 0; i < len(inorder); i++ {
		if inorder[i] == root.Val {
			rootIdx = i
			break
		}
	}
	inLeft := inorder[0:rootIdx]
	inRight := inorder[rootIdx+1 : len(inorder)]
	preLeft := preorder[1 : len(inLeft)+1]
	preRight := preorder[len(inLeft)+1 : len(preorder)]

	root.Left = buildTree(preLeft, inLeft)
	root.Right = buildTree(preRight, inRight)
	return &root
}
