# Time Complexity: O(n^2)
# Space Complexity: O(n)

# Postorder: Left - Right - Root
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Base case: no nodes left to build
        if not inorder: 
            return None

        # Last element in postorder is always the root
        root_val = postorder[-1]
        idx = inorder.index(root_val) 

        # Create root node
        root = TreeNode(root_val)

        # Left subtree:
        # inorder[:idx] → left part of inorder
        # postorder[:idx] → corresponding left part of postorder
        root.left = self.buildTree(inorder[:idx], postorder[:idx])

        # Right subtree:
        # inorder[idx+1:] → right part of inorder
        # postorder[idx:-1] → right part of postorder (excluding root at end)
        root.right = self.buildTree(inorder[idx+1:], postorder[idx:-1])

        # Return the constructed root
        return root
