# Time Complexity: O(N)
# Space Complexity: O(N)
# Leetcode all Test Cases passed: Yes
# Any Difficulties: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        dic = {}
        for idx, ele in enumerate(inorder):
            dic[ele] = idx
        
        def helper(left, right):
            nonlocal postorder, inorder
            if left > right:
                return None
            rootElement = postorder.pop()
            rootIndex = dic[rootElement]
            root = TreeNode(rootElement)
            root.right = helper(rootIndex+1, right)
            root.left = helper(left, rootIndex-1)
            return root
        
        return helper(0, len(inorder)-1)
