# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder:
            return None
        
        root = TreeNode(postorder[-1])
        midInorder = inorder.index(postorder[-1])

        midPostorder = midInorder 

        root.left = self.buildTree(inorder[:midInorder], postorder[:midPostorder])
        root.right = self.buildTree(inorder[midInorder+1:], postorder[midPostorder:-1])

        return root