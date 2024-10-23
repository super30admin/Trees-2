# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach 1: time: O(n^2) | space: O(n) for the recursion stack.
# class Solution:
#     def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
#         if not inorder or not postorder:
#             return None

#         rootVal = postorder[-1]
#         root = TreeNode(rootVal)

#         idx = inorder.index(rootVal)

#         # recursive calls

#         root.left = self.buildTree(inorder[:idx], postorder[:idx])
#         root.right = self.buildTree(inorder[idx+1:], postorder[idx:-1])

#         return root


# time O(n), space:O(n)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorderMap = {val:idx for idx, val in enumerate(inorder)}
        self.idx = -1

        def helper(start, end):
            if start>end:
                return None

            rootVal = postorder[self.idx]
            root = TreeNode(rootVal)
            rootIdx = inorderMap[rootVal]

            self.idx -= 1

            root.right = helper(rootIdx+1, end)
            root.left = helper(start, rootIdx-1)

            return root
        return helper(0, len(inorder)-1)



















