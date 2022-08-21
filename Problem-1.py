#  106. Construct Binary Tree from Inorder and Postorder Traversal
'''
Leetcode all test cases passed: Yes
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        n is the length of preorder
        h is the height of tree 
        Space Complexity: O(h)
        Time Complexity: O(n)
'''
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not postorder or not inorder:
            return None
        value = postorder[-1]
        root = TreeNode(value)
        idx = inorder.index(value)
        
        root.left = self.buildTree(inorder[:idx],postorder[:idx])
        root.right = self.buildTree(inorder[idx + 1 :],postorder[idx : -1])
        return root
