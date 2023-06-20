# // Time Complexity :O(n)
# // Space Complexity :O(height)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder:
            return None
        root=TreeNode(postorder[-1])
        index=inorder.index(postorder[-1])
        root.left=self.buildTree(inorder[:index],postorder[:index])
        root.right=self.buildTree(inorder[index+1:],postorder[index:-1])
        return root
  