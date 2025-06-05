# // Time Complexity : using array search copy it is o(n*h) worst case o(n2) otherwise with hashmap o(n) 
# // Space Complexity : o(nh) deep copy otherwise o(n)- hashmap
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : using hasmap for traccking inorder


# // Your code here along with comments explaining your approach
# approach 1 is to create copies of array and build the treee . last element in postorder will be the root and find the inorder from the array and build the left and right half
# we can optimize the search by maintaining the hashmap and searching the index in the inorder , after that traverse the right half forst and then left half because left - right - root since right is first 

# Definition for a binary tree node.
from typing import List , Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        idx = len(postorder)-1
        hmap = {}
        for i, a in enumerate(inorder):
            hmap[a] = i
        def helper(postorder,hmap,s,e):
            nonlocal idx
            if s>e: return None
            rootval = postorder[idx]
            idx-=1
            root = TreeNode(rootval)
            rootidx = hmap.get(rootval)
            root.right = helper(postorder, hmap, rootidx+1, e)
            root.left = helper(postorder, hmap, s, rootidx-1)
            return root

        
        return helper(postorder, hmap, 0, len(inorder)-1)
        