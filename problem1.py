# The approach used is recursive 
#Time complexity n^2 where N is the number of nodes in the tree. 
#space complexity n due to the recursive function calls
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not postorder and not inorder:
            return None
        root= TreeNode(val= postorder[-1])
        mid= inorder.index(postorder[-1])

        root.left= self.buildTree(inorder[:mid], postorder[:mid])
        root.right= self.buildTree(inorder[mid+1:], postorder[mid:-1])

        return root