# Leetcode problem link : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
# Time Complexity : O(n)
#  Space Complexity : O(maxdepth)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : O(n^2) => Recursion function by passing sliced arrays to every recursive call for finding root and left and right subtree for each subproblem. The issue here is finding the root in inorder array for each traversal
    
        Optimized approach: O(n) => The intuition behind this approach is postorder traversal will always have root node at the last position of the array.
        1. Find the index of root in inorder array
        2. Left subtree will be the size of inorder array from 0 to index
        3. Right subtree will be index to length of inorder array
        4. Right subtree size from step 3 can be used to get the postorder right subtree and rest will be left postorder subtree in postorder array
        5. Solve at each step recursively for each subtree.
        Here, hashmap can be used to optimize the search of index in inorder array.
        
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        in_map = {}
        
        for i,num in enumerate(inorder):
            in_map[num] = i
        
        return self.recursion(inorder,postorder,0,len(inorder)-1,0,len(postorder)-1,in_map)
    
    def recursion(self,inorder,postorder,inStart,inEnd,postStart,postEnd,in_map):
        if postStart > postEnd or inStart > inEnd:
            return None
        
        root = TreeNode(postorder[postEnd])
        
        index = in_map[root.val]
        
        rightSize = inEnd - index
        
        root.left = self.recursion(inorder,postorder,inStart,index-1,postStart,postEnd - rightSize - 1,in_map)
        root.right = self.recursion(inorder,postorder,index+1,inEnd,postEnd-rightSize,postEnd-1,in_map)
        
        return root
        