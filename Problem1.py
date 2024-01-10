'''

Time Complexity : O(n^2)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

We are recursively examining the inorder and postorder lists. We always find that root nood is always at the last in postorder
then using the element we find the index of the number in inorder and slice the inorder list. In inorder, the elements to the left
of root identifie forms theleft subtree and the elements to right form the right subtree

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if inorder == [] or postorder == []:
            return None

        root = TreeNode(postorder[-1])
        mid = inorder.index(postorder[-1])
        postorder.pop()
        root.left = self.buildTree(inorder[:mid],postorder[:mid])
        root.right = self.buildTree(inorder[mid+1:],postorder[mid:])

        return root


