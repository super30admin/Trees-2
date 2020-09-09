// Time Complexity : O(n^2)
// Space Complexity : O(depth of tree)
// Did this code successfully run on Leetcode : Yes 
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def sumNumbers(self, root: TreeNode) -> int:
        
        def recurr(root,prev): # a DFS which travels every path.
                nonlocal output
                if root is None:
                    return 
                curr=prev*10+root.val
                if root.left is None and root.right is None: # when leaf is met, the sum is added to output
                    output+=curr
                    print(curr,output)
                    return

 
                recurr(root.left,curr) #left path
                recurr(root.right,curr) #right path
                
        output=0
        recurr(root,0)
        return output
        