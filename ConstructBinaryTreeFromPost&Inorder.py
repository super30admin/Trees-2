#All TC on leetcode passed


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

         #Here we get root from postorder last element. We find that root index in inorder array. Now we call buildTree function using the postorder left, right and inorderleft, right arrays.
        #Time complexity - O(n^2) where we have to find the index
        #Space complexity - O(n) where we have to perform recussive calls n times

        if not inorder or not postorder:
            return

        root = TreeNode(postorder[-1])
        idx = inorder.index(postorder[-1])
        root.left = self.buildTree(inorder[:idx], postorder[:idx])
        root.right = self.buildTree(inorder[idx+1:], postorder[idx:-1])
        return root

        