# Trees-2

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
# Time Complexity=O(n)
# Space Complexity=O(n^2)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder:
            return None
        p = postorder.pop()
        i = inorder.index(p)
        root=TreeNode(p)
        root.right = self.buildTree(inorder[i+1:], postorder)
        root.left = self.buildTree(inorder[:i], postorder)
        return root


## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity=O(n)
# Space Complexity=O(height of tree)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        res=0
        def sumtree(root,number,res):
            if not root:
                return res
            if not root.left and not root.right:
                res+=number*10+root.val
                return res
            number=number*10+root.val
            res1=sumtree(root.left,number,res)
            res2=sumtree(root.right,number,res1)
            return res2
        return sumtree(root,0,0)
        
   
