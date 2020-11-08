# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def sumNumbers(self, root):
		return self.helper(root, 0)

	def helper(self, root, s):
		if root == None:
			return 0
		if root.left == None and root.right == None:
			return s * 10 + root.val
		return helper(root.left, s * 10 + root.val) + helper(root.right, s * 10 + root.val)

	def IterativeSoln1(self, root):
		# Time Complexity : O(n) where n is the number of elements in the tree
		# Space Complexity : O(n) where n is the number of elements in the tree because we are storing every element in the queue
		# But we are only storing breadth-wise so I'm not sure if the space complexity would be O(n)
		# temp = map_list[0]
		# del map_list[0]
		res = 0
		if root == None:
			return 0
		map_list = []
		map_list.append((root,root.val))
		while len(map_list) != 0:
			temp = map_list.pop()
			if temp[0].left == None and temp[0].right == None:
				res += temp[1]
			else:
				if temp[0].left != None:
					map_list.append((temp[0].left, temp[1] * 10 + temp[0].left.val))
				if temp[0].right != None:
					map_list.append((temp[0].right, temp[1] * 10 + temp[0].right.val))
		return res

	def IterativeSoln2(self, root):
		# Time Complexity : O(n) where n is the number of elements in the tree
		# Space Complexity : O(n) where n is the number of elements in the tree because we are storing every element in the queue
		# But we are only storing breadth-wise so I'm not sure if the space complexity would be O(n)
		# temp = map_list[0]
        # del map_list[0]
		res = 0
		if root == None:
			return 0
		map_list = []
		map_list.append((root,root.val))
		while len(map_list) != 0:
			temp = map_list[0]
			del map_list[0]
			if temp[0].left == None and temp[0].right == None:
				res += temp[1]
			else:
				if temp[0].left != None:
					map_list.append((temp[0].left, temp[1] * 10 + temp[0].left.val))
				if temp[0].right != None:
					map_list.append((temp[0].right, temp[1] * 10 + temp[0].right.val))
		return res