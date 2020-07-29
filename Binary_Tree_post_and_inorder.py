#Time Complexity : O(N)
#Space Complexity: O(N)
#Yes it ran on leetcode


class Solution(object):
    def buildTree(self, inorder, postorder):
        global dic
        dic = {}
        global idx
        idx = len(postorder) - 1
        if len(postorder) == 0 and len(inorder) == 0:
            return None
        for i in range(len(inorder)):
            dic[inorder[i]] = i
        return self.helper(postorder, inorder, 0, len(inorder) - 1)

    def helper(self, postorder, inorder, start, end):
        global dic
        global idx
        # base
        if idx == len(postorder) or start > end:
            return None

        # logic

        rootIdx = dic[postorder[idx]]
        root = TreeNode(postorder[idx])
        idx -= 1
        root.right = self.helper(postorder, inorder, rootIdx + 1, end)
        root.left = self.helper(postorder, inorder, start, rootIdx - 1)

        return root