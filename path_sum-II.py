# Time Complexity:- O(n)
# Space Complexity:-O(h) h=height of the tree
# Approach:- DFS from the root node and have 2 variables- path and the sum of the path till now. Once we encounter a 
# leaf node- root.left and root.right is none, we check the if the sum of the path is equal to the target sum.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.res=[]
        def ps(root,path,sumn):
            if root is None:
                return
            if root.left is None and root.right is None and sumn+root.val==sum:
                path.append(root.val)
                self.res.append(path)
                return
            ps(root.left,path+[root.val],sumn+root.val)
            ps(root.right,path+[root.val],sumn+root.val)
        ps(root,[],0)
        return self.res