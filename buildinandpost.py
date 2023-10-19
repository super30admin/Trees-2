# Time Complexity : O(n^2)
# Space Complexity :O(height)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # O(n^2)

        if not inorder:
            return None
        root=TreeNode(postorder.pop())
        mid=inorder.index(root.val)
        root.right=self.buildTree(inorder[mid+1:], postorder)
        root.left=self.buildTree(inorder[:mid], postorder)
        return root


