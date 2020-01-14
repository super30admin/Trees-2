// Time Complexity : o(n^2)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Brute Force Approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not postorder or not inorder:
            return None
        rootVal=postorder[-1]
        root=TreeNode(rootVal)
        for i in range(len(inorder)):
            if(inorder[i]==postorder[-1]):
                index=i
                break
        root.left=self.buildTree(inorder[0:index],postorder[0:index])
        root.right=self.buildTree(inorder[index+1:],postorder[index:len(postorder)-1])
        return root
        
