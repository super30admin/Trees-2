""""// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.d = {}

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.Idx = len(postorder) - 1
        if len(postorder) == 0:
            return None
        for i in range(len(inorder)):
            self.d[inorder[i]] = i
        return self.helper(postorder, 0, len(postorder) - 1)

    def helper(self, postorder, start, end):
        if start > end:
            return None
        rootVal = postorder[self.Idx]
        self.Idx -= 1
        root = TreeNode(rootVal)
        rootIdx = self.d[rootVal]

        root.right = self.helper(postorder, rootIdx + 1, end)
        root.left = self.helper(postorder, start, rootIdx - 1)

        return root

# class Solution:
#     def __init__(self):
#         self.d = {}
#     def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
#         for i in range(len(inorder)):
#             self.d[inorder[i]] = i
#         return self.helper(postorder, 0, len(postorder)-1, inorder, 0, len(inorder)-1)


#     def helper(self, postorder, posStart, posEnd, inorder, inStart, inEnd):
#         if posStart>posEnd or inStart > inEnd:
#             return None
#         rootVal = postorder[posEnd]
#         root = TreeNode(rootVal)
#         rootIdx = self.d[rootVal]
#         length = rootIdx-inStart
#         root.left = self.helper(postorder, posStart, posStart + length - 1, inorder, inStart, rootIdx-1)
#         root.right = self.helper(postorder, posStart + length, posEnd-1, inorder, rootIdx+1, inEnd)
#         return root


# class Solution:
#     def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
#         if len(postorder)==0:
#             return None
#         rootVal=postorder[-1]
#         root=TreeNode(rootVal)
#         rootIdx=0
#         for i in range(len(inorder)):
#             if inorder[i]==rootVal:
#                 rootIdx=i
#                 break
#         inLeft=inorder[:rootIdx]
#         inRight=inorder[rootIdx+1:]
#         posLeft=postorder[:len(inLeft)]
#         posRight=postorder[len(inLeft): len(postorder)-1]

#         root.left=self.buildTree(inLeft,posLeft)
#         root.right=self.buildTree(inRight, posRight)
#         return root

