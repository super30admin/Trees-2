# Time Complexity : O(n)
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.dictu = {}

    def helper(self, postorder, p_start, p_end, inorder, i_start, i_end):
        if p_start > p_end or i_start > i_end:
            return
        root = postorder[p_end]
        rootNode = TreeNode(root)
        rootidx = self.dictu[root]
        count = rootidx - i_start
        rootNode.left = self.helper(postorder, p_start, p_start+count-1, inorder, i_start, rootidx-1)
        rootNode.right = self.helper(postorder, p_start+count, p_end-1, inorder, rootidx+1, i_end)
        return rootNode

    def buildTree(self, inorder: list[int], postorder: list[int]):
        for i in range(len(inorder)):
            self.dictu[inorder[i]] = i
        print(self.dictu)
        return self.helper(postorder, 0, len(postorder)-1, inorder, 0, len(inorder)-1)


check1 = Solution()
print(check1.buildTree([40, 20, 50, 10, 60, 30], [40, 50, 20, 60, 30, 10]))



# # Using Recursion
# # TC - O(n*n); SC - O(n*n)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.dictu = {}
#
#     def helper(self, inorder, postorder):
#         if len(postorder) == 0:
#             return
#         root = postorder[-1]
#         rootNode = TreeNode(root)
#         rootidx = self.dictu[root]
#         postLeft = postorder[:rootidx]
#         postRight = postorder[rootidx:len(postorder) - 1]
#         inLeft = inorder[:rootidx]
#         inRight = inorder[rootidx + 1:]
#         rootNode.left = self.buildTree(inLeft, postLeft)
#         rootNode.right = self.buildTree(inRight, postRight)
#         return rootNode
#
#     def buildTree(self, inorder: list[int], postorder: list[int]):
#         for i in range(len(inorder)):
#             self.dictu[inorder[i]] = i
#         return self.helper(inorder, postorder)
#
#
# check1 = Solution()
# print(check1.buildTree([40, 20, 50, 10, 60, 30], [40, 50, 20, 60, 30, 10]))

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def buildTree(self, inorder: list[int], postorder: list[int]):
#         if len(postorder) == 0:
#             return
#         root = postorder[-1]
#         rootNode = TreeNode(root)
#         rootidx = -1
#         for i in range(len(inorder)):
#             if inorder[i] == root:
#                 rootidx = i
#         postLeft = postorder[:rootidx]
#         postRight = postorder[rootidx:len(postorder)-1]
#         inLeft = inorder[:rootidx]
#         inRight = inorder[rootidx+1:]
#         rootNode.left = self.buildTree(inLeft, postLeft)
#         rootNode.right = self.buildTree(inRight, postRight)
#         return rootNode
#
#
# check1 = Solution()
# print(check1.buildTree([40, 20, 50, 10, 60, 30], [40, 50, 20, 60, 30, 10]))
