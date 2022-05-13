#Time Complexity : O(n2) 
# Space Complexity : O(n2) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        if postorder is None or inorder is None or len(postorder) == 0:
            return None

        rootVal = postorder[len(postorder)-1]
        root = TreeNode(rootVal)
        rootIdx = -1

        for i in range(0,len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
                break

        inorderLeft = inorder[0:rootIdx]
        inorderRight = inorder[rootIdx+1:len(inorder)]
        postorderLeft = postorder[0:rootIdx]
        postorderRight = postorder[rootIdx:len(postorder)-1]

        root.left = Solution.buildTree(self,inorderLeft,postorderLeft)
        root.right = Solution.buildTree(self,inorderRight,postorderRight)

        return root
        