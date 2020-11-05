// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set postorder last element as root
for each element in inorder
find value equal to root value
root.left will be recursive(in till that index, po till that index)
root.right will be recursive(in from index+1 till end, po from index till end -1)
*/
package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	if len(inorder) == 0 || len(inorder) != len(postorder) {
		return nil
	}
	root := &TreeNode {
		Val: postorder[len(postorder)-1],
	}
	for i := 0; i < len(inorder); i++ {
		if inorder[i] == postorder[len(postorder)-1] {
			root.Left = buildTree(inorder[:i], postorder[:i])
			root.Right = buildTree(inorder[i+1:], postorder[i:len(postorder)-1])
		}
	}
	return root
}

func MainTreeFromInPo() {
	fmt.Println(buildTree([]int {9,3,15,20,7}, []int {9,15,7,20,3})) //expected 3
}
