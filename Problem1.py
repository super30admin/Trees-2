# Trees-2

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

# Approach
# Postorder traversal is Left->Right->Root. Last element in postorder list would be the root element. Find root in inorder list. All elements to its left would be left children and all elements to right would be right children
# Find the length of element to the right of root node in inorder list and use that length to find the right children the postorder and similarly for left children. It would be in reverse order
# Recrusively call the left and right children and for left pass postLeft,inLeft list and for right side pass postRight,inRight

# Time Complexity: O(n**2)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not postorder or not inorder:
            return

        rootval = postorder[-1]
        rootidx = -1
        for i in range(len(inorder)):
            if rootval == inorder[i]:
                rootidx = i
        
        root = TreeNode(rootval)

        inright = inorder[rootidx+1:]
        inleft = inorder[:rootidx]
        postright = postorder[-1-len(inright):-1]
        postleft = postorder[:-1-len(inright)]

        root.left = self.buildTree(inleft,postleft)
        root.right = self.buildTree(inright,postright)

        return root