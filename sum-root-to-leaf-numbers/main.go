package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
/*

Trying a top down approach :
- the thought process is that number will be calculated at node and sent down to child node
- when you reach a node that is nil, you return 0
- for leaf node you return num passed to it
- for every other node you return the sum of left and right call

TODO - try an iterative approach
*/

// Time : O(n) - n is height of the tree
// Space : O(1)
func sumNumbers(root *TreeNode) int {
	if root == nil {
		return 0
	}
	var helper func(root *TreeNode, currentNum int) int
	helper = func(root *TreeNode, currentNum int) int {
		//base
		if root == nil {
			return 0
		}

		//logic
		num := currentNum*10 + root.Val
		leftNum := helper(root.Left, num)
		rightNum := helper(root.Right, num)

		if root.Left == nil && root.Right == nil {
			return num
		}
		return leftNum + rightNum
	}
	return helper(root, 0)
}
