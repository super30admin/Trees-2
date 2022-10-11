
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        self.index = len(inorder)-1
        def recursive(postorder, inorder, start, end):
        	if start > end:
        		return None

        	node = TreeNode(postorder[self.index])
        	self.index -= 1
        	if start == end:
        		return node

        	search_index = 0
        	for i in range(start, end+1):
        		if inorder[i] == node.val:
        			search_index = i
        			break
        	node.right = recursive(postorder, inorder, search_index+1, end)
        	node.left = recursive(postorder, inorder, start, search_index-1)
        	return node

        return recursive(postorder, inorder, 0, len(inorder)-1)