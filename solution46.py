#Time Complexity:O(n)
#Space Complexity:O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:                                             
    result=0                                            #declaring the final sum
    def sumNumbers(self, root: TreeNode) -> int:
        self.helper(root,0)                             #calling the helper function for the tree withing initial sum as zero
        return self.result                              #reurning the final sum
    
    def helper(self,root:TreeNode,CSum:int) -> int:
        if root==None:                                  #if the tree is empty return
            return
        if (root.left==None and root.right==None):      #when leaf node return result updated with leaf node val
            self.result+=CSum*10+root.val
            return
        CSum=CSum*10+root.val                           #update the current sum with root value
        self.helper(root.left,CSum)                     #calculate the sum of left node
        self.helper(root.right,CSum)                    #calculte the sum of right node