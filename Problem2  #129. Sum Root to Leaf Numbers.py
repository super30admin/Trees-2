# Time Complexity : O(N)
# Space Complexity : O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    d = dict()
    x = 0
    p_list = list()

    def helper(self, start, end):
        # base
        if start > end:
            return None

        # logic
        root_value = self.p_list[self.x]
        self.x = self.x - 1

        root = TreeNode(root_value)

        root_index = self.d.get(root_value)

        root.right = self.helper(root_index + 1, end)
        root.left = self.helper(start, root_index - 1)

        # final return
        # print(root.val)
        return root

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # null

        if len(postorder) == 0:
            return None

        for i in range(0, len(inorder)):
            self.d.update({inorder[i]: i})

        self.p_list = postorder

        self.x = len(self.p_list) - 1
        start = 0
        end = len(inorder) - 1
        return self.helper(start, end)
