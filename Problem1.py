# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def buildTree1(self, inorder, postorder):
		map_inorder = dict()
		for index, val in enumerate(inorder):
			map_inorder[val] = index
		return self.helper(inorder, 0, len(inorder) - 1, postorder, 0, len(postorder) - 1, map_inorder)

	def helper(self, inorder, instart, inend, postorder, poststart, postend, map_inorder):
		if instart > inend or poststart > postend:
			return None
		rootVal = postorder[postend]
		root = TreeNode(rootVal)
		rootidx = map_inorder[rootVal]
		formula = postend - (inend - rootidx)
		root.left = self.helper(inorder, instart, rootidx - 1, postorder, poststart, formula - 1, map_inorder)
		root.right = self.helper(inorder, rootidx + 1, inend, postorder, formula, postend - 1, map_inorder)
		return root

	def buildTree1(self, inorder, postorder):
		# O(n^2) solution because we are doing a linear search on inorder array to find the index of the root
		if len(postorder) == 0:
			return None
		rootVal = postorder[-1]
		rootidx = -1
		for index, val in enumerate(inorder):
			if val == rootVal:
				rootidx = index
		root = TreeNode(rootVal)
		num_rightelements = len(inorder) - rootidx - 1
		inleft = inorder[:rootidx]
		postleft = postorder[:rootidx]
		inright = inorder[rootidx + 1:]
		postright = postorder[rootidx:len(postorder) - 1]
		root.left = self.buildTree1(inleft, postleft)
		root.right = self.buildTree1(inright, postright)
		return root