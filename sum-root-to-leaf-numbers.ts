/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
// Time complexity - O(n), n = number of ndes
// Space complexity - O(h), h= height of the tree
function sumNumbers(root: TreeNode | null): number {
	return helper(root, 0);
}

function helper(root: TreeNode | null, curr: number): number {
	if (!root) return 0;

	// increase current
	curr = curr * 10 + root.val;

	// if both left and right node are empty, return current number
	if (!root.left && !root.right) return curr;

	// traverse to left
	const left = helper(root.left, curr);

	// traverse to right
	const right = helper(root.right, curr);

	// return total sum for both path
	return left + right;
}
