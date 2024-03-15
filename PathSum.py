#Time Complexity: O(n)
#Space Complexity: O(h)
# Key is to pass the value upto the node as a local argument and if it is leaf node add it to the result

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    FinalSum=0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helperBST(root,0)
        return self.FinalSum
    def helperBST(self,root, value):
        #Base
        if root is None:
            return
        #Logic
        global FinalSum
        pathsum=value*10+root.val
        #Check Leaf Node
        if root.left is None and root.right is None:
            self.FinalSum=self.FinalSum+pathsum
        self.helperBST(root.left,pathsum)
        self.helperBST(root.right,pathsum)

#Int based recurssion
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.intHelper(root,0)
    def intHelper(self,node,current):
        #Base
        if node is None:
            return 0
        #Logic
        current=current*10+node.val
        if node.left is None and node.right is None:
            return current
        #left
        case1=self.intHelper(node.left, current)
        #right
        case2=self.intHelper(node.right, current)
        return case1+case2


    