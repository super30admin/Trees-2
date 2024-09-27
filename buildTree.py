Time complexity: O(n)
Space complexity: O(n) for  result
Executed in leetcode: Yes
Challenges: I was getting error in root.right section when i gave similar index for postorder
Comments: Given below

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

        
class Solution:
	def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
    
    # Sanity check
		if not inorder or not postorder:
			return None
    
    #Find the root node (last in postorder list)
		root = TreeNode(postorder[-1])
        
    # Find the index location of the root node in inorder
		idx = inorder.index(postorder[-1])
    
    # Numbers to left and right of index are recursively passed through the function
		root.left = self.buildTree(inorder[:idx], postorder[:idx])
		root.right = self.buildTree(inorder[idx+1:], postorder[idx:len(postorder)-1]) # As final element is index in postorder
		return root
        
