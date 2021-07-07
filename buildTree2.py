# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Writing the code

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        lookup = {}
        stack = []
        root = None
        for i in range(len(inorder)):
            lookup[inorder[i]] = i
        
        for i in range(len(postorder)-1, -1, -1):
            
            if root is None:
                root = TreeNode(postorder[i])
                stack.append(root)
            else:
                node = TreeNode(postorder[i])
                if lookup[postorder[i]] > lookup[stack[-1].val]:
                    stack[-1].right = node
                    stack.append(node)
                else:
                    while stack and lookup[postorder[i]] < lookup[stack[-1].val]:
                        temp = stack.pop()
                    temp.left = node
                    stack.append(node)
                    
        return root