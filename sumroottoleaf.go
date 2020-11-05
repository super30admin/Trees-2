// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set sum =0, curr =0
in recursive
if root == nil return sum
curr = curr*10+root.val
if root is leaf then return s+c
else return sum of left and right child of root with current sum and curr
*/
package main

import "fmt"

func sumNumbers(root *TreeNode) int {
	sum := 0
	if root == nil {
		return sum
	}
	return h(root, 0, 0)
}

func h(root *TreeNode, s, c int) int {
	if root == nil {
		return s
	}
	c = c * 10 + root.Val

	if root.Left == nil && root.Right == nil {
		return s + c
	}
	return h(root.Left, s, c) + h(root.Right, s, c)
}

func MainSumRootLeaf() {
	root := &TreeNode{Val: 4}
	root.Left = &TreeNode{Val: 9}
	root.Right = &TreeNode{Val: 0}
	root.Left.Left = &TreeNode{Val: 5}
	root.Left.Right = &TreeNode{Val: 1}
	fmt.Println(sumNumbers(root)) //expected 1026
}
