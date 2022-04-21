#Time Complexity :o(n)
# Space Complexity :o(n)
# Did this code successfully run on Leetcode : yes
 

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder: return None
        root = TreeNode(postorder.pop())
        mid = inorder.index(root.val)
        root.right = self.buildTree(inorder[mid+1:],postorder)
        root.left = self.buildTree(inorder[:mid],postorder)
        return root


        
        
