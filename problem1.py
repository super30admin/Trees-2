# TC: O(n) - We process each node once and index lookups are O(1) due to the hashmap.
# SC: O(n) - Due to the recursion stack and hashmap storage.
# Approach: 
# 1. Use a hashmap to store indices of the inorder traversal.
# 2. The last element in postorder is the root. Recursively build the right subtree, then the left.
# 3. Recursively construct the tree by splitting the inorder array using the root's index.


class Solution(object):
    def buildTree(self, inorder, postorder):
        inorderIdx = {v:i for i, v in enumerate(inorder)}

        def helper(l, r):
            if l > r:
                return None
            
            root = TreeNode(postorder.pop())
            mid = inorderIdx[root.val]
            
            root.right = helper(mid+1, r)
            root.left = helper(l, mid-1)
            return root

        return helper(0, len(inorder)-1)
            