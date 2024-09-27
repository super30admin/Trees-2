#Time Complexity:O(n)
#Space Complexity:O(n)
#leetcode submission:successful
#  last element of postorder is the root of the tree and the elements left of the that element
# in inorder is left part of tree and the right of that element in inorder is the right part
# of tree
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder or not postorder:
            return None
        root=TreeNode(postorder.pop())
        index=inorder.index(root.val)
        
        root.right=self.buildTree(inorder[index+1:],postorder)
        root.left=self.buildTree(inorder[0:index],postorder)
        return root
        