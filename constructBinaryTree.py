# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC: O(n) --> traverse through the whole postorder array
    SC: O(n + max depth) --> sum of hashmap and recursive stack space
    """
    hmap = {}
    postIndex = 0

    def buildNewTree(self, postorder, inStart, inEnd):

        # leaf node is reached
        if inStart > inEnd:
            return None

        # if postIndex is negative return back to the original function
        if self.postIndex < 0:
            return

        root = TreeNode(postorder[self.postIndex])
        index = self.hmap.get(root.val)

        # decrement postindex
        self.postIndex -= 1

        # root, right, left traversal for postorder
        root.right = self.buildNewTree(postorder, index + 1, inEnd)
        root.left = self.buildNewTree(postorder, inStart, index - 1)

        return root

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        # 1. Base case
        if len(postorder) == 0:
            return None

        # initializing the post index and hmap
        self.postIndex = len(postorder) - 1

        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i

        return self.buildNewTree(postorder, 0, len(inorder) - 1)