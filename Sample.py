# Time Complexity : O(n)
# Space Complexity : O(h) h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Approach:
# Use postorder last element to find the root, search that root in inorder, left of rootidx is left tree and right of rootidx is right tree.
# in postorder, get right and left too and repeat until you find one root element. Add that as a TreeNode and return root

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.postidx = len(postorder)-1
        self.hashmap = {val:i for i, val in enumerate(inorder)}
        return self.helper(postorder, 0,len(inorder)-1)

    def helper(self,postorder, start, end):
        # base
        print(start,end)
        if start > end:
            return None

        # logic
        root = postorder[self.postidx]
        rootidx = self.hashmap[root]
        self.postidx -= 1

        # traversal
        root = TreeNode(root)
        root.right = self.helper(postorder, rootidx+1, end)
        root.left = self.helper(postorder, start, rootidx-1)

        return root
        
 
# Time Complexity : O(n)
# Space Complexity : O(h) h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Approach:
#Accumulate the number: As you traverse from root to leaf, you build the number by nodesum = nodesum * 10 + root.val. This effectively shifts digits left (e.g., 1 → 12 → 123).
#Leaf detection: When both root.left and root.right are None, you’ve reached a leaf. Add the accumulated nodesum to totalSum.
#Backtracking: The recursion naturally backtracks since nodesum is passed by value (not reference), so each recursive call maintains its own state.


        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.totalSum = 0
        self.helper(root, 0)
        return self.totalSum
    
    def helper(self,root,nodesum):
        if root is None:
            return

        nodesum = nodesum * 10 + root.val
        
        if root.left is None and root.right is None:
            self.totalSum += nodesum
            return

        self.helper(root.left, nodesum)
        self.helper(root.right,nodesum) 

               