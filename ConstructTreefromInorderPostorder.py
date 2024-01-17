#https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

#TimeComp: O(n)
#Space: O(h)
#in postorder we start with right first zue left->right->root, root comes at last and right follows it so naturally we start from back
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        #base contiion very important

        if not inorder or not postorder:
            return
        
       #root = TreeNode(postorder[len(postorder)-1])
        mid = inorder.index(postorder.pop())
        root = TreeNode(inorder[mid])
       #mid = inorder.index(root.val)
        #print(root)
        
        #print(postorder[mid:len(postorder)-1])
        # leftLen = len(inorder[:mid])
        root.right = self.buildTree(inorder[mid+1:], postorder)
        root.left = self.buildTree(inorder[:mid], postorder)
        
        return root        