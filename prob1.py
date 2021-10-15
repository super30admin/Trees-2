# Time Complexity : O(N) as we go through all N nodes
# Space Complexity : O(H) as max space used is height H of the tree
# Did this code successfully run on Leetcode : Yes, both
# Any problem you faced while coding this : coding the logic took a little time 

# explain your approach
# the last element in postorder gives the root and the elements to the left of this
# root element in inorder array give left subtree and on right give right subtree
# recursively apply this logic to get the binary tree



class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    def buildTree(self, inorder, postorder):

        def helper(inleft, inright):

            if inleft > inright:
                return None
            
            val = postorder.pop()
            root = TreeNode(val)

            root_idx = idx_map[val]

            root.right = helper(root_idx + 1, inright)
            root.left = helper(inleft, root_idx - 1)
            return root
        
        idx_map = { val: idx for idx, val in enumerate(inorder)}
        return helper(0, len(inorder) - 1)