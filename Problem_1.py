# Runs on Leetcode
# Run time - O(n^2)
# Memory - O(n)


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder:
            return None
        
        root = TreeNode(postorder[-1])
        index = inorder.index(postorder[-1])
        
        left_inorder = inorder[:index]
        right_inorder = inorder[index+1:]
        
        left_postorder = postorder[:index]
        right_postorder = postorder[index:-1]
        
        root.left = self.buildTree(left_inorder,left_postorder)
        root.right = self.buildTree(right_inorder,right_postorder)
        
        return root
