# Time Complexity :O(n^2)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        #recurse till there i no inorder
        if inorder:
            #pop last root from port order as this is the root
            root = TreeNode(postorder.pop())
            # get index of the root in inorder
            index = inorder.index(root.val)
            #right subtree it the right part of inorder
            root.right = self.buildTree(inorder[index+1:], postorder)
            # left subtree is the left part of inorder
            root.left = self.buildTree(inorder[:index], postorder)
            return root
        