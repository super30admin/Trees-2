# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    index = 0
    hashMap = dict()

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if inorder is None or len(inorder) == 0 or postorder is None or len(postorder) == 0:
            return None

        self.index = len(postorder) - 1
        self.hashMap = dict()

        for index, value in enumerate(inorder):
            self.hashMap[value] = index
            # start  end
        return self.helper(inorder, postorder, 0, len(inorder) - 1)

    def helper(self, inorder, postorder, start, end):
        # base
        if start > end or self.index < 0:
            return None

        rootVal = postorder[self.index]
        root = TreeNode(rootVal)
        self.index -= 1
        #         if(start == end):
        #             return root

        rootIdx = self.hashMap.get(rootVal)

        root.right = self.helper(inorder, postorder, rootIdx + 1, end)
        root.left = self.helper(inorder, postorder, start, rootIdx - 1)

        return root

# recursion, HashMap
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
