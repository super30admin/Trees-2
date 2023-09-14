
# ## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, inorder, postorder):
        # {inorder values: inorder index}
        self.hmap = {}
        self.idx = len(postorder) - 1
        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i
        self.helper(inorder, postorder, 0, len(inorder) - 1)

    def helper(self, inorder, postorder, start, end):
        # base
        if start > end:
            return None

        # logic
        rootVal = postorder[self.idx]
        root = TreeNode(rootVal)
        self.idx -= 1
        rootIdx = self.hmap.get(rootVal)

        root.right = self.helper(inorder, postorder, rootIdx + 1, end)
        root.left = self.helper(inorder, postorder, start, rootIdx - 1)

        return root


sol = Solution()
inorder = [9, 3, 15, 20, 7]
postorder = [9, 15, 7, 20, 3]

print(sol.buildTree(inorder, postorder))
