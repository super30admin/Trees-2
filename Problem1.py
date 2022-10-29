# Time Complexity : O(n^2) n is the time in which the tree should be created 
# Space Complexity : O(n^2) here n is the size of creating the hashmap
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach : - Here we add the elements in the stack and keep the previous element in the a variable and if the previous is greater than the further element then we return false and stop the recursion


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) == 0 or postorder == None or len(inorder) == 0:
            return None
        
        rootVal = postorder[len(postorder)-1]
        root = TreeNode(rootVal)
        rootIdx = inorder.index(rootVal)


        leftInorder = inorder[:rootIdx]
        rightInorder = inorder[rootIdx+1:]
        leftPostorder = postorder[:len(leftInorder)]
        rightPostorder = postorder[len(leftInorder):len(postorder)-1]

        root.left = self.buildTree(leftInorder, leftPostorder)
        root.right = self.buildTree(rightInorder,rightPostorder )

        return root