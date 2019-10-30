
# Time Complexity : O(n) where n is the number of elements in the tree
# Space Complexity : O(n) where n is the number of elements in the tree because we are storing every element in the queue
#iteravtive solution
class Solution(object):
	def sumNumbers(self, root):
		sum_tree = 0
		if root == None:
			return 0
		stk_list = [(root,0)]
		while len(stk_list) != 0:
			temp = stk_list.pop() #this gives a tuple
			if temp[0] != None:
				if temp[0].left == None and temp[0].right == None:
					sum_tree += temp[1] * 10 + temp[0].val
				else:

					stk_list.append((temp[0].left, temp[1] * 10 + temp[0].val))

					stk_list.append((temp[0].right, temp[1] * 10 + temp[0].val))
		return sum_tree

class Solution(object):
	def sumNumbers(self, root):
		sum_tree = 0
		if root == None:
			return 0
		stk_list = [(root,root.val)]
		#stk_list.append()
		while len(stk_list) != 0:
			temp = stk_list.pop()
			if temp[0].left == None and temp[0].right == None:
				sum_tree += temp[1]
			else:
				if temp[0].left != None:
					stk_list.append((temp[0].left, temp[1] * 10 + temp[0].left.val))
				if temp[0].right != None:
					stk_list.append((temp[0].right, temp[1] * 10 + temp[0].right.val))
		return sum_tree

