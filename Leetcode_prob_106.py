#problem: 106. Construct Binary Tree from Inorder and Postorder Traversal
# time:  O(n)
# space: O(n)
#approach: 1. find the root value from the postorder list
#          2. find the root index from the inorder list
#          3. build the right subtree and left subtree recursively
#          4. return the root
#edge case: if the inorder list or postorder list is empty, return None


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
            if not inorder or not postorder:
                return None
            
            root_val = postorder.pop()
            root = TreeNode(root_val)
            
            root_index = inorder.index(root_val)
            
            root.right = self.buildTree(inorder[root_index + 1:], postorder)
            
            root.left = self.buildTree(inorder[:root_index], postorder)
            
            return root