#Time Complexity - O(n)
#Space Complexity - O(Height of the tree)
# Problem successfully executed on leetcode
# No problems faced while coading this

class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if inorder==None or postorder==None or len(inorder)==0:
            return None
        
        root=TreeNode(postorder[len(postorder)-1])
        mid = inorder.index(root.val)
        root.left=self.buildTree(inorder[:mid],postorder[:mid])
        root.right=self.buildTree(inorder[mid+1:],postorder[mid:len(postorder)-1])
        
        
        return root